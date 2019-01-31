package frc.robot.utilities;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Wrapper class for Joystick, since we must use
 * Joystick and JoystickButton to interface with
 * the Command scheduler.
 * 
 * @author Joshua Sizer
 * @since 1/30/2019
 */
public class XboxController {

    /**
     * Mapping of raw button addresses to usable names.
     * You can verify/change this mapping by plugging in a 
     * joystick/controller, moving the sticks/pressing buttons, 
     * and the corresponding adress will light up in the
     * driver station. It seems that the axis' are 0-indexed,
     * while the buttons are 1-indexed.
     */
    private enum Mapping {
        kBumperLeft(5),
        kBumperRight(6),
        kTriggerLeft(2),
        kTriggerRight(3),
        kStickLeftX(0),
        kStickLeftY(1),
        kStickRightX(4),
        kStickRightY(5),
        kA(1),
        kB(2),
        kX(3),
        kY(4),
        kBack(7),
        kStart(8);
        
        @SuppressWarnings({"MemberName", "PMD.SingularField"})
        private final int value;

        Mapping(int value) {
            this.value = value;
        }
    }

    /**
     * Our native Joystick object. We could have this class
     * extend joystick, but I'm trying to keep this as clean
     * as possible.
     */
    Joystick mJoystick;

    /**
     * These are our button objects. With these objects,
     * you can bind commands to specific button presses.
     */
    Button mButtonA, mButtonB, mButtonX, mButtonY,
           mButtonLBumper, mButtonRBumper,
           mButtonBack, mButtonStart;

    public XboxController(int port) {
        mJoystick = new Joystick(port);
        
        mButtonA = new JoystickButton(mJoystick, Mapping.kA.value);
        mButtonB = new JoystickButton(mJoystick, Mapping.kB.value);
        mButtonX = new JoystickButton(mJoystick, Mapping.kX.value);
        mButtonY = new JoystickButton(mJoystick, Mapping.kY.value);

        mButtonLBumper = new JoystickButton(mJoystick, Mapping.kBumperLeft.value);
        mButtonRBumper = new JoystickButton(mJoystick, Mapping.kBumperRight.value);

        mButtonBack = new JoystickButton(mJoystick, Mapping.kBack.value);
        mButtonStart = new JoystickButton(mJoystick, Mapping.kStart.value);
    }

    /**
     * Gets the left stick's X-axis. Pushing up returns a positive value.
     * Note that this is slightly different than the default implementation, 
     * which by convention for joysticks returns a negative value for up.
     * This convention is stupid, so I am negating here instead of elsewhere.
     * 
     * @return The left stick's current x-axis value [-1, 1]
     */
    public double getLeftXAxis() {
        return -1.0 * mJoystick.getRawAxis(Mapping.kStickLeftX.value);
    }

    /**
     * Gets the left stick's Y-axis. Pushing up returns a positive value.
     * Note that this is slightly different than the default implementation, 
     * which by convention for joysticks returns a negative value for up.
     * This convention is stupid, so I am negating here instead of elsewhere.
     * 
     * @return The left stick's current y-axis value [-1, 1]
     */
    public double getLeftYAxis() {
        return -1.0 * mJoystick.getRawAxis(Mapping.kStickLeftY.value);
    }

    /**
     * Gets the right stick's X-axis. Pushing up returns a positive value.
     * Note that this is slightly different than the default implementation, 
     * which by convention for joysticks returns a negative value for up.
     * This convention is stupid, so I am negating here instead of elsewhere.
     * 
     * @return The right stick's current x-axis value [-1, 1]
     */
    public double getRightXAxis() {
        return -1.0 * mJoystick.getRawAxis(Mapping.kStickRightX.value);
    }

    /**
     * Gets the right stick's Y-axis. Pushing up returns a positive value.
     * Note that this is slightly different than the default implementation, 
     * which by convention for joysticks returns a negative value for up.
     * This convention is stupid, so I am negating here instead of elsewhere.
     * 
     * @return The right stick's current y-axis value [-1, 1]
     */
    public double getRightYAxis() {
        return -1.0 * mJoystick.getRawAxis(Mapping.kStickRightY.value);
    }

