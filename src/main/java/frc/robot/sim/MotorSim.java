package frc.robot.sim;

public abstract class MotorSim {

  private double mStallTorque;
  private double mFreeSpeed;
  private double mReferenceVoltage;
  private double mDt;

  // angular position
  private double mPosition;
  // derivative of theta with respect to time
  private double mSpeed;

  private double mInertia;

  public MotorSim(double stallTorque, double freeSpeed, double referenceVoltage, double dt) {
    mStallTorque = stallTorque;
    mFreeSpeed = freeSpeed;
    mDt = dt;
    mReferenceVoltage = referenceVoltage;
  }

  private double calculateFreeSpeed(double v) {
    return v * mFreeSpeed / mReferenceVoltage;
  }

  private double calculateStallTorque(double v) {
    return v * mStallTorque / mReferenceVoltage;
  }

  public double calculateTorque(double v, double rotationRate) {
    double stallTorque = calculateStallTorque(v);
    double slope = -stallTorque / calculateFreeSpeed(v);
    return slope * rotationRate + stallTorque;
  }

  public void update(double v) {
    double torque = calculateTorque(v, mSpeed) / mInertia;
    mSpeed = mSpeed + torque * mDt;
    mPosition = mPosition + mSpeed * mDt;
  }
}