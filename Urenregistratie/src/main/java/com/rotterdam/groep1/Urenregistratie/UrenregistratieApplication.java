package com.rotterdam.groep1.Urenregistratie;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.rotterdam.groep1.Urenregistratie.fileUpload.provider.IRootPathProvider;
import com.rotterdam.groep1.Urenregistratie.fileUpload.provider.RootPathProvider;

@SpringBootApplication
public class UrenregistratieApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new UrenregistratieApplication()
			.configure(new SpringApplicationBuilder(UrenregistratieApplication.class))
			.run(args);
		
		//SpringApplication.run(UrenregistratieApplication.class, args); Oude start programma
	}
	
	 @Bean
	    IRootPathProvider rootPathProvider() {
	        return new RootPathProvider("./files");
	    }
}
