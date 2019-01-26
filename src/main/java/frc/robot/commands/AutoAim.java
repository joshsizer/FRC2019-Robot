package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.Vision;

public class AutoAim extends TurnToAngle {

  public AutoAim() {
    super(Vision.getTargetAngle(Robot.Drive.getYaw()));
  }
}
