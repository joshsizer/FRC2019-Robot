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

  public static int kRightMotor1 = 0;
  public static int kRightMotor2 = 3;
  public static int kLeftMotor1 = 1;
  public static int kLeftMotor2 = 2;

  public static int kPopperDoubSolen1Forw = 0;
  public static int kPopperDoubSolen1Reverse = 1;


  // public static int leftMotor = 1;
  // public static int rightMotor = 2;


}
