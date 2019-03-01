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

import com.rotterdam.groep1.Urenregistratie.controller.ContactpersoonService;
import com.rotterdam.groep1.Urenregistratie.domein.Contactpersoon;
import com.rotterdam.groep1.Urenregistratie.domein.Kandidaat;

@Path("contactpersoon")
@Component
public class ContactpersoonEndpoint {

	@Autowired
	ContactpersoonService contactpersoonService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response toonAllen() {
		Iterable<Contactpersoon> tests = contactpersoonService.geefAllen();
		return Response.ok(tests).build();
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postAccount(Contactpersoon t){
		Contactpersoon result = contactpersoonService.save(t);
		return Response.accepted(result.getId()).build();	
	}
	
	@GET
	@Path("/view/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getKandidaat(@PathParam("id")Long id){
		Contactpersoon c = contactpersoonService.getById(id);
		if(c != null) 
			return Response.ok(c).build();
		return Response.status(Status.NOT_FOUND).build();
	}


	@PUT
	@Path("/edit/{kid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateContactpersoon(@PathParam("kid") Long id, Contactpersoon c){
		if (contactpersoonService.getById(id) == null)
			return Response.status(Status.NOT_FOUND).build();
		
		c.setId(id);
		contactpersoonService.save(c);
		
		return Response.accepted("GELUKT!").build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response deleteContactpersoon(@QueryParam("id") Long id) {
		Contactpersoon c = contactpersoonService.getById(id);
		
		if (c != null) {
			contactpersoonService.deleteById(id);
			return Response.noContent().build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
}