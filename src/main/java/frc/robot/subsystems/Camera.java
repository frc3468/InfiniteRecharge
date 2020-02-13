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

   NetworkTableInstance table;
  public NetworkTableEntry area;

  public NetworkTableEntry solvepnp;

  //spnp stands for solve pnp 
  public final NetworkTableEntry cameraPitch; 
  public final NetworkTableEntry cameraYaw;
  public final NetworkTableEntry cameraValid;

  //Replace mycamname with the name of the camera once we get that set up  

  /**
   * Creates a new ExampleSubsystem.
   */
  public Camera() {
    final NetworkTableInstance table = NetworkTableInstance.getDefault();
    final NetworkTable cameraTable = table.getTable(CameraConstants.chameleonName)
        .getSubTable(CameraConstants.cameraTableName);
    area = cameraTable.getEntry("targetArea");
    solvepnp = cameraTable.getEntry("targetPose");
    cameraPitch = cameraTable.getEntry("targetPitch");
    cameraYaw = cameraTable.getEntry("targetYaw");
    cameraValid = cameraTable.getEntry("isValid");
  };

  @Override
  public final void periodic() {
    // This method will be called once per scheduler run

    
  };


 

  public double xfromgoal(){
    double[] arrayAtPoint = solvepnp.getDoubleArray(new double[3]);
    return arrayAtPoint[1];

  };

  public double yfromgoal(){
    double[] arrayAtPoint = solvepnp.getDoubleArray(new double[3]);
    return arrayAtPoint[2];

  };
  
  public double cameraAngle(){
    double[] arrayAtPoint = solvepnp.getDoubleArray(new double[3]);
    return arrayAtPoint[3];
  };
  public boolean isValid(){

    return cameraValid.getBoolean(false);
  }
}; 
