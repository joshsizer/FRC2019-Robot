/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into to a variable name.
 * This provides flexibility changing wiring, makes checking the wiring easier and significantly
 * reduces the number of magic numbers floating around.
 */
public class RobotMap {
  public static int kDriverControllerPort = 0;
  public static int kOperatorControllerPort = 1;
  public static double kDriverDeadband = 0.1;

  public static int kRightMotor1 = 2;
  public static int kRightMotor2 = 3;
  public static int kLeftMotor1 = 0;
  public static int kLeftMotor2 = 1;

  public static int kPopperDoubSolen1Forw = 0;
  public static int kPopperDoubSolen1Reverse = 1;
  public static int kPopperDoubleSolen1Module = 1;
  public static int kPopperDoubSolen2Forw = 2;
  public static int kPopperDoubSolen2Reverse = 3;
  public static int kPopperDoubleSolen2Module = 1;

  public static int kArmDoubleSolen1Forw = 1;
  public static int kArmDoubleSolen1Reverse = 0;
  public static int kArmDoubleSolen1Module = 0;

  public static int kJumperDoubleSolen1Forw = 7;
  public static int kJumperDoubleSolen1Reverse = 6;
  public static int kJumperDoubleSolen1Module = 0;
  public static int kJumperDoubleSolen2Forw = 5;
  public static int kJumperDoubleSolen2Reverse = 4;
  public static int kJumperDoubleSolen2Module = 0;
  public static int kJumperDoubleSolen3Forw = 2;
  public static int kJumperDoubleSolen3Reverse = 3;
  public static int kJumperDoubleSolen3Module = 0;

  public static double turnToAnglekP = 1.0;
  public static double turnToAnglekI = 0.0;
  public static double turnToAngleKD = 0.1;
  public static double turnToAngleMinOutput = 0.2;
  public static double turnToAngleMaxOutput = 0.5;
  public static double turnToAngleTolerance = 0.5;
  public static String turnToAnglePIDName = "Turn to Angle PID";

  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

}
