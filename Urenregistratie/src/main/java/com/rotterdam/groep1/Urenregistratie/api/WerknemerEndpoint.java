package com.rotterdam.groep1.Urenregistratie.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rotterdam.groep1.Urenregistratie.controller.WerknemerService;
import com.rotterdam.groep1.Urenregistratie.domein.Werknemer;

import com.rotterdam.groep1.Urenregistratie.domein.Overzicht;

@Path("werknemer")
@Component
public class WerknemerEndpoint implements Overzicht {
	@Autowired
	WerknemerService werknemerService;	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOverzicht() { //De werknemer moet alle kandidaten in kunnen zien. Dit is de functie van onze interface.
		Iterable<Werknemer> werknemerLijst = werknemerService.geefAllen();
		return Response.ok(werknemerLijst).build();
	}	
	
	@GET
	@Path("/viewWerknemer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getKandidaat(@PathParam("id")Long id){
		Werknemer k = werknemerService.getById(id);
		if(k != null) 
			return Response.ok(k).build();
		return Response.status(Status.NOT_FOUND).build();
	}
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createWerknemer(Werknemer w) {
		return Response.ok(werknemerService.save(w)).build();
	}		

	@PUT
	@Path("/editWerknemer/{kid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWerknemer(@PathParam("kid") Long id, Werknemer k){
		if (werknemerService.getById(id) == null)
			return Response.status(Status.NOT_FOUND).build();
		
		k.setId(id);
		werknemerService.save(k);
		
		return Response.accepted("GELUKT!").build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteWerknemer")
	public Response deleteWerknemer(@QueryParam("id") Long id) {
		Werknemer k = werknemerService.getById(id);
		System.out.println(k);
		if (k != null) {
			werknemerService.deleteById(id);
			return Response.noContent().build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}	
	
}

