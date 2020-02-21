/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class RawTankDrive extends CommandBase {
  /**
   * Creates a new RawTankDrive.
   */
  private DriveTrain driveTrain;
  private DoubleSupplier leftSpeed;
  private DoubleSupplier rightSpeed;
  //public RawTankDrive(DriveTrain driveTrain2, Object object, Object object2) {

public RawTankDrive(DriveTrain chooChoo, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = chooChoo;
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.tankDrive(leftSpeed.getAsDouble(), rightSpeed.getAsDouble());
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
