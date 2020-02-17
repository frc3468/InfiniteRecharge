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

    public static final class ConveyorConstants {

        public static final int conveyorMotor = 0;
        public static final int initialConveyorSensor = 0;
        public static final int finalConveyorSensor = 1;
        public static final int launcherConveyorSensor = 2;
        public static final double conveyorMotorAdvanceSpeed = 0.7;
        public static final double conveyorMotorRetreatSpeed = -0.7;
        public static final double conveyorMotorStopSpeed = 0.0;

    }

    public static final class OIConstants {
        public static final int stickPort = 0;
        public static final int intakeButtonNum = XboxController.Button.kA.value;
        public static final int intakeLauncherNum = XboxController.Button.kB.value;
    }
   
    public static final class IntakeConstants {
        public static final int IntakeMotor = 0;
        public static final double BallIntakeSpeed = 0.5;
        public static final double BallExhaustSpeed = -0.5;
        public static final double IntakeStopSpeed = 0.0;
        public static final double BallIntakePercentOutput = 0.5;
        public static final double BallExhaustPercentOutput = -0.5;
        public static final double BallIntakestop = 0.0;
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
        // Make sure to look at this and possibly renable static at one point.  Cannot be refrenced in non static field
        public static final String cameraTableName = "camera_name";
        public static final String chameleonName = "chameleon-vision";

    }

}