    /**
     * Get the A button's state.
     * 
     * @return true for pressed, false otherwise
     */
    public boolean getAButton() {
        return mButtonA.get();
    }

    /**
     * Get the B button's state.
     * 
     * @return true for pressed, false otherwise
     */
    public boolean getBButton() {
        return mButtonB.get();
    }

    /**
     * Get the X button's state.
     * 
     * @return true for pressed, false otherwise
     */
    public boolean getXButton() {
        return mButtonX.get();
    }

    /**
     * Get the Y button's state.
     * 
     * @return true for pressed, false otherwise
     */
    public boolean getYButton() {
        return mButtonY.get();
    }

    /**
     * Get the start button's state.
     * 
     * @return true for pressed, false otherwise
     */
    public boolean getStartButton() {
        return mButtonStart.get();
    }

    /**
     * Get the back button's state.
     * 
     * @return true for pressed, false otherwise
     */
    public boolean getBackButton() {
        return mButtonBack.get();
    }

    /**
     * Get the left bumper's state.
     * 
     * @return true for pressed, false otherwise
     */
    public boolean getLeftBumper() {
        return mButtonLBumper.get();
    }

    /**
     * Get the right bumper's state.
     * 
     * @return true for pressed, false otherwise
     */
    public boolean getRightBumper() {
        return mButtonRBumper.get();
    }

    /**
     * Get the left trigger's state.
     * 
     * @return true for pressed, false otherwise
     */
    public boolean getLeftTrigger() {
        return Math.abs(mJoystick.getRawAxis(Mapping.kTriggerLeft.value)) > 0.0;
    }

    /**
     * Get the right trigger's state.
     * 
     * @return true for pressed, false otherwise
     */
    public boolean getRightTrigger() {
        return Math.abs(mJoystick.getRawAxis(Mapping.kTriggerLeft.value)) > 0.0;
    }

    /**
     * --------------------------------------------------------------------
     * 
     * This part of the class returns the button object for binding 
     * commands to.
     * 
     * --------------------------------------------------------------------
     */

    /**
     * Returns the underlying JoystickButton object associated
     * with this button. 
     * 
     * @return The A-button's JoystickButton object representation
     */
    public Button getAButtonObject() {
        return mButtonA;
    }

    /**
     * Returns the underlying JoystickButton object associated
     * with this button. 
     * 
     * @return The B-button's JoystickButton object representation
     */
    public Button getBButtonObject() {
        return mButtonB;
    }

    /**
     * Returns the underlying JoystickButton object associated
     * with this button. 
     * 
     * @return The X-button's JoystickButton object representation
     */
    public Button getXButtonObject() {
        return mButtonX;
    }

    /**
     * Returns the underlying JoystickButton object associated
     * with this button. 
     * 
     * @return The Y-button's JoystickButton object representation
     */
    public Button getYButtonObject() {
        return mButtonY;
    }

    /**
     * Returns the underlying JoystickButton object associated
     * with this button. 
     * 
     * @return The left-bumper's JoystickButton object representation
     */
    public Button getLeftBumperObject() {
        return mButtonLBumper;
    }

    /**
     * Returns the underlying JoystickButton object associated
     * with this button. 
     * 
     * @return The right-bumper's JoystickButton object representation
     */
    public Button getRightBumperObject() {
        return mButtonRBumper;
    }

    /**
     * Returns the underlying JoystickButton object associated
     * with this button. 
     * 
     * @return The back-button's JoystickButton object representation
     */
    public Button getBackButtonObject() {
        return mButtonBack;
    }

    /**
     * Returns the underlying JoystickButton object associated
     * with this button. 
     * 
     * @return The start-button's JoystickButton object representation
     */
    public Button getStartButtonObject() {
        return mButtonStart;
    }
}
