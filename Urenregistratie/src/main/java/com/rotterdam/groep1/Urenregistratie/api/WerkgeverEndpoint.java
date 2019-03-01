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

import com.rotterdam.groep1.Urenregistratie.controller.WerkgeverService;
import com.rotterdam.groep1.Urenregistratie.domein.Werkgever;

@Path("werkgever")
@Component
public class WerkgeverEndpoint {
	@Autowired
	WerkgeverService werkgeverService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response toonAllen() {
		System.out.println("ik ben een endpoint");
		Iterable<Werkgever> werkgevers = werkgeverService.geefAllen();
		for (Werkgever k : werkgevers) {
			System.out.println(k);
		}
		return Response.ok(werkgevers).build();
	}	
	
	@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWerkgeverById(@PathParam("id") Long id){
        if(this.werkgeverService.existsById(id)) {
            Werkgever werkgever = this.werkgeverService.findById(id);
            return Response.ok(werkgever).build();
        }
        System.out.println("Kandidaat id in GET niet gevonden!");
        return Response.status(Status.NOT_FOUND).build();
    }	
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postAccount(Werkgever d) {
		Werkgever result = werkgeverService.save(d);
		return Response.accepted(result.getId()).build();
	}
	
	@PUT
	@Path("/edit/{kid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWergever(@PathParam("kid") Long id, Werkgever c){
		if (werkgeverService.getById(id) == null)
			return Response.status(Status.NOT_FOUND).build();		
		c.setId(id);
		werkgeverService.save(c);		
		return Response.accepted("GELUKT!").build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response deleteWerkgever(@QueryParam("id") Long id) {
		Werkgever k = werkgeverService.getById(id);
		System.out.println(k);
		if (k != null) {
			werkgeverService.deleteById(id);
			return Response.noContent().build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}	
}
