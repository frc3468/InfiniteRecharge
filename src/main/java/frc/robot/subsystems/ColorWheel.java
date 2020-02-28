/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ColorWheelConstants;

public class ColorWheel extends SubsystemBase {
  private VictorSPX manipulatorMotor;
  private Servo manipulatorServo;
  private ColorSensorV3 colorSensor;
  private ColorMatch colorMatcher;
  Color[] colorArray;
  /**
   * Creates a new ColorWheel.
   */
  public ColorWheel() {
    manipulatorMotor = new VictorSPX(ColorWheelConstants.manipulatorMotor);
    manipulatorServo = new Servo(ColorWheelConstants.manipulatorServo);
    colorSensor = new ColorSensorV3(ColorWheelConstants.colorSensorPort);
    colorMatcher = new ColorMatch();

    manipulatorServo.setBounds(2.0, 1.8, 1.5, 1.2, 1.0);

    colorArray = new Color[] {
      ColorWheelConstants.redColor,
      ColorWheelConstants.greenColor,
      ColorWheelConstants.blueColor,
      ColorWheelConstants.yellowColor
    };

    for(int i = 0; i < colorArray.length; i++) {
      colorMatcher.addColorMatch(colorArray[i]);
    }

  }

  public void raiseManipulator() {
    manipulatorServo.setPosition(ColorWheelConstants.manipulatorRaisedPosition);
  }

  public void stowManipulator() {
    manipulatorServo.setPosition(ColorWheelConstants.manipulatorStowedPosition);
  }

  public void advance() {
    manipulatorMotor.set(ControlMode.PercentOutput, ColorWheelConstants.manipulatorForwardSpeed);
  }

  public void reverse() {
    manipulatorMotor.set(ControlMode.PercentOutput, ColorWheelConstants.manipulatorReverseSpeed);
  }

  public Color getCurrentColor() {
    return colorMatcher.matchClosestColor(colorSensor.getColor()).color;
  }

  public Color getSensorColor() {
    int phaseChange = ColorWheelConstants.colorWheel90DegreePhaseChange;
    Color currentColor = getCurrentColor();
    int sensorColorIndex = -1;
    for(int i = 0; i < colorArray.length; i++) {
      if( currentColor == colorArray[i]) {
        sensorColorIndex = (i+phaseChange)%colorArray.length;
        break;
      }
    }
    return colorArray[sensorColorIndex];
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
