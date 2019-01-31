/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drive;
import frc.robot.utilities.XboxController;

public class ArcadeDrive extends Command {

  private Drive mDrive;
  private XboxController mDC;
  private double xSpeed;
  private double zRotation;

  public ArcadeDrive() {
    super("Arcade Drive");
    mDrive = Robot.Drive;
    mDC = Robot.OI.mDC;
    requires(mDrive);
    setInterruptible(true);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // nothing to do here!
  }

  /**
   * Commands the drive base to move based on Arcade Drive
   * inputs from the driver controller.
   */
  @Override
  protected void execute() {
    xSpeed = mDC.getLeftYAxis();
    zRotation = mDC.getLeftXAxis();
    mDrive.arcadeDrive(xSpeed, zRotation, true);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    mDrive.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}