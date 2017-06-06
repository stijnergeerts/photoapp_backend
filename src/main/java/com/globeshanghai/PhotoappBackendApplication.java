package com.globeshanghai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * This configuration class has three responsibilities:
 *
 *It enables the auto configuration of the Spring application context.
 *
 *It ensures that Spring looks for other components (controllers, services, and repositories) from the
 *	com.javaadvent.bootrest package.
 *
 *It launches our application in the main() method.
 *
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class PhotoappBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoappBackendApplication.class, args);
	}
}
