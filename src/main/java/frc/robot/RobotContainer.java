/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.DriverControllerConstants;
import frc.robot.Constants.OverrideControllerConstants;
import frc.robot.commands.AdvanceConveyor;
import frc.robot.commands.IntakeBallIntake;
import frc.robot.commands.ExhaustBallIntake;
import frc.robot.commands.SetLauncherVelocity;
import frc.robot.commands.RetreatConveyor;
import frc.robot.commands.SetLauncherSpeed;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.Launcher;
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
  private final Conveyor conveyor = new Conveyor();
  private final BallIntake ballIntake = new BallIntake();
  private final Launcher launcher = new Launcher();
  private final Camera camera = new Camera();

  XboxController driverController = new XboxController(DriverControllerConstants.driverControllerPort);
  Joystick overrideController = new Joystick(OverrideControllerConstants.overrideControllerPort);

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
    // Driver Controller Buttons
    JoystickButton intakeButton = new JoystickButton(driverController, DriverControllerConstants.intakeButton);
    JoystickButton launchButton = new JoystickButton(driverController, DriverControllerConstants.launchButton);

    // Override Controller Buttons
    JoystickButton IntakeBallIntakeOverrideButton = new JoystickButton(overrideController, OverrideControllerConstants.intakeBallIntakeButton);
    JoystickButton exhaustBallIntakeOverrideButton = new JoystickButton(overrideController, OverrideControllerConstants.exhaustBallIntakeButton);
    JoystickButton advanceConveyorOverrideButton = new JoystickButton(overrideController, OverrideControllerConstants.advanceConveyorButton);
    JoystickButton retreatConveyorOverrideButton = new JoystickButton(overrideController, OverrideControllerConstants.retreatConveyorButton);
    JoystickButton setLauncherVelocityOverrideButton = new JoystickButton(overrideController, OverrideControllerConstants.launcherVelocityButton);
    JoystickButton setLauncherSpeedOverrideButton = new JoystickButton(overrideController, OverrideControllerConstants.launcherSpeedButton);

    // Internal Robot Triggers
    Trigger initialConveyorDetector = new Trigger(() -> conveyor.InitialConveyorSensorGet());
    Trigger finalConveyorDetector = new Trigger(() -> conveyor.FinalConveyorSensorGet());
    Trigger launcherConveyorDetector = new Trigger(() -> conveyor.LauncherConveyorSensorGet());
    Trigger launcherOnTarget = new Trigger(() -> launcher.isOnTarget());
    

    // Intake
    intakeButton.and(
      finalConveyorDetector.or(launcherConveyorDetector).negate()
    ).whileActiveContinuous(new IntakeBallIntake(ballIntake));
    
    // Conveyor
    intakeButton.and(
      initialConveyorDetector.or(finalConveyorDetector)
      .and(launcherConveyorDetector.negate())
    ).whileActiveContinuous(new AdvanceConveyor(conveyor));

    // Launcher
    launchButton.or(setLauncherVelocityOverrideButton).whileActiveContinuous(new SetLauncherVelocity(launcher, 
      () -> Launcher.distanceToVelocity(camera.yfromgoal())));
    launchButton.and(
      launcherOnTarget
    ).whileActiveContinuous(new AdvanceConveyor(conveyor));
    launchButton.and(
      launcherOnTarget.negate().and(launcherConveyorDetector.negate())
    ).whileActiveContinuous(new AdvanceConveyor(conveyor));


    //Intake Override 
    IntakeBallIntakeOverrideButton.whileHeld(new IntakeBallIntake(ballIntake));
    exhaustBallIntakeOverrideButton.whileHeld(new ExhaustBallIntake(ballIntake));

    // Conveyor Override
    advanceConveyorOverrideButton.whileHeld(new AdvanceConveyor(conveyor));
    retreatConveyorOverrideButton.whileHeld(new RetreatConveyor(conveyor));

    // Launcher Override
    setLauncherVelocityOverrideButton.whileHeld(new SetLauncherVelocity(launcher, 
      () -> Launcher.distanceToVelocity(camera.yfromgoal())));
    setLauncherSpeedOverrideButton.whileHeld(new SetLauncherSpeed(launcher, 
      () -> overrideController.getRawAxis(OverrideControllerConstants.launcherSpeedAxis)));
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
