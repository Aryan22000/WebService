package rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

import data.MotorData;


@Path("/tadaa")
public class readData {
  @GET
  @Path("/tuduu")
  @Produces(MediaType.APPLICATION_JSON)
  public List<MotorData> getSpeed() {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("Robo82");
      EntityManager em = emf.createEntityManager();
      TypedQuery<MotorData> query = em.createQuery("SELECT m FROM MotorData m WHERE m.ID = (SELECT MAX(md.ID) FROM MotorData md)", MotorData.class);
      List<MotorData> motorDataList = query.getResultList();
//      return motorDataList;
//      MotorData motorData = motorDataList.get(0);
//      int speedA = motorData.getSpeedA();
//      int speedD = motorData.getSpeedD();
//      return "speedA: " + speedA + ", speedD: " + speedD;
      List<Integer> speeds = new ArrayList<>();
//      for (MotorData motorData : motorDataList) {
//          speeds.add(motorData.getSpeed());
//          speeds.add(motorData.getName());
//      }
      //return speeds;
      return motorDataList;

       

      
}
}
