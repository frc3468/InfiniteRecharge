/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoFolder.DoNothing;
import frc.robot.commands.AutoFolder.DriveForwardAuto;
import frc.robot.commands.AutoFolder.LaunchingAuto;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Launcher;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Auto extends SequentialCommandGroup {
  
  /**
   * Creates a new Auto.
   */
  public Auto(Launcher launcher, Conveyor conveyor, BooleanSupplier bool, Drivetrain drivetrain) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    // 
    super(new LaunchingAuto(launcher, conveyor, bool).withTimeout(8), new DoNothing(drivetrain).withTimeout(0.5), new DriveForwardAuto(drivetrain).withTimeout(0.6));
  }
}
