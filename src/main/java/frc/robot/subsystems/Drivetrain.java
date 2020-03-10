/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {
  private CANSparkMax frontLeftDriveMotor;
  private CANSparkMax rearLeftDriveMotor;
  private SpeedControllerGroup leftSpeedControllerGroup;
  private CANSparkMax frontRightDriveMotor;
  private CANSparkMax rearRightDriveMotor;
  private SpeedControllerGroup rightSpeedControllerGroup;
  private DifferentialDrive robotDrive;
  private AHRS navX;
  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    frontLeftDriveMotor = new CANSparkMax(DrivetrainConstants.frontLeftDriveMotor, MotorType.kBrushless);
    rearLeftDriveMotor = new CANSparkMax(DrivetrainConstants.rearLeftDriveMotor, MotorType.kBrushless);
    leftSpeedControllerGroup = new SpeedControllerGroup(frontLeftDriveMotor, rearLeftDriveMotor);
    frontRightDriveMotor = new CANSparkMax(DrivetrainConstants.frontRightDriveMotor, MotorType.kBrushless);
    rearRightDriveMotor = new CANSparkMax(DrivetrainConstants.rearRightDriveMotor, MotorType.kBrushless);
    rightSpeedControllerGroup = new SpeedControllerGroup(frontRightDriveMotor, rearRightDriveMotor);
    frontLeftDriveMotor.setIdleMode(IdleMode.kCoast);
    rearLeftDriveMotor.setIdleMode(IdleMode.kCoast);
    frontRightDriveMotor.setIdleMode(IdleMode.kCoast);
    rearRightDriveMotor.setIdleMode(IdleMode.kCoast);
    robotDrive = new DifferentialDrive(leftSpeedControllerGroup, rightSpeedControllerGroup); 
    navX = new AHRS();
    
    frontLeftDriveMotor.burnFlash();
    rearLeftDriveMotor.burnFlash();
    frontRightDriveMotor.burnFlash();
    rearRightDriveMotor.burnFlash();
  }

  public void haloDrive(double magnitudey, double rotation) {
    robotDrive.arcadeDrive(magnitudey, rotation);
  }

  public float getYaw(){
    return navX.getYaw();
  };

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
