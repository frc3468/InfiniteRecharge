/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LiftConstants;

public class Lift extends SubsystemBase {

  private CANSparkMax winchMotor;
  private TalonSRX hookMotor;

  public Lift() {
    winchMotor = new CANSparkMax(LiftConstants.winchMotor, MotorType.kBrushless);
    hookMotor = new TalonSRX(LiftConstants.hookMotor);

    winchMotor.setSmartCurrentLimit(LiftConstants.winchCurrentLimit);

    hookMotor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, LiftConstants.canTimeout);
    hookMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, LiftConstants.canTimeout);
  }
  
  public void liftUpWinch() {
    winchMotor.set(LiftConstants.winchUpSpeed);
  }

  public void stopWinchMotor() {
    winchMotor.set(0.0);
  }

  public void pullDownWinch() {
    winchMotor.set(LiftConstants.winchDownSpeed);
  }

  public void liftUpHook() {
    hookMotor.set(ControlMode.PercentOutput, LiftConstants.hookUpSpeed);
  }

  public void pullDownHook() {
    hookMotor.set(ControlMode.PercentOutput, LiftConstants.hookDownSpeed);
  }

  public void stopHookMotor() {
    hookMotor.set(ControlMode.PercentOutput, 0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
