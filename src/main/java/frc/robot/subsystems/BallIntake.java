/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class BallIntake extends SubsystemBase {
  /**
   * Creates a new BallIntake.
   */
  public TalonSRX IntakeMotor;

  public BallIntake() {
    IntakeMotor = new TalonSRX(IntakeConstants.IntakeMotor);
  }
  public void Intake() {
    IntakeMotor.set(ControlMode.PercentOutput, IntakeConstants.BallIntakePercentOutput);
  }
  @Override
  public void periodic() {
    
  }
}
