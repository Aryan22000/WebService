package app;



import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.Enumeration;

//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.Invocation.Builder;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
//import runnables.*;
public class Ev3 {
    static EV3LargeRegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
    static EV3LargeRegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);

  public static void main(String[] args) {
    
        System.out.println("Read some text from URL\n");
        System.out.println("Press any key to start");
        
        Button.waitForAnyPress();

        URL url = null;
      HttpURLConnection conn = null;
      InputStreamReader isr = null;
      BufferedReader br=null;
      String s=null;
    try {
//      url = new URL("https://ev3test-380115.appspot.com/rest/ev3service/sayhello");
//      url = new URL("http://192.168.0.102:8080/rest/ev3service/sayhello");
//      url = new URL("http://192.168.1.64:8080/rest/laptopservive/servicename");
      url = new URL("http://192.168.0.106:8080/rest/tadaa/tuduu");
//      url = new URL("http://192.168.0.101");
      conn = (HttpURLConnection)url.openConnection();
        System.out.println(conn.toString());
        //Tulostaa vain URLin
//      if (conn==null) {
//          System.out.println("No connection!!!");
//      }
      InputStream is=null;
      try {
        is=conn.getInputStream();
      }
      catch (Exception e) {
          System.out.println("Exception conn.getInputSteam()");
          e.printStackTrace();
              System.out.println("Cannot get InputStream!");
      }
      isr = new InputStreamReader(is);
          br=new BufferedReader(isr);
//          s = br.readLine().split(",");
      while ((s=br.readLine())!=null){
        System.out.println(s);
      }
//            int speedA = Integer.parseInt(s[0]);
//              int speedD = Integer.parseInt(s[1]);
//              // Control motors using speedA and speedD
//              motorA.setSpeed(speedA);
//              motorD.setSpeed(speedD);
//              motorA.forward();
//              motorD.forward();
//              // Wait for 5 seconds
//              Delay.msDelay(5000);
//              // Stop motors
//              motorA.stop();
//              motorD.stop();
    }
      catch(Exception e) {
        e.printStackTrace();
            System.out.println("Some problem!");
      }
        System.out.println("Press any key to FINISH");
        Button.waitForAnyPress();
  }

}