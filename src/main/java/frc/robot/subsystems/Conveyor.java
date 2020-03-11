/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ConveyorConstants;

public class Conveyor extends SubsystemBase {

  private CANSparkMax conveyorMotor;
  private DigitalInput initialConveyorSensor;
  private DigitalInput finalConveyorSensor;
  private DigitalInput launcherConveyorSensor;
  /**
   * Creates a new Conveyor.
   */
  public Conveyor() {

    conveyorMotor = new CANSparkMax(ConveyorConstants.conveyorMotor, MotorType.kBrushless);
    initialConveyorSensor = new DigitalInput(ConveyorConstants.initialConveyorSensor);
    finalConveyorSensor = new DigitalInput(ConveyorConstants.finalConveyorSensor);
    launcherConveyorSensor = new DigitalInput(ConveyorConstants.launcherConveyorSensor);

   conveyorMotor.setInverted(true);

   conveyorMotor.burnFlash();
  }

  public void advance() {
    conveyorMotor.set(ConveyorConstants.conveyorMotorAdvanceSpeed);
  }

  public void retreat() {
    conveyorMotor.set(ConveyorConstants.conveyorMotorRetreatSpeed);
  }

  public void stop() {
    conveyorMotor.set(ConveyorConstants.conveyorMotorStopSpeed);
  }

  public boolean getInitialConveyorSensor() {
    return !initialConveyorSensor.get();
  }

  public boolean getFinalConveyorSensor() {
    return !finalConveyorSensor.get();
  }

  public boolean getLauncherConveyorSensor() {
    return !launcherConveyorSensor.get();
  }

  @Override
  public void periodic() {

    SmartDashboard.putBoolean("Intake Sensor", !initialConveyorSensor.get());
    SmartDashboard.putBoolean("Conveyor Sensor", !finalConveyorSensor.get());
    SmartDashboard.putBoolean("Launcher Sensor", !launcherConveyorSensor.get());
    // This method will be called once per scheduler run
  }
}
