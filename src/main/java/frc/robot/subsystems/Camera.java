/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CameraConstants;






public class Camera extends SubsystemBase {

  // This was gathered by mesuring the distance from the camera from the goal then realizing x*area=distance in which x is the total or the conversion rate

  private NetworkTable cameraTable;

  private NetworkTableEntry robotPose;

  private NetworkTableEntry validTarget;
  private NetworkTableEntry targetArea;
  private NetworkTableEntry cameraPitch; 
  private NetworkTableEntry cameraYaw;

  //Replace mycamname with the name of the camera once we get that set up  

  /**
   * Creates a new ExampleSubsystem.
   */
  public Camera() {
    cameraTable = NetworkTableInstance.getDefault()
      .getTable(CameraConstants.chameleonVisionTableName)
      .getSubTable(CameraConstants.cameraTableName
    );
    
    robotPose = cameraTable.getEntry("targetPose");

    validTarget = cameraTable.getEntry("isValid");
    targetArea = cameraTable.getEntry("targetArea");
    cameraPitch = cameraTable.getEntry("targetPitch");
    cameraYaw = cameraTable.getEntry("targetYaw");
  }

  public double getDistanceFromGoal(){
    double[] poseArray = robotPose.getDoubleArray(new double[] {0.0,0.0,0.0});
    return poseArray[0];
  }

  public double getOffsetFromGoal(){
    double[] poseArray = robotPose.getDoubleArray(new double[] {0.0,0.0,0.0});
    return poseArray[1];
  }
  
  public double getAngleFromGoal(){
    double[] poseArray = robotPose.getDoubleArray(new double[] {0.0,0.0,0.0});
    return poseArray[2];
  }

  public boolean isValid(){
    return validTarget.getBoolean(false);
  }

  @Override
  public final void periodic() {
    // This method will be called once per scheduler run

    
  }
}
