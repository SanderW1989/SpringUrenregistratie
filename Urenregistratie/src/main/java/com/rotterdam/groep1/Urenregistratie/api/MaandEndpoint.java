package com.rotterdam.groep1.Urenregistratie.api;

import java.util.List;

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

import com.rotterdam.groep1.Urenregistratie.controller.MaandService;
import com.rotterdam.groep1.Urenregistratie.controller.WerkdagService;
import com.rotterdam.groep1.Urenregistratie.domein.Maand;
import com.rotterdam.groep1.Urenregistratie.domein.Werkdag;


@Path("maand")
@Component
public class MaandEndpoint {
	@Autowired
	MaandService maandService;
	
	@Autowired
	WerkdagService werkdagService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response toonAllen() {
		Iterable<Maand> tests = maandService.geefAllen();
		for (Maand m : tests) {
			System.out.println(m);
		}
		return Response.ok(tests).build();
	}	
	
	@GET
	@Path("/getMaand")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMaand() {
		Iterable<Werkdag> tests = werkdagService.geefAlleWerkagenPerMaand(5);
		for (Werkdag w : tests) {
			System.out.println(w);
		}
		return Response.ok(tests).build();
	}	
	
	@Path("/createMaand/{uid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMaand(@PathParam("uid") long id) {
		Maand maand = new Maand();
		//for (aantal dagen in de maand) {
			//Werkdag werkdag = new Werkdag();
	//	}
		return Response.ok().build();
	}	
	
	@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKandidaatById(@PathParam("id") Long id){
        if(this.maandService.existsById(id)) {
            Maand maand = this.maandService.findById(id);
            return Response.ok(maand).build();
        }
        System.out.println("Maand id in GET niet gevonden!");
        return Response.status(Status.NOT_FOUND).build();
    }		
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postMaand(Maand m) {
		Maand result = maandService.save(m);
	return Response.accepted(result.getId()).build();
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMaand(@PathParam("id") Long id, Maand c){
		if (maandService.getById(id) == null)
			return Response.status(Status.NOT_FOUND).build();		
		c.setId(id);
		maandService.save(c);		
		return Response.accepted("GELUKT!").build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response deleteMaand(@QueryParam("id") Long id) {
		Maand k = maandService.getById(id);
		System.out.println(k);
		if (k != null) {
			maandService.deleteById(id);
			return Response.noContent().build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}	
	
}
