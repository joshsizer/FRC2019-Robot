/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.AutoAim;
import frc.robot.commands.ExtendArm;
import frc.robot.commands.PopPopper;
import frc.robot.commands.RetractArm;
import frc.robot.commands.RetractPopper;
import frc.robot.commands.TurnToAngle;
import frc.robot.utilities.CMath;
import frc.robot.utilities.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands
 * and command groups that allow control of the robot.
 */
public class OI {
  public XboxController mDC; // short for mDriverController

  public TurnToAngle mTurnToAngle;
  public PIDController mTurnToAngleController;
  public AutoAim mAutoAim;

  public OI() {
    mDC = new XboxController(RobotMap.kDriverControllerPort);

    if (Robot.isReal()) {

      mDC.getAButtonObject().whenPressed(new PopPopper());
      mDC.getAButtonObject().whenReleased(new RetractPopper());

      mDC.getBButtonObject().whenPressed(new ExtendArm());
      mDC.getBButtonObject().whenReleased(new RetractArm());


      mDC.getRightBumperObject().whenPressed(new AutoAim());
      mDC.getRightBumperObject().whenReleased(Robot.Drive.getDefaultCommand());
    }
  }

  public void run() {
    // does nothing right now
  }
}
