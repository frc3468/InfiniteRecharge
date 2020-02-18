/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
public class CartesianDrive extends CommandBase {
  private static final int DRIVEEXPONENT = 3;
  private Drivetrain robotDrive;
  private DoubleSupplier magy;
  private DoubleSupplier magx;
  private DoubleSupplier rot;
  /**
   * Creates a new CartesianDrive.
   */
  public CartesianDrive(Drivetrain subsystem, DoubleSupplier magnitudey, DoubleSupplier magnitudex, DoubleSupplier rotation) {
    robotDrive = subsystem;
    magy = magnitudey;
    magx = magnitudex;
    rot = rotation;
    addRequirements(robotDrive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    robotDrive.cartesianDrive(Math.pow(magy.getAsDouble(), DRIVEEXPONENT), Math.pow(magx.getAsDouble(), DRIVEEXPONENT), Math.pow(rot.getAsDouble(), DRIVEEXPONENT));
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
