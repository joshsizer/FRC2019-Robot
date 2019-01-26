package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Popper extends Subsystem {

  private DoubleSolenoid mSolenoid1;

  public Popper() {
    mSolenoid1 =
        new DoubleSolenoid(RobotMap.kPopperDoubSolen1Forw, RobotMap.kPopperDoubSolen1Reverse);
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
    } else {
      mSolenoid1.set(Value.kReverse);
    }
  }

  @Override
  protected void initDefaultCommand() {

  }

}
