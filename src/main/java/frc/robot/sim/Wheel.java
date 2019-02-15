package frc.robot.sim;

import java.util.ArrayList;

import frc.robot.utilities.CMath;

public class Wheel {
  public static final double kTorqueLoss = 0.9;

  private double mRadius; // unit is meters!
  private double mInertia;
  private double mAngularPosition; // in rad
  private double mAngularVelocity; // in rad/s
  private double mAngularAcceleration;
  private double mReduction;

  private ArrayList<MotorSim> mMotors;

  // reduction should be input/output
  public Wheel(double radius, double inertia, double reduction, MotorSim motor, MotorSim... motors) {
    mRadius = radius;
    mInertia = inertia;
    mReduction = reduction;
    mMotors = new ArrayList<>();
    mMotors.add(motor);
    for (MotorSim m : motors) {
      mMotors.add(m);
    }
  }

  public void update(double v, double dt) {
    double torqueTotal = 0;
    for (MotorSim motor : mMotors) {
      // angular velocity here must be in RPM
      torqueTotal += motor.calculateTorque(v, CMath.convertRPStoRPM(mAngularVelocity * mReduction));
    }
    // double torqueLoss = -1 * Math.signum(mAngularVelocity) * 2.5 * v / 12;
    torqueTotal *= mReduction;
    torqueTotal -= 0.1 * (mAngularAcceleration * mInertia);
    torqueTotal = CMath.epsilon(torqueTotal * kTorqueLoss);
    // rads /s /s
    double angularAccel = torqueTotal / mInertia;
    mAngularAcceleration = angularAccel;

    // rads /s
    mAngularVelocity = (mAngularVelocity + (CMath.epsilon(angularAccel) * dt) / mReduction);
    // rads
    mAngularPosition += mAngularVelocity * dt;
  }

  public double position() {
    return mAngularPosition;
  }

  public double velocity() {
    return mAngularVelocity;
  }

  public double radius() {
    return mRadius;
  }

  @Override
  public String toString() {
    String position = String.format("%.2f", mAngularPosition);
    String velocity = String.format("%.2f", CMath.convertRPStoRPM(mAngularVelocity));
    return "Position: " + position + " | RPM: " + velocity;
  }
}