/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

/*
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class DriverControllerConstants {
        public static final int driverControllerPort = 0;
        public static final int intakeButton = XboxController.Button.kA.value;
        public static final int launchButton = XboxController.Button.kB.value;
    }

    public static final class OverrideControllerConstants {
        public static final int overrideControllerPort = 1;
        public static final int launcherSpeedAxis = 1;
        public static final int launcherSpeedButton = 1;
        public static final int launcherVelocityButton = 2;
        public static final int raiseCPManipulatorButton = 3;
        public static final int raiseLiftHookButton = 4;
        public static final int advanceCPManipulatorButton = 5;
        public static final int regressCPManipulatorButton = 6;
        public static final int advanceLiftWinchButton = 7;
        public static final int regressLiftWinchButton = 8;
        public static final int advanceConveyorButton = 9;
        public static final int retreatConveyorButton = 10;
        public static final int intakeBallIntakeButton = 11;
        public static final int exhaustBallIntakeButton = 12;
    }

    public static final class DrivetrainConstants {
        public static final int frontLeftDriveMotor = 1;
        public static final int rearLeftDriveMotor = 2;
        public static final int frontRightDriveMotor = 3;
        public static final int rearRightDriveMotor = 4;
    }

    public static final class BallIntakeConstants {
        public static final int intakeMotor = 0;
        public static final double intakeSpeed = 0.5;
        public static final double exhaustSpeed = -0.5;
        public static final double stopSpeed = 0.0;
    }

    public static final class ConveyorConstants {

        public static final int conveyorMotor = 0;
        public static final int initialConveyorSensor = 0;
        public static final int finalConveyorSensor = 1;
        public static final int launcherConveyorSensor = 2;
        public static final double conveyorMotorAdvanceSpeed = 0.7;
        public static final double conveyorMotorRetreatSpeed = -0.7;
        public static final double conveyorMotorStopSpeed = 0.0;

    }

    public static final class LauncherConstants {
        public static final int rightLaunchMotor = 1;
        public static final int leftLaunchMotor = 2; 
        public static final double proportialPIDConstant = 1.0;
        public static final double integralPIDConstant = 0.0;
        public static final double derivativePIDConstant = 0.0;
        public static final double integralPIDZone = 0.0;
        public static final double feedForwardPIDConstant = 0.0;
        public static final double maxPIDOutput = 1.0;
        public static final double minPIDOutput = -1.0;
        public static final double velocityPIDTolerance = 10; 
    }

    public static final class CameraConstants {
        public static final String chameleonVisionTableName = "chameleon-vision";
        public static final String cameraTableName = "camera_name";
    }

}
