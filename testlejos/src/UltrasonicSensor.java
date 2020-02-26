import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class UltrasonicSensor {
    DifferentialPilot pilot;
    UltrasonicSensor ultra;

    public static void main(String [] args){
        new UltrasonicSensorClosest();
    }

    public UltrasonicSensorClosest(){
        pilot = new DifferentialPilot(1.5f,6, Motor.A, Motor.B);
        setupUltrasonic();
    }
}
