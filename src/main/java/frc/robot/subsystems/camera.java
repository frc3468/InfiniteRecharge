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



  


public class Camera extends SubsystemBase {
  
  // This was gathered by mesuring the distance from the camera from the goal then realizing x*area=distance in which x is the total or the conversion rate
     
   
  NetworkTable cameraTable; 
  NetworkTableEntry area;
  
  NetworkTableEntry solvepnp;
  
  //spnp stands for solve pnp
  double spnpArray[];
  double xfromgoal;
  double yfromgoal;
  double cameraAngle; 
  NetworkTableEntry cameraPitch; 
  NetworkTableEntry cameraYaw;
  NetworkTableEntry cameraValid;

  //Replace mycamname with the name of the camera once we get that set up  

  /**
   * Creates a new ExampleSubsystem.
   */
  public Camera() {
    
    
    
    area = cameraTable.getEntery(targetArea); 
    solvepnp = cameraTable.getEntery(targetPose);
    spnpArray = Array.getoff(solvepnp.getdouble());
    xfromgoal = array[1];
    yfromgoal = array[2];
    cameraAngle = array[3];
    cameraPitch = cameraTable.getEntry(targetPitch);
    cameraYaw = cameraTable.getEntery(targetYaw);
    cameraValid = cameraTable.getEntery(isValid);
  };

  @Override
  public final void Periodic() {
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
    
    return pitch.getDouble(0) ;
  };

  public double yOffset(){

    return yaw.getdouble(0);
  };

  public boolean isvalid(){
    return valid.getboolean(false); 
  };
}; 


