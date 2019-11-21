/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

// WPI Command package reference https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/command/package-summary.html
import edu.wpi.first.wpilibj.command.Command; // The class at the center of the command package's framework 
import frc.robot.Robot; // imports the Robot.java class from the robot package in order to acces the m_oi instance of the OI.java object and drive_train of DriveTrain.java


/** Teleop is a command file. Teleop means 'remotely operated', for this file manages taking input 
from the joystick remotely and  */

public class Teleop extends Command {
  public Command () { // if this doesn't work, try public Command("Teleop"). If it still doesn't, revert to public Teleop()
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drive_train); // Because this whole command is about moving the robot, it requires the drive_train instance  
  }
  // See if public Command(Robot.drive_train) works to replicate the form public Command(String name, double timeout, Subsystem subsystem)
  // If so, delete requires(Robot.drive_train) 
  
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Called the first time the command is called after being started 
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() { // runs repeatedly until command is cancelled or finished 
    Robot.drive_train.drive(Robot.m_oi.get_x(), Robot.m_oi.get_y()); // calls the drive() function from the drive_train instance of DriveTrain
    // m_oi is the Robot.java instance of OI.java, get_x and y is a method in OI.java 
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override 
  protected boolean isFinished() { // Returns whether command is finished. If so, the command will be removed and end() will be called
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

/* Start() starts up the command 
isRunning() returns whether the command is running 
cancel() cancels the current command 
isCancelled() returns whether or not the command has been cancelled
isCompleted() returns whether or not the command has completed
toString() returns the string form of the command's name */ 
