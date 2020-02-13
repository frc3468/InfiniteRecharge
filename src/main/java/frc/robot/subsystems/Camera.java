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
  public double spnpArray[];
  public double xfromgoal;
  public double yfromgoal;
  public double cameraAngle; 
  public final NetworkTableEntry cameraPitch; 
  public final NetworkTableEntry cameraYaw;
  public final NetworkTableEntry cameraValid;

  //Replace mycamname with the name of the camera once we get that set up  

  /**
   * Creates a new ExampleSubsystem.
   */
  public Camera() {
    NetworkTableInstance table = NetworkTableInstance.getDefault();    
    NetworkTable cameraTable = NetworkTableInstance.getTable(CameraConstants.chameleonName).getSubTable(CameraConstants.cameraTableName);
    area = cameraTable.getEntry("targetArea");
    solvepnp = cameraTable.getEntry("targetPose");
    spnpArray = solvepnp.getDoubleArray(spnpArray);
    xfromgoal = spnpArray[1];
    yfromgoal = spnpArray[2];
    cameraAngle = spnpArray[3];
    cameraPitch = cameraTable.getEntry("targetPitch");
    cameraYaw = cameraTable.getEntry("targetYaw");
    cameraValid = cameraTable.getEntry("isValid");
  };

  @Override
  public final void periodic() {
    // This method will be called once per scheduler run

    };

  /*public double distance(){
    //backup code its outdated.
    return area.getdouble(0.0) * conversionrate;
  };
  */

  public double xOffset(){
    // in this case negative numbers would be left and posotive would be right 
    // an example in psuedo code would be 
    /* 
    if(xOffset < 0){ 
    bool left = true
    };
    elseif(xOffset > 0){
    bool right = true
    };
    else(){
    bool onTarget = true
    };
    */
    return cameraPitch.getDouble(0) ;
  };

  public double yOffset(){

    return cameraYaw.getDouble(0);
  };

  public boolean isvalid(){
    return cameraValid.getBoolean(false); 
  };
  
  public boolean Distance(){
    return spnpArray[1];
  };
}; 


