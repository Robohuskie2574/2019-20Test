/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick; // https://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/Joystick.html

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
  /* Why doesn't OI.java need a constructor like the commands and subsystem? */ 
  
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber)
  Joystick stick = new Joystick(0); // The parameter is the index of the USB port the joystick is plugged into 
  // Buffers 
  double buffer = 0.2; // Joystick must be pushed to at least this percentage on a given axis
  double speed = 0.8; // the multiple by which the speed at which the robot travels is multiplied by 
  public double get_x(){ // x buffer
    if (stick.getX() > buffer || stick.getX() < -buffer){
      return -stick.getX() * speed; 
    else {
      return 0; 
    }
  }
  public double get_y(){ // y buffer
    if (stick.getY() > buffer || stick.getY() < -buffer){
      return stick.getY() * speed; 
    else {
      return 0; 
    }
  }

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
