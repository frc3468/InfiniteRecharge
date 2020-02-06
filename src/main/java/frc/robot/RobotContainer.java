/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.Advance;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Retreat;
import frc.robot.commands.Stop;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Conveyor conveyor = new Conveyor();
  private final BallIntake ballIntake = new BallIntake();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  XboxController stick = new XboxController(OIConstants.stickPort);

  /*
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /*
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(stick, Button.kA.value).and(
    new Trigger(() -> conveyor.InitialConveyorSensorGet()).or(
    new Trigger(() -> conveyor.FinalConveyorSensorGet()).or(
    new Trigger(() -> conveyor.LauncherConveyorSensorGet()).negate()
    ).whileActiveContinuous(new Advance(conveyor)
    ).whenInactive(new Stop(conveyor))));

    new JoystickButton(stick, Button.kBumperRight.value).whileHeld(new Retreat(conveyor));
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
