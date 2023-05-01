package app;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class helloworlds extends Thread {

	public void stopM() {
		motorA.stop();
		motorD.stop();
		Delay.msDelay(1000);
	}

	public void rotateM() {
		motorD.setSpeed(90);
		motorA.setSpeed(90);
		motorA.forward();
		motorD.backward();
		Delay.msDelay(1500);

	}

	public void rotateMO() {
		motorA.setSpeed(90);
		motorD.setSpeed(90);
		motorA.forward();
		motorD.backward();
		Delay.msDelay(800);

	}

	public void runM() {
		motorA.setSpeed(100);
		motorD.setSpeed(180);
		motorD.forward();
		motorA.forward();
		Delay.msDelay(6000);
	}

	public void ending() {

		motorA.setSpeed(200);
		motorD.setSpeed(200);
		motorA.forward();
		motorD.backward();
		Delay.msDelay(4000);

	}
	public void ScStop() {
		motorA.stop();
		motorD.stop();
		Delay.msDelay(10000);
	}
	public void Back() {
		motorA.setSpeed(200);
		motorD.setSpeed(200);
		motorA.backward();
		motorD.backward();
		Delay.msDelay(1000);
	}

	// DataExchange object
	DataExchange DEObj;
	// wheels connect to ports
	public static RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
	public static RegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);

	// constructor
	public helloworlds(DataExchange DE) {
		DEObj = DE;
	}

	private final int lineColor = 15; // Value of the black line to be followed against a white background

	public void run() {
		int round = 0;
		while (true) {
			// access method inside data exchange
			// Get the line value from the ColorSensor Thread
			float colorDetected = DEObj.getLineChecker();

			// get the count value from setter
			//int count = DEObj.getCountValue();
			
			if (DEObj.getCMD() == 1) {

				if (colorDetected < lineColor) {
					motorA.setSpeed(320);
					motorD.setSpeed(100);
					motorA.forward();
					motorD.forward();
				} else if (colorDetected > lineColor) {

					motorD.setSpeed(320);
					motorA.setSpeed(100);

					motorD.forward();
					motorA.forward();

				}
			} else if (DEObj.getCMD() != 1 ) {
				
					if (round == 0 ) { // round one fight !
						stopM();
						rotateM();
						stopM();
						runM();
						stopM();
						rotateMO();
					}
					if (round != 0) {
						int x=0;
						while(x<10) {
							Sound.beepSequenceUp();
							x++;
						}
						
						System.out.println("Second time !!!");
						Back();
						stopM();
						ending();
						ScStop();
						
					}
					round ++;

			}
			if (Button.getButtons() != 0) {
				// break when button is pressed
				break;

			}
		}
	}
	}

