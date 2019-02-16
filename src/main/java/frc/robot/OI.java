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
import frc.robot.commands.AutoAim;
import frc.robot.commands.PopPopper;
import frc.robot.commands.TurnToAngle;
import frc.robot.utilities.CMath;
import frc.robot.utilities.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static XboxController mDriverController;
  public static XboxController mOperatorController;

  public TurnToAngle mTurnToAngle;
  public PIDController mTurnToAngleController;
  public AutoAim mAutoAim;

  public static boolean mLastDriverLeftTrigger = false;
  public static boolean mLastDriverRightTrigger = false;

  public OI() {
    mDriverController = new XboxController(RobotMap.kDriverControllerPort);
    mOperatorController = new XboxController(RobotMap.kOperatorControllerPort);

    // set our commands for each button
    // mDriverController.ButtonA.whileHeld(new PopPopper());
  }

  public void run() {

    // get the driver's left and right sticks, apply exponential filter
    // and apply deadband
    // double leftStickY = -1.0 * mDriverController.getLeftYAxis();
    // double rightStickX = mDriverController.getRightXAxis();

    // double leftStickY = -0.7 * mDriverController.getLeftYAxis();
    // double rightStickY = -0.7 * mDriverController.getRightYAxis();

    // leftStickY = CMath.exponentialFilter(leftStickY);
    // rightStickY = CMath.exponentialFilter(rightStickY);
    // leftStickY = CMath.applyDeadband(RobotMap.kDriverDeadband, leftStickY);
    // rightStickY = CMath.applyDeadband(RobotMap.kDriverDeadband, rightStickY);

    double leftStickY = -1.0 * mDriverController.getLeftYAxis();
    double leftStickX = 1.0 * mDriverController.getRightXAxis();

    // leftStickY = CMath.exponentialFilter(leftStickY);
    // leftStickY = CMath.applyDeadband(RobotMap.kDriverDeadband, leftStickY);
    // leftStickX = CMath.exponentialFilter(leftStickX);
    // leftStickX = CMath.applyDeadband(RobotMap.kDriverDeadband, leftStickX);

    Robot.Drive.setSpeedTurn(leftStickY, leftStickX);

    if (mDriverController.getAButton()) {
      Robot.Popper.pop();
    } else {
      Robot.Popper.retract();
    }

    if (mOperatorController.getAButton()) {
      Robot.Arm.retract();
    } else {
      Robot.Arm.extend();
    }

    if (mDriverController.getXButton()) {
      Robot.Jumper.popFront();
    } else {
      Robot.Jumper.retractFront();
    }

    if (mDriverController.getYButton()) {
      Robot.Jumper.popBack();
    } else {
      Robot.Jumper.retractBack();
    }

    if (mDriverController.getLeftTrigger() && !mLastDriverLeftTrigger) {
      new AutoAim().start();
    }

    if (mDriverController.getRightTrigger() && !mLastDriverRightTrigger) {
      new TurnToAngle(SmartDashboard.getNumber("turn_to_angle_setpoint", Robot.Drive.getYaw())).start();
    } else if (mLastDriverRightTrigger) {
      Robot.Drive.getCurrentCommand().cancel();
    }

    mLastDriverLeftTrigger = mDriverController.getLeftTrigger();
    mLastDriverRightTrigger = mDriverController.getRightTrigger();
  }

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
