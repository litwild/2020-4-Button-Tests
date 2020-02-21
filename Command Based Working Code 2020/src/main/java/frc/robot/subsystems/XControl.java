/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class XControl extends SubsystemBase {
  /**
   * Creates a new XControl.
   */
  private WPI_VictorSPX xMotor; 

  public XControl() {
    xMotor = new WPI_VictorSPX(Constants.xMotor); 
  }

  public void run(double speed) {
    xMotor.set(speed); 
  }

  public void stop() {
    xMotor.set(0); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
