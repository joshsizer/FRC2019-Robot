package frc.robot.sim;

public abstract class MotorSim {

  private MotorSimConfig mConfig;

  // assuming a 12 volt reference voltage
  private static double kReferenceVoltage = 12;

  // CIM constants
  public static double kCIMStallTorque = 2.41; // N * m
  public static double kCIMFreeSpeed = 5330; // RPM

  // 775 Pro constants
  public static double k775ProStallTorque = 0.71; // N * m
  public static double k775ProFreeSpeed = 18730; // RPM

  public static class MotorSimConfig {
    private double mStallTorque;
    private double mFreeSpeed;
    private double mReferenceVoltage;

    public MotorSimConfig(double stallTorque, double freeSpeed, double referenceVoltage) {
      mStallTorque = stallTorque;
      mFreeSpeed = freeSpeed;
      mReferenceVoltage = referenceVoltage;
    }
  }

  public MotorSim(double stallTorque, double freeSpeed, double referenceVoltage) {
    this(new MotorSimConfig(stallTorque, freeSpeed, referenceVoltage));
  }

  public MotorSim(MotorSimConfig config) {
    this.mConfig = config;
  }

  private double calculateFreeSpeed(double v) {
    return v * mConfig.mFreeSpeed / mConfig.mReferenceVoltage;
  }

  private double calculateStallTorque(double v) {
    return v * mConfig.mStallTorque / mConfig.mReferenceVoltage;
  }

  /**
   * 
   * @param v            commanded voltage
   * @param rotationRate in RPM
   * @return The torque output of this motor at the given voltage and RPM
   */
  public double calculateTorque(double v, double rotationRate) {
    double stallTorque = calculateStallTorque(v);
    double slope = -stallTorque / calculateFreeSpeed(v);
    return slope * rotationRate + stallTorque;
  }

  public static MotorSimConfig CIMConfig() {
    return new MotorSimConfig(kCIMStallTorque, kCIMFreeSpeed, kReferenceVoltage);
  }

  public static MotorSimConfig 775ProConfig() {
    return new MotorSimConfig(k775ProStallTorque, k775ProFreeSpeed, kReferenceVoltage);
  }
}