/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.ColorWheel;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheel;

public class RotateColorWheelToColor extends CommandBase {
  private ColorWheel colorWheel;
  private Supplier<Color> currentColor;
  private Supplier<Color> targetColor;
  /**
   * Creates a new RotateColorWheelToColor.
   */
  public RotateColorWheelToColor(ColorWheel subsystem, Supplier<Color> currentColorSource, Supplier<Color> targetColorSource) {
    // Use addRequirements() here to declare subsystem dependencies.
    colorWheel = subsystem;
    currentColor = currentColorSource;
    targetColor = targetColorSource;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(targetColor.get() != null) {
      if(currentColor.get() != targetColor.get()) {
        colorWheel.advance();
      }
    } else {
      colorWheel.stop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    colorWheel.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return targetColor.get() != null && targetColor.get() == currentColor.get();
  }
}
