/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveForwardAuton;
import frc.robot.commands.RawTankDrive;
import frc.robot.commands.RunX;
import frc.robot.commands.RunY;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.XControl;
import frc.robot.subsystems.YControl;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...


  private final DriveTrain driveTrain = new DriveTrain();
  private final XControl xControl = new XControl(); 
  private final YControl yControl = new YControl(); 
  
  private final Joystick leftStick = new Joystick(0); 
  private final Joystick rightStick = new Joystick(1); 

  private final JoystickButton xForward = new JoystickButton(leftStick, 1); 
  private final JoystickButton xBackward = new JoystickButton(leftStick, 2); 
  private final JoystickButton yForward = new JoystickButton(leftStick, 3); 
  private final JoystickButton yBackward = new JoystickButton(leftStick, 4); 

  private final DriveForwardAuton m_autoCommand = new DriveForwardAuton(driveTrain, 10, .1);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    driveTrain.setDefaultCommand(new RawTankDrive (driveTrain, () -> leftStick.getRawAxis(0), () -> rightStick.getRawAxis(0)));
    // Configure the button bindings
    configureButtonBindings();

      
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    xForward.whenHeld(new RunX(xControl, Constants.xSpeed)); 
    xBackward.whenHeld(new RunX(xControl, Constants.xSpeed * -1)); 
    yForward.whenHeld(new RunY(yControl, Constants.ySpeed)); 
    yBackward.whenHeld(new RunY(yControl, Constants.ySpeed * -1)); 
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
