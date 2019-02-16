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
    mSolenoid1 = new DoubleSolenoid(RobotMap.kPopperDoubleSolen1Module,
        RobotMap.kPopperDoubSolen1Forw, RobotMap.kPopperDoubSolen1Reverse);
    mSolenoid2 = new DoubleSolenoid(RobotMap.kPopperDoubleSolen2Module,
        RobotMap.kPopperDoubSolen2Forw, RobotMap.kPopperDoubSolen2Reverse);
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
