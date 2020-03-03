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

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    leftLaunchMotor = new CANSparkMax(LauncherConstants.leftLaunchMotor, MotorType.kBrushless);
    rightLaunchMotor = new CANSparkMax(LauncherConstants.rightLaunchMotor, MotorType.kBrushless);

    rightLaunchMotor.setInverted(true);

    leftMotorEncoder = leftLaunchMotor.getEncoder();
    rightMotorEncoder = rightLaunchMotor.getEncoder();

    leftPIDController = leftLaunchMotor.getPIDController();
    rightPIDController = rightLaunchMotor.getPIDController();

    leftPIDController.setP(LauncherConstants.proportialPIDConstant);
    leftPIDController.setI(LauncherConstants.integralPIDConstant);
    leftPIDController.setD(LauncherConstants.derivativePIDConstant);
    leftPIDController.setIZone(LauncherConstants.integralPIDConstant);
    leftPIDController.setFF(LauncherConstants.feedForwardPIDConstant);
    leftPIDController.setOutputRange(LauncherConstants.maxPIDOutput, LauncherConstants.minPIDOutput);

    rightPIDController.setP(LauncherConstants.proportialPIDConstant);
    rightPIDController.setI(LauncherConstants.integralPIDConstant);
    rightPIDController.setD(LauncherConstants.derivativePIDConstant);
    rightPIDController.setIZone(LauncherConstants.integralPIDConstant);
    rightPIDController.setFF(LauncherConstants.feedForwardPIDConstant);
    rightPIDController.setOutputRange(LauncherConstants.maxPIDOutput, LauncherConstants.minPIDOutput);
  }  

  public void setVelocity(double velocity) {
    targetVelocity = velocity;
    leftPIDController.setReference(targetVelocity, ControlType.kVelocity);
    rightPIDController.setReference(targetVelocity, ControlType.kVelocity);
  }

  public void setSpeed(double speed) {
    leftLaunchMotor.set(speed);
    rightLaunchMotor.set(speed);
  }

  public void stop() {
    setSpeed(0.0);
  }

  // Finds the average velocity of the two motors 
  public double getVelocity() {
    double sum = leftMotorEncoder.getVelocity() + rightMotorEncoder.getVelocity();
    double average = sum / 2;
    return average;
  }

  // For the target velocity
  public boolean isOnTarget() {
    boolean leftOnTarget = Math.abs(targetVelocity - leftMotorEncoder.getVelocity()) <= LauncherConstants.velocityPIDTolerance;
    boolean rightOnTarget = Math.abs(targetVelocity - rightMotorEncoder.getVelocity()) <= LauncherConstants.velocityPIDTolerance;
    return (rightOnTarget && leftOnTarget);
  }

  public static double distanceToVelocity(double distance) {
    //TODO tune distance convertion 
    return 0.0;
  }

  @Override
  public void periodic() {

    SmartDashboard.putNumber("Left Velocity", leftMotorEncoder.getVelocity());
    SmartDashboard.putNumber("Right Velocity", rightMotorEncoder.getVelocity());
    SmartDashboard.putNumber("Average Velocity", getVelocity());
    // This method will be called once per scheduler run
  }
}
