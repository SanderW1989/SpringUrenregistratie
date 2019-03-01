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

import com.rotterdam.groep1.Urenregistratie.controller.WerkdagService;
import com.rotterdam.groep1.Urenregistratie.domein.Kandidaat;
import com.rotterdam.groep1.Urenregistratie.domein.Testclass;
import com.rotterdam.groep1.Urenregistratie.domein.Werkdag;

@Path("werkdag")
@Component
public class WerkdagEndpoint {

	@Autowired
	WerkdagService werkdagService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response toonAllen() {
		Iterable<Werkdag> wd = werkdagService.geefAllen();
		return Response.ok(wd).build();
	}
	
/*	@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKandidaatById(@PathParam("id") Long id){
        if(this.kandidaatService.existsById(id)) {
            Kandidaat kandidaat = this.kandidaatService.findById(id);
            return Response.ok(kandidaat).build();
        }
        System.out.println("Kandidaat id in GET niet gevonden!");
        return Response.status(Status.NOT_FOUND).build();
    }	*/
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postWerkdag(Werkdag t){
		Werkdag result = werkdagService.save(t);
		return Response.accepted(result.getId()).build();	
	}	
	
	@PUT
	@Path("/edit/{wid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWerkdag(@PathParam("wid") Long id, Werkdag c){
		if (werkdagService.getById(id) == null)
			return Response.status(Status.NOT_FOUND).build();		
		c.setId(id);
		werkdagService.save(c);		
		return Response.accepted("GELUKT!").build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response deleteWerkdag(@QueryParam("id") Long id) {
		Werkdag w = werkdagService.getById(id);
		System.out.println(w);
		if (w != null) {
			werkdagService.deleteById(id);
			return Response.noContent().build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}	
	
	
}