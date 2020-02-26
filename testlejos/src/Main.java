import lejos.hardware.*;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.Font;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.hardware.port.UARTPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.NXTColorSensor;
import lejos.hardware.video.Video;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Main {

    RemoteEV3 ev3;

    {
        try {
            ev3 = new RemoteEV3("1.2.3.4.5.6.7");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
    RMIRegulatedMotor motorA = ev3.createRegulatedMotor("A",'L');

    EV3UltrasonicSensor sensor;
    Brick brick = BrickFinder.getDefault();
    Port s2 = brick.getPort("S2");
    EV3UltrasonicSensor us = new EV3UltrasonicSensor(s2);


    public UltrasonicClosest(){

    }

}
