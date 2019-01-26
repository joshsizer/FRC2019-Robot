package frc.robot.utilities;

public class CMath {

  public static double getAngle0to360(double angle) {
    while (angle >= 360) {
      angle -= 360;
    }
    while (angle < 0) {
      angle += 360;
    }
  }
}
