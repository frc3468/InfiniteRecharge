/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ConveyorConstants;

public class Conveyor extends SubsystemBase {

  private TalonSRX conveyorMotor;
  private DigitalInput initialConveyorSensor;
  private DigitalInput finalConveyorSensor;
  private DigitalInput launcherConveyorSensor;
  /**
   * Creates a new Conveyor.
   */
  public Conveyor() {

    conveyorMotor = new TalonSRX(ConveyorConstants.conveyorMotor);
    initialConveyorSensor = new DigitalInput(ConveyorConstants.initialConveyorSensor);
    finalConveyorSensor = new DigitalInput(ConveyorConstants.finalConveyorSensor);
    launcherConveyorSensor = new DigitalInput(ConveyorConstants.launcherConveyorSensor);

  }

  public void advance() {
    conveyorMotor.set(ControlMode.PercentOutput, ConveyorConstants.conveyorMotorAdvanceSpeed);
  }

  public void retreat() {
    conveyorMotor.set(ControlMode.PercentOutput, ConveyorConstants.conveyorMotorRetreatSpeed);
  }

  public void stop() {
    conveyorMotor.set(ControlMode.PercentOutput, ConveyorConstants.conveyorMotorStopSpeed);
  }

  public boolean getInitialConveyorSensor() {
    return initialConveyorSensor.get();
  }

  public boolean getFinalConveyorSensor() {
    return finalConveyorSensor.get();
  }

  public boolean getLauncherConveyorSensor() {
    return launcherConveyorSensor.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
