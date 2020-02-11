/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

/**
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
    }
   
    public static final class IntakeConstants {
        public static final int IntakeMotor = 0;
        public static final double BallIntakeSpeed = 0.5;
        public static final double BallExhaustSpeed = -0.5;
        public static final double IntakeStopSpeed = 0.0;
    }

    public static final class LauncherConstants {
        public static final int rightLaunchMotor = 1;
        public static final int leftLaunchMotor = 2;
        public static final double rightLaunchMotorVelocity = 0.8;
        public static final double leftLaunchMotorVelocity = -0.8;
        public static final double rightLaunchMotorSpeed = 0.6;
        public static final double leftLaunchMotorSpeed = -0.6;
        public static final double rightLaunchStopSpeed = 0.0;
        public static final double leftLaunchStopSpeed = 0.0;
        public static final int launchVelocity = 90; 

    }
    public static final class CameraConstants {
        public static final NetworkTableInstance Networktable = NetworkTableInstance.getDefault();

    }

}
