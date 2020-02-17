/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LauncherConstants;

public class Launcher extends SubsystemBase {

  private CANSparkMax rightLaunchMotor;
  private CANSparkMax leftLaunchMotor; 
  private CANEncoder rightMotorEncoder;
  private CANEncoder leftMotorEncoder;
  private CANPIDController rightPIDController;
  private CANPIDController leftPIDController;
  private double targetVelocity = 0; 

  public Launcher() {
    rightLaunchMotor = new CANSparkMax(LauncherConstants.rightLaunchMotor, MotorType.kBrushless);
    leftLaunchMotor = new CANSparkMax(LauncherConstants.leftLaunchMotor, MotorType.kBrushless);

    rightMotorEncoder = rightLaunchMotor.getEncoder();
    leftMotorEncoder = leftLaunchMotor.getEncoder();

    rightPIDController = rightLaunchMotor.getPIDController();
    leftPIDController = leftLaunchMotor.getPIDController();

    rightPIDController.setP(LauncherConstants.proportialPIDConstant);
    rightPIDController.setI(LauncherConstants.integralPIDConstant);
    rightPIDController.setD(LauncherConstants.derivativePIDConstant);
    rightPIDController.setIZone(LauncherConstants.integralPIDConstant);
    rightPIDController.setFF(LauncherConstants.feedForwardPIDConstant);
    rightPIDController.setOutputRange(LauncherConstants.maxPIDOutput, LauncherConstants.minPIDOutput);

    leftPIDController.setP(LauncherConstants.proportialPIDConstant);
    leftPIDController.setI(LauncherConstants.integralPIDConstant);
    leftPIDController.setD(LauncherConstants.derivativePIDConstant);
    leftPIDController.setIZone(LauncherConstants.integralPIDConstant);
    leftPIDController.setFF(LauncherConstants.feedForwardPIDConstant);
    leftPIDController.setOutputRange(LauncherConstants.maxPIDOutput, LauncherConstants.minPIDOutput);
  }  

  public void setVelocity(double velocity) {
    targetVelocity = velocity;
    rightPIDController.setReference(targetVelocity, ControlType.kVelocity);
    leftPIDController.setReference(targetVelocity, ControlType.kVelocity);
  }

  public void setSpeed(double speed) {
    rightLaunchMotor.set(speed);
    leftLaunchMotor.set(speed);
  }

  public void stop() {
    setSpeed(0.0);
  }

  public double getVelocity() {
    double sum = rightMotorEncoder.getVelocity() + leftMotorEncoder.getVelocity();
    double average = sum / 2;
    return average;
  }

  public boolean isOnTarget() {
    boolean rightOnTarget = Math.abs(targetVelocity - rightMotorEncoder.getVelocity()) <= LauncherConstants.velocityPIDTolerance;
    boolean leftOnTarget = Math.abs(targetVelocity - leftMotorEncoder.getVelocity()) <= LauncherConstants.velocityPIDTolerance;
    return (rightOnTarget && leftOnTarget);
  }

  public static double distanceToVelocity(double distance) {
    //TODO tune distance convertion 
    return 0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
