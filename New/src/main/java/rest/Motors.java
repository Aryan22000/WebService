package rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.MotorData;

@Path("/motor")
public class Motors {
	@POST
	@Path("/speed")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public MotorData postBookByParams(@FormParam("Name") String Name, @FormParam("Speed") int Speed) {
	    MotorData motorData = new MotorData(Name, Speed);
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Robo82");
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(motorData);
	    em.getTransaction().commit();
	    return motorData;
	}


}
