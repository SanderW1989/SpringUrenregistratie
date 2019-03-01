package com.rotterdam.groep1.Urenregistratie.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.rotterdam.groep1.Urenregistratie.api.AdminEndpoint;
import com.rotterdam.groep1.Urenregistratie.api.ContactpersoonEndpoint;
import com.rotterdam.groep1.Urenregistratie.api.KandidaatEndpoint;
import com.rotterdam.groep1.Urenregistratie.api.MaandEndpoint;
import com.rotterdam.groep1.Urenregistratie.api.TestclassEndpoint;
import com.rotterdam.groep1.Urenregistratie.api.WerkdagEndpoint;
import com.rotterdam.groep1.Urenregistratie.api.WerkgeverEndpoint;
import com.rotterdam.groep1.Urenregistratie.api.WerknemerEndpoint;
import com.rotterdam.groep1.Urenregistratie.api.AdminEndpoint;
import com.rotterdam.groep1.Urenregistratie.api.ContactpersoonEndpoint;

import com.rotterdam.groep1.Urenregistratie.fileUpload.web.exceptions.FileUploadExceptionMapper;
import com.rotterdam.groep1.Urenregistratie.fileUpload.web.resource.FileUploadResource;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig(){
		
		//Hier registreer je je endpoints. Die moet daarna nog wel geïmporteerd worden.
		register(TestclassEndpoint.class); 
		//register(AccountEndpoint.class);
		register(KandidaatEndpoint.class);
		register(WerknemerEndpoint.class);
		register(AdminEndpoint.class);
		register(ContactpersoonEndpoint.class);
		register(WerkgeverEndpoint.class);
		register(WerkdagEndpoint.class);
		register(MaandEndpoint.class);
		
		//File upload
		register(FileUploadResource.class);
		register(MultiPartFeature.class);
		register(FileUploadExceptionMapper.class);
		
	}
}