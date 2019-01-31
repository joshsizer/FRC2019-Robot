package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.I2C;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;
import frc.robot.sim.AHRSSim;
import frc.robot.sim.SparkSim;
import frc.robot.utilities.CMath;

public class Drive extends Subsystem {

  AHRS navx;

  SpeedControllerGroup mLeftMotors;
  SpeedControllerGroup mRightMotors;

  DifferentialDrive mDiffDrive;

  double left;
  double right;

  public Drive() {
    super("Drive");
    if (Robot.isReal()) {
      navx = new AHRS(I2C.Port.kMXP);
    } else {
      navx = new AHRSSim(I2C.Port.kMXP);
    }

    if (Robot.isReal()) {
      mLeftMotors = new SpeedControllerGroup(new Spark(RobotMap.kLeftMotor1),
          new Spark(RobotMap.kLeftMotor2));
      mRightMotors = new SpeedControllerGroup(new Spark(RobotMap.kRightMotor1),
          new Spark(RobotMap.kRightMotor2));
    } else {
      mLeftMotors = new SpeedControllerGroup(new SparkSim(RobotMap.kLeftMotor1),
          new SparkSim(RobotMap.kLeftMotor2));
      mRightMotors = new SpeedControllerGroup(new SparkSim(RobotMap.kRightMotor1),
          new SparkSim(RobotMap.kRightMotor2));
    }

    mLeftMotors.setSubsystem("Drive");
    mRightMotors.setSubsystem("Drive");
    mDiffDrive = new DifferentialDrive(mLeftMotors, mRightMotors);
    mDiffDrive.setSubsystem("Drive");
    mDiffDrive.setDeadband(0.0);
    addChild(mDiffDrive);
  }

  @Override
  protected void initDefaultCommand() {
    // setDefaultCommand(new ArcadeDrive());
  }

  public void arcadeDrive(double xSpeed, double zRotation, boolean sqareInput) {
    mDiffDrive.arcadeDrive(xSpeed, zRotation, sqareInput);
  }

  public void curvatureDrive(double xSpeed, double zRotation, boolean isQuickTurn) {
    mDiffDrive.curvatureDrive(xSpeed, zRotation, isQuickTurn);
  }

  public void setLeftRight(double leftSpeed, double rightSpeed, boolean squareInputs) {
    mDiffDrive.tankDrive(leftSpeed, rightSpeed, squareInputs);
  }

  public void stop() {
    // mDiffDrive.stopMotor();
  }

  /**
   * the yaw of the robot, in degrees
   */
  public double getYaw() {
    return CMath.getAngle0to360(navx.getAngle());
  }

  public void resetGyro() {
    navx.reset();
  }

  public boolean isGyroCalibrating() {
    return navx.isCalibrating();
  }

  public double getPWMLeft() {
    return mLeftMotors.get();
  }

  public double getPWMRight() {
    return mRightMotors.get();
  }

  @Override
  public void periodic() {
    navx.setAngleAdjustment(getYaw() + 0.01);
    System.out.println("getPWMRight():" + getPWMRight());
    curvatureDrive(left, right, false);
    left += 0.001;
    right += 0.001;
  }
}
