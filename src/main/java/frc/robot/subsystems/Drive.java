package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import frc.robot.RobotMap;
import frc.robot.utilities.CMath;

public class Drive extends Subsystem {

  AHRS navx;

  Spark mLeftDriveMotor1;
  Spark mLeftDriveMotor2;
  Spark mRightDriveMotor1;
  Spark mRightDriveMotor2;

  DifferentialDrive mDiffDrive;

  public Drive() {
    try {
      navx = new AHRS(SPI.Port.kMXP);
    } catch (RuntimeException e) {
      DriverStation.reportError("Error instantiating navx MXP: " + e.getMessage(), true);
    }

    mLeftDriveMotor1 = new Spark(RobotMap.kLeftMotor1);
    mLeftDriveMotor2 = new Spark(RobotMap.kLeftMotor2);
    mRightDriveMotor1 = new Spark(RobotMap.kRightMotor1);
    mRightDriveMotor2 = new Spark(RobotMap.kRightMotor2);

    // mRightDriveMotor1.setInverted(true);
    // mRightDriveMotor2.setInverted(true);

    SpeedControllerGroup leftContGroup = new SpeedControllerGroup(mLeftDriveMotor1, mLeftDriveMotor2);
    SpeedControllerGroup rightContGroup = new SpeedControllerGroup(mRightDriveMotor1, mRightDriveMotor2);

    mDiffDrive = new DifferentialDrive(leftContGroup, rightContGroup);
  }

  @Override
  protected void initDefaultCommand() {

  }

  public void setSpeedTurn(double speed, double turn) {
    mDiffDrive.curvatureDrive(speed, turn, true);
    // setLeft(speed + turn);
    // setRight(speed - turn);
  }

  public void setSpeedLeftRight(double left, double right) {
    setLeft(left);
    setRight(right);
  }

  private void setLeft(double speed) {
    mLeftDriveMotor1.set(speed);
    mLeftDriveMotor2.set(speed);
  }

  private void setRight(double speed) {
    mRightDriveMotor1.set(speed);
    mRightDriveMotor2.set(speed);
  }

  public void set(double speed) {
    mLeftDriveMotor2.set(speed);
  }

  /**
   * the yaw of the robot, in degrees
   */
  public double getYaw() {
    return CMath.getAngle0to360(navx.getAngle());
  }
}
