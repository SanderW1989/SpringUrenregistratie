package com.rotterdam.groep1.Urenregistratie.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rotterdam.groep1.Urenregistratie.controller.AdminService;
import com.rotterdam.groep1.Urenregistratie.domein.Admin;

@Path("/admin")
@Component
public class AdminEndpoint extends WerknemerEndpoint {
	
	@Autowired
	AdminService adminService;
	
	@POST
	@Path("/createAdmin")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAdmin(Admin a) {
		return Response.ok(adminService.save(a)).build();
	}	
	
}
