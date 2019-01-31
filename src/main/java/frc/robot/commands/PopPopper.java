package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Popper;

public class PopPopper extends Command {
  Popper mPopper;

  public PopPopper() {
    mPopper = Robot.Popper;
    setInterruptible(true);
  }

  @Override
  protected void initialize() {
    mPopper.pop();
  }

  @Override
  protected void execute() {

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
