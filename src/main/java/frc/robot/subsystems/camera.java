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
  double conversionrate = 36.5740;    
  NetworkTableInstance table; 
  NetworkTable cameraTable; 
  NetworkTableEntry area;
  
  NetworkTableEntry solvepnp;
  
  double array[]
  double x
  double y
  double angle
  //Replace mycamname with the name of the camera once we get that set up  

  /**
   * Creates a new ExampleSubsystem.
   */
  public Camera() {
    
    NetworkTableInstance table = NetworkTableInstance.getDefault();
    NetworkTable cameraTable = NetworkTableInstance.getTable("chameleon-vision").getSubTable("mycamname");
    
    area = cameraTable.getEntery(targetArea); 
    solvepnp = cameraTable.getEntery(targetPose);
    array = Array.getoff(solvepnp.getdouble())
    x = array[1]
    y = array[2]
    angle = array[3]
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
    return abs(x) 

  }

  public double yOffset(){
    return abs(y)

  }



}; 


