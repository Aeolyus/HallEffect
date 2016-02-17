
package org.usfirst.frc.team2854.robot;

//time_wasted_here = .2;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Counter counter = new Counter(0); //insert DIO port
	
	int n = counter.get();
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	counter.reset();
    	System.out.println("Hall effect sensors are cool.");
    	
    	//settings for hall effect sensor
    	counter.setMaxPeriod(1); //sets max period in seconds where the device is still considered moving
    	counter.setUpdateWhenEmpty(false); //when false it will keep the most recent period on the counter when counter is stalled
    	counter.setReverseDirection(true); //reverses direction
    	counter.setSamplesToAverage(20); //number of samples to average when determining period
    	counter.setDistancePerPulse(10); //sets distance per count when using getDistance()
    	 	
    	
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    }

    /**
     * This function is called periodically during operator control
     */
    
    public void teleopInit(){
    	n = counter.get();
    }
    
    public void teleopPeriodic() {
       	SmartDashboard.putNumber("count", counter.get());
       	if (n ==counter.get()){
       		System.out.println("Go");
       	} else{
       		System.out.println("Stop");
       	}

        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
