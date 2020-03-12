/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.AutoFolder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.Drivetrain;

public class RemoveXOffset extends CommandBase {
  /**
   * Creates a new RemoveXOffset.
   */
  Camera camera;
  Drivetrain drivetrain;
  boolean done = false;

  public RemoveXOffset(Camera camera, Drivetrain Drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    camera = this.camera;
    drivetrain = Drivetrain;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(camera.getOffsetFromGoal() != 0){
      if(camera.getOffsetFromGoal() > 0)
      drivetrain.cartesianDrive( 0, -0.5, 0);
    }
    if(camera.getOffsetFromGoal() < 0){
      drivetrain.cartesianDrive(0, 0.5, 0);
    }
    else {
      done = true;

    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
