package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Popper extends Subsystem {

  private DoubleSolenoid mSolenoid1;
  private DoubleSolenoid mSolenoid2;

  public Popper() {
    super("Popper");
    mSolenoid1 =
        new DoubleSolenoid(RobotMap.kPopperDoubSolen1Forw, RobotMap.kPopperDoubSolen1Reverse);
    mSolenoid2 =
        new DoubleSolenoid(RobotMap.kPopperDoubSolen2Forw, RobotMap.kPopperDoubSolen2Reverse);
    mSolenoid1.setSubsystem("Popper");
    mSolenoid1.setName("Popper Piston 1");
    addChild(mSolenoid1);
    mSolenoid2.setSubsystem("Popper");
    mSolenoid2.setName("Popper Piston 2");
    addChild(mSolenoid2);
  }

  public void pop() {
    set(true);
  }

  public void retract() {
    set(false);
  }

  private void set(boolean forward) {
    if (forward) {
      mSolenoid1.set(Value.kForward);
      mSolenoid2.set(Value.kForward);
    } else {
      mSolenoid1.set(Value.kReverse);
      mSolenoid2.set(Value.kReverse);
    }
  }

  @Override
  protected void initDefaultCommand() {

  }

}
