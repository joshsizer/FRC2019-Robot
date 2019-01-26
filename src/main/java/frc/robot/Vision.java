package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Vision {

  public static double getTargetAngle(double defaultValue) {
    return SmartDashboard.getNumber("target_angle", defaultValue);
  }

  public static boolean foundTarget(boolean defaultValue) {
    return SmartDashboard.getBoolean("target_found", defaultValue);
  }

}
