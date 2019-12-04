/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// Command package reference https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/command/package-summary.html
import edu.wpi.first.wpilibj.command.Subsystem; // Defines major components of the robot for use by commands 
// The wpilibj package has a bunch of classes relating to managing the hardware in the FRC control system in the robot 
// wpilibj package reference https://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/package-summary.html
import edu.wpi.first.wpilibj.SpeedControllerGroup; // Allows mutliple speed controller objects to be linked together
// Drive package reference https://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/drive/package-summary.html
import edu.wpi.first.wpilibj.drive.DifferentialDrive; // A class for creating differential drive robots 
// CTRE Can package reference https://www.ctr-electronics.com/downloads/api/java/html/namespacecom_1_1ctre_1_1phoenix_1_1motorcontrol_1_1can.html
// Can is a package that includes WPI-compliant set of CTRE motor controls 
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; // A WPI-compliant speed controller class for the Talon SRX motor controller 
import frc.robot.commands.Teleop; // imports the Teleop.java command class 

/* A subsystem is a major system of the robot. This subsystem handles the wheel/driving mechanisms */ 

/** This subsystem handles matters relating to the movement of the robot **/ 
public class DriveTrain extends Subsystem {
  public Subsystem(){ // initializes the constructor for this subsystem. 
    // By default sets the name of the constructor to the name of the class, but can also be changed using Subsystem("DriveTrain") or public DriveTrain()
  }
  // Motor Controller Initialization
  WPI_TalonSRX front_left  = new WPI_TalonSRX(1); // The number is the ID of the motor 
  WPI_TalonSRX front_right = new WPI_TalonSRX(2);
  // WPI_TalonSRX is an API instance that is the motor control object from ctr-electronics
  /* The regular FRC-supported speedcontrollers are declared using the SpeedController object, but the Talon SRX is seperate from 
  CTRE, but because it is WPI-compatible, it can still be included in speed controller groups*/ 
  WPI_TalonSRX back_left   = new WPI_TalonSRX(3);
  WPI_TalonSRX back_right  = new WPI_TalonSRX(4);
  
  // Speed controller groups 
  SpeedControllerGroup left = new SpeedControllerGroup(front_left, back_left);
  SpeedControllerGroup right = new SpeedControllerGroup(front_right, back_right);
  // SpeedControllerGroup is a way of grouping together microcontrollers. These groups can be told to run as a group of operations
  
  // Side inversion 
  setLeftSideInverted(true); // because the motors are set in opposite directions, inverting is necessary for driving to go forward rather than spin
  setRightSideInverted(false); // to ensure this side is not inverted 
  /** CHECK WHETHER ABOVE STATEMENTS NEEDS TO BE INSIDE CONTRUCTOR **/ 
  /* IF THIS DOESN'T WORK, USE THE BUILT-IN INVERSION STATEMENTS FOR EACH INDIVIDUAL MOTOR CONTROLLER */ 
  
  // Drive setting 
  DifferentialDrive diffDrive = new DifferentialDrive(left, right);
  // DIfferentialDrive is a collection of motor controls used to drive. 

  // Method that drives the robot 
  public void drive(double x_axis, double y_axis) { 
    diffDrive.arcadeDrive(x_axis, y_axis);
  }
  /* drive() is a method that takes in amounts to move by and moves the controls by those inputs */
  // arcadeDrive() is a method in the API that is one method of controlling motors, similar to that of an arcade joystick


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Teleop()); // Makes a command the default command file linked to the subsystem. Teleop takes joystick input, so it is linked to the subsystem. Adds this to the scheduler
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
