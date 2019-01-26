package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Popper;

public class PopPopper extends Command {
  Popper mPopper;

  public PopPopper() {
    mPopper = Robot.Popper;
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    System.out.println("Executing PopPopper command!");
    mPopper.pop();
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {
    // nothing to do
  }

  @Override
  protected void interrupted() {
    // nothing to do
  }
}
