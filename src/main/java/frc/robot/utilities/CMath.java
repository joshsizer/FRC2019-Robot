package frc.robot.utilities;

public class CMath {

  public static double getAngle0to360(double angle) {
    while (angle >= 360) {
      angle -= 360;
    }
    while (angle < 0) {
      angle += 360;
    }
    return angle;
  }

  /**
   * The sign of the input will stay the same, but deadband should be a positive number
   * 
   * @param deadband
   * @param input
   * @return
   */
  public static double applyDeadband(double deadband, double input) {
    deadband = Math.abs(deadband);

    if (Math.abs(input) < deadband) {
      return 0.0;
    } else {
      return input;
    }
  }

  public static double exponentialFilter(double input) {
    double sign = 1.0;
    if (input < 0) {
      sign = -1.0;
    }

    return sign * input * input;
  }
}
