package com.ateliersartisanaux.Ateliers.Artisanaux.Spring.Boot.MVC;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AteliersArtisanauxSpringBootMvcApplication.class);
	}

}
