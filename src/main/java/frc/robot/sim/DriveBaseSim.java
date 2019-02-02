package frc.robot.sim;

import frc.robot.utilities.CMath;

public class DriveBaseSim {
  private Wheel mLeftWheel;
  private Wheel mRightWheel;

  private double mX;
  private double mY;
  private double mVel;
  private double mHeading;

  private final double mWidth;
  private final double mDt;

  public DriveBaseSim(double width, double dt, Wheel left, Wheel right) {
    mWidth = width;
    mDt = dt;
    mLeftWheel = left;
    mRightWheel = right;
  }

  public void update(double vL, double vR) {
    mLeftWheel.update(vL, mDt);
    // System.out.println(mLeftWheel);
    mRightWheel.update(vR, mDt);
    // System.out.println(mRightWheel);

    double newVelL = RPStoFPS(mLeftWheel.velocity(), mLeftWheel.radius());
    System.out.println(newVelL);
    double newVelR = RPStoFPS(mRightWheel.velocity(), mLeftWheel.radius());

    double dtheta = (1 / mWidth) * (newVelR - newVelL);
    mHeading += dtheta * mDt;
    double mVel = 0.5 * (newVelL + newVelR);

    mX += (mVel * Math.cos(mHeading) * mDt);
    mY += (mVel * Math.sin(mHeading) * mDt);
  }

  public double RPStoMPS(double rps, double radius) {
    return rps / 2 / Math.PI * radius;
  }

  public double metersToFeet(double meters) {
    return 3.28084 * meters;
  }

  public double RPStoFPS(double rps, double radius) {
    return metersToFeet(RPStoMPS(rps, radius));
  }

  @Override
  public String toString() {
    return "X: " + String.format("%.2f", mX) + " | Y: " + String.format("%.2f", mY) + " | 0: "
        + String.format("%.2f", CMath.getAngle0to360(mHeading * 180 / Math.PI));
  }

}