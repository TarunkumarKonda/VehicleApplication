package com.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleApplication.class, args);
	}
	
	/*public class WebConfig extends WebMvcConfigurerAdapter {
		  @Override
		  public void addCorsMappings(CorsRegistry registry) {
		    registry.addMapping("/**");
		  }
		}*/
}
