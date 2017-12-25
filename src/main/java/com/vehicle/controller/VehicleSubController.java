package com.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.entity.Vehicle;
import com.vehicle.service.VehicleService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("vehicles")
public class VehicleSubController {
	
	@Autowired
	private VehicleService service;
	
	@GetMapping(value= "/by-model/{Model}",produces=MediaType.APPLICATION_JSON_VALUE )
	   public Iterable<Vehicle> getVehiclesByModel(@PathVariable("Model") String Model){
		return service.getVehicleByModel(Model);
		   
	   }
	@GetMapping(value= "/by-make/{Make}",produces=MediaType.APPLICATION_JSON_VALUE )
	   public Iterable<Vehicle> getVehiclesByMake(@PathVariable("Make") String Make){
		return service.getVehicleByMake(Make);
		   
	   }
	
	@GetMapping(value = "/by-year/{Year}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Vehicle> getvehicleByYear(@PathVariable("Year") Integer Year){
	   return service.getVehicleByYear(Year);	
	   }
	
	@GetMapping(value = "/by-year-greater-than/{Year}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Vehicle> getvehicleByYearG(@PathVariable("Year") Integer Year){
	   return service.getVehicleByYearG(Year);	
	   }
	@GetMapping(value = "/by-year-lesser-than/{Year}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Vehicle> getvehicleByYearL(@PathVariable("Year") Integer Year){
	   return service.getVehicleByYearL(Year);	
	   }
	
}
