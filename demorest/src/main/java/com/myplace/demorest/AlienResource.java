package com.myplace.demorest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	
	//List<Alien> aliens;
	AlienRepository alienRepo=new AlienRepository();
	
	@GET
	@Path("alien")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alien> getAllAliens()
	{	
		return alienRepo.getAllAliens();		
	}
	
	@GET
	@Path("alien/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Alien getAlien(@PathParam("id") int id)
	{	
		System.out.println(alienRepo.getAlien(id));
		return alienRepo.getAlien(id);			
	}
	
	@POST
	@Path("alien")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alien> addAlien(Alien alien)
	{	
		System.out.println(alien);
		return alienRepo.createAlien(alien);			
	}
	
	@DELETE
	@Path("alien/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alien> removeAlien(@PathParam("id") int id)
	{	
		System.out.println("Deleted Alien" +"  ==>>  "+alienRepo.getAlien(id));
		return alienRepo.deleteAlien(id);			
	}
	
	@PUT
	@Path("alien")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alien> updateAlien(Alien alien)
	{	
		System.out.println("Old Alien" +"  ==>>  "+alienRepo.getAlien(alien.getId()));
		System.out.println("Updated Alien" +"  ==>>  "+alien);
		return alienRepo.updateAlien(alien);			
	}

}

