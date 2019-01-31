package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drive;

public class TurnToAngle extends PIDCommand {

  Drive mDrive;
  PIDController mController;

  public TurnToAngle(double angle) {
    super(RobotMap.turnToAnglePIDName, RobotMap.turnToAnglekP, RobotMap.turnToAnglekI,
        RobotMap.turnToAngleKD);
    super.setInputRange(0, 359.999);
    mController = super.getPIDController();
    mController.setAbsoluteTolerance(RobotMap.turnToAngleTolerance);
    mController.setContinuous(true);
    mController.setOutputRange(-RobotMap.turnToAngleMaxOutput, RobotMap.turnToAngleMaxOutput);
    mController.setSetpoint(angle);
    mController.setF(0);

    SmartDashboard.putData("Turn to Angle PID", mController);
    mDrive = Robot.Drive;

    setInterruptible(true);
    requires(mDrive);
  }

  @Override
  protected void setInputRange(double minimumInput, double maximumInput) {
    super.setInputRange(minimumInput, maximumInput);
  }

  @Override
  protected void initialize() {
    // pid controller starts
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    return mController.onTarget();
  }

  @Override
  protected void end() {
    mDrive.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }

  @Override
  protected double returnPIDInput() {
    return mDrive.getYaw();
  }

  @Override
  protected void usePIDOutput(double output) {
    if (Math.abs(output) < RobotMap.turnToAngleMinOutput) {
      output = Math.copySign(RobotMap.turnToAngleMinOutput, output);
    }
    mDrive.arcadeDrive(0, output, false);
  }

  public PIDController getController() {
    return mController;
  }
}
