package com.rotterdam.groep1.Urenregistratie.fileUpload.web.resource;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.rotterdam.groep1.Urenregistratie.controller.KandidaatService;
import com.rotterdam.groep1.Urenregistratie.domein.Kandidaat;
import com.rotterdam.groep1.Urenregistratie.fileUpload.handler.IFileUploadHandler;
import com.rotterdam.groep1.Urenregistratie.fileUpload.model.files.HttpFile;
import com.rotterdam.groep1.Urenregistratie.fileUpload.model.request.FileUploadRequest;
import com.rotterdam.groep1.Urenregistratie.fileUpload.model.response.FileUploadResponse;

import org.glassfish.jersey.media.multipart.BodyPartEntity;
import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;


@Component
@Path("/files")
public class FileUploadResource  {

    private final IFileUploadHandler fileUploadHandler;
    
    @Autowired
    KandidaatService kandidaatService;

    @Autowired
    public FileUploadResource(IFileUploadHandler fileUploadHandler) {
        this.fileUploadHandler = fileUploadHandler;
    }
    
    @POST
    @Path("/upload/pasfoto/{uid}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadPasfoto(@PathParam("uid") long id, 
    		@FormDataParam("pasfoto") InputStream stream,
    		@FormDataParam("pasfoto") FormDataContentDisposition fileDetail) {
    	
    	HttpFile httpFile = new HttpFile(fileDetail.getFileName(), fileDetail.getSize(), fileDetail.getParameters(), stream);
    	
    	FileUploadRequest fileUploadRequest = new FileUploadRequest("", "", httpFile);
    	
    	FileUploadResponse result = fileUploadHandler.handle(fileUploadRequest);
    	System.out.println(httpFile.getFilePath().toString());
    	//Check if file is an image
    	try {
    		Image image = ImageIO.read(new File(httpFile.getFilePath().toString()));
    	} catch (IOException ex) {
    		try {
				Files.delete(httpFile.getFilePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
    		return Response.accepted("NoImageException").build();
    	}
    	
    	
    	if (kandidaatService.existsById(id)) {
    		Kandidaat k = kandidaatService.getById(id);
    		k.setPasfotoUrl(httpFile.getFilePath().toString());
    		kandidaatService.save(k);
    	}
    	else 
    		return Response.accepted("NoAccountException").build();
    	
    	 return Response
                 .status(200)
                 .entity(result)
                 .build();
    }
    
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response fileUpload(@FormDataParam("title") String title,
                               @FormDataParam("description") String description,
                               final FormDataMultiPart multiPart) {
                              
    	List<FormDataBodyPart> bodyParts = multiPart.getFields("file"); //Verkrijg alle files vanuit het formulier
    	ArrayList<FileUploadResponse> result = new ArrayList<FileUploadResponse>(); //Maak de resultlijst aan
    	
    	//Voor elke file: pak de informatie en zet het in de HttpFile classe
    	for (int i = 0; i < bodyParts.size(); i++) {
    		BodyPartEntity bodyPartEntity = (BodyPartEntity) bodyParts.get(i).getEntity();
    		ContentDisposition fileDetail = bodyParts.get(i).getContentDisposition();
    		
	        HttpFile httpFile = new HttpFile(fileDetail.getFileName(), fileDetail.getSize(), fileDetail.getParameters(), bodyPartEntity.getInputStream());
	        System.out.println(fileDetail.getFileName());
	        
	        // Create the FileUploadRequest:
	        FileUploadRequest fileUploadRequest = new FileUploadRequest(title, description, httpFile);
	
	        // Handle the File Upload:
	        result.add(fileUploadHandler.handle(fileUploadRequest));
    	}
    	
    		
        return Response
                .status(200)
                .entity(result)
                .build();
    }
}