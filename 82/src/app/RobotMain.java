package app;

import lejos.hardware.Button;

public class RobotMain {
	private static DataExchange DE = new DataExchange();
	private static helloworlds LFObj  = new helloworlds(DE);
	private static ObstacleDetector ODObj = new ObstacleDetector(DE);
	private static ColorSensor CSObj = new ColorSensor (DE);
	
	public static void main(String[] args) {
		System.out.println("Welcome ...");
		System.out.println("Hello guys ");
		System.out.println("it's Robo82");
		System.out.println("1.Veronika");
		System.out.println("2.Mohammadreza");
		System.out.println("3.Aryan");
		System.out.println("Please press the button below.");
		Button.waitForAnyPress();
		ODObj.start();
		LFObj.start();
		CSObj.start();
		while(!(Button.getButtons() !=0)) {
			//break when button is pressed
			break;
		}
		
	}

}