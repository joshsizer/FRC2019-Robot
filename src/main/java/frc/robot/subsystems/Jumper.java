/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Jumper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // 1 and 2 = front solenoids
  private DoubleSolenoid mSolenoid1;
  private DoubleSolenoid mSolenoid2;
  // 3 = back solenoid
  private DoubleSolenoid mSolenoid3;

  public Jumper() {
    mSolenoid1 = new DoubleSolenoid(RobotMap.kJumperDoubleSolen1Module,
        RobotMap.kJumperDoubleSolen1Forw, RobotMap.kJumperDoubleSolen1Reverse);
    mSolenoid2 = new DoubleSolenoid(RobotMap.kJumperDoubleSolen2Module,
        RobotMap.kJumperDoubleSolen2Forw, RobotMap.kJumperDoubleSolen2Reverse);
    mSolenoid3 = new DoubleSolenoid(RobotMap.kJumperDoubleSolen3Module,
        RobotMap.kJumperDoubleSolen3Forw, RobotMap.kJumperDoubleSolen3Reverse);
  }

  public void popFront() {
    setFront(true);
  }

  public void retractFront() {
    setFront(false);
  }

  public void popBack() {
    setBack(true);
  }

  public void retractBack() {
    setBack(false);
  }

  private void setFront(boolean forward) {
    if (forward) {
      mSolenoid1.set(Value.kForward);
      mSolenoid2.set(Value.kForward);
    } else {
      mSolenoid1.set(Value.kReverse);
      mSolenoid2.set(Value.kReverse);
    }
  }

  private void setBack(boolean forward) {
    if (forward) {
      mSolenoid3.set(Value.kForward);
    } else {
      mSolenoid3.set(Value.kReverse);
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
