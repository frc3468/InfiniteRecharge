/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.ColorWheel;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class movetocolor extends CommandBase {
  private ColorWheel colorwheel;
  private Color gameData;
  private boolean done;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public movetocolor(ColorWheel subsystem, Color gamedata) {
      colorwheel = subsystem;
      addRequirements(colorwheel);
      gameData = gamedata;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    done = false;
    colorwheel.raiseManipulator();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      if(gameData != colorwheel.getFieldSensorColor() ){
          colorwheel.advance();
      }
      else{
        done = true;

      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    colorwheel.stowManipulator();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}