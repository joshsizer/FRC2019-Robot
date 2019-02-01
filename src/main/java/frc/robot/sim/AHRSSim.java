package frc.robot.sim;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;

public class AHRSSim extends AHRS {

  double angle;

  public AHRSSim(I2C.Port port) {
    super(port);
  }

  @Override
  public double getAngle() {
    return angle;
  }

  @Override
  public void setAngleAdjustment(double adjustment) {
    angle = adjustment;
  }

  @Override
  public void reset() {
    angle = 0;
  }

  @Override
  public boolean isCalibrating() {
    return false;
  }
}
