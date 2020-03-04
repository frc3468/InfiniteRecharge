/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheel;

public class RotateColorWheel extends CommandBase {
  private ColorWheel colorWheel;
  private Supplier<Color> currentColor;
  private Color lastColor;
  private int targetEighthTurns;
  private int completedEighthTurns;

  /**
   * Creates a new RotateColorWheel.
   */
  public RotateColorWheel(ColorWheel subsystem, Supplier<Color> currentColorSource, int eighthTurns) {
    // Use addRequirements() here to declare subsystem dependencies.
    colorWheel = subsystem;
    currentColor = currentColorSource;
    targetEighthTurns = eighthTurns;
    addRequirements(colorWheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    lastColor = currentColor.get();
    completedEighthTurns = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Color currentColor = this.currentColor.get();
    if(currentColor != lastColor) {
      lastColor = currentColor;
      completedEighthTurns++;
    }
    colorWheel.advance();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    colorWheel.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return completedEighthTurns >= targetEighthTurns;
  }
}
