package frc.robot.sim;

import edu.wpi.first.wpilibj.Spark;

public class SparkSim extends Spark {

  // [-1, 1]
  double speed;

  public SparkSim(int port) {
    super(port);
  }

  @Override
  public void set(double speed) {
    this.speed = speed;
  }

  @Override
  public double get() {
    return speed;
  }

  @Override
  public void stopMotor() {
    // speed = 0;
  }
}
