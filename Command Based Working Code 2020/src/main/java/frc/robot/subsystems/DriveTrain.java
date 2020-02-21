/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class DriveTrain extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
private WPI_VictorSPX frontRightVictor;
private WPI_VictorSPX frontLeftVictor;
private DifferentialDrive m_myRobot;

public DriveTrain() {
  frontRightVictor = new WPI_VictorSPX (Constants.frv);
  frontLeftVictor = new WPI_VictorSPX (Constants.flv);
  m_myRobot = new DifferentialDrive(frontLeftVictor, frontRightVictor);
}

  public void tankDrive(double leftSpeed, double rightSpeed) {
    
    m_myRobot.tankDrive(leftSpeed, rightSpeed);
    
  }

  public void staticDrive(double speed) {
    m_myRobot.tankDrive(speed, speed); 
  }

  public void stop() {
    m_myRobot.tankDrive(0, 0); 
  }
} 

/*@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }
}
*/
