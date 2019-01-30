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
    super.setInputRange(0, 360);
    mController = super.getPIDController();
    mController.setAbsoluteTolerance(RobotMap.turnToAngleTolerance);
    mController.setContinuous(true);
    mController.setOutputRange(RobotMap.turnToAngleMinOutput, RobotMap.turnToAngleMaxOutput);
    mController.setSetpoint(angle);
    SmartDashboard.putData("Turn to Angle PID", mController);

    mDrive = Robot.Drive;
    requires(mDrive);
  }

  @Override
  protected void setInputRange(double minimumInput, double maximumInput) {
    super.setInputRange(minimumInput, maximumInput);
  }

  @Override
  protected void initialize() {
    super.initialize();

    // pid controller starts
  }

  @Override
  protected void execute() {
    super.execute();
  }

  @Override
  protected boolean isFinished() {
    return mController.onTarget();
  }

  @Override
  protected void end() {
    super.end();
    mDrive.setSpeedTurn(0.0, 0.0);
  }

  @Override
  protected void interrupted() {
    super.interrupted();
  }

  @Override
  protected double returnPIDInput() {
    return mDrive.getYaw();
  }

  @Override
  protected void usePIDOutput(double output) {
    mDrive.setSpeedTurn(0.0, output);
  }

  public PIDController getController() {
    return mController;
  }
}
