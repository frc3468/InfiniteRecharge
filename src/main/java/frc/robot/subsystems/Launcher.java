/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LauncherConstants;

public class Launcher extends SubsystemBase {

  private CANSparkMax rightLaunchMotor;
  private CANSparkMax leftLaunchMotor; 
  private CANEncoder leftMotorEncoder;
  private CANEncoder rightMotorEncoder;

  public Launcher() {
    rightLaunchMotor = new CANSparkMax(LauncherConstants.rightLaunchMotor, MotorType.kBrushless);
    leftLaunchMotor = new CANSparkMax(LauncherConstants.leftLaunchMotor, MotorType.kBrushless);
  }

  public void setVelocity() {
    rightLaunchMotor.set(LauncherConstants.rightLaunchMotorVelocity);
    leftLaunchMotor.set(LauncherConstants.leftLaunchMotorVelocity);
  }

  public void setSpeed() {
    rightLaunchMotor.set(LauncherConstants.rightLaunchMotorSpeed);
    leftLaunchMotor.set(LauncherConstants.leftLaunchMotorSpeed);
  }

  public void stop() {
    rightLaunchMotor.set(LauncherConstants.rightLaunchStopSpeed);
    leftLaunchMotor.set(LauncherConstants.leftLaunchStopSpeed);
  }

  public double getVelocity() {
    double sum = leftMotorEncoder.getVelocity() + rightMotorEncoder.getVelocity();
    double average = sum / 2;
    return average;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
