/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.jni.CANSparkMaxJNI;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.commands.CartesianDrive;

public class Drivetrain extends SubsystemBase {
  private CANSparkMax frontLeftDriveMotor;
  private CANSparkMax rearLeftDriveMotor;
  private CANSparkMax frontRightDriveMotor;
  private CANSparkMax rearRightDriveMotor;
  private MecanumDrive robotDrive;
  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    frontLeftDriveMotor = new CANSparkMax(DrivetrainConstants.frontLeftDriveMotor, MotorType.kBrushless);
    rearLeftDriveMotor = new CANSparkMax(DrivetrainConstants.rearLeftDriveMotor, MotorType.kBrushless);
    frontRightDriveMotor = new CANSparkMax(DrivetrainConstants.frontRightDriveMotor, MotorType.kBrushless);
    rearRightDriveMotor = new CANSparkMax(DrivetrainConstants.rearRightDriveMotor, MotorType.kBrushless);
    //
    robotDrive = new MecanumDrive(frontLeftDriveMotor, rearLeftDriveMotor, frontRightDriveMotor, rearRightDriveMotor);
  }

  public void cartesianDrive(double magnitudey, double magnitudex, double rotation) {
    robotDrive.driveCartesian(magnitudey, magnitudex, rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
