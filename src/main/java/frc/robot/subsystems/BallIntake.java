/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.BallIntakeConstants;

public class BallIntake extends SubsystemBase {
  /*
   * Creates a new BallIntake.
   */
  public VictorSPX intakeMotor;

  public BallIntake() {
    intakeMotor = new VictorSPX(BallIntakeConstants.intakeMotor);
  }
  public void intake() {
    intakeMotor.set(ControlMode.PercentOutput, BallIntakeConstants.intakeSpeed);
  }
  public void exhaust() {
    intakeMotor.set(ControlMode.PercentOutput, BallIntakeConstants.exhaustSpeed);
  }
  public void stop() {
    intakeMotor.set(ControlMode.PercentOutput, BallIntakeConstants.stopSpeed);
  }

  @Override
  public void periodic() {
    
  }
}
