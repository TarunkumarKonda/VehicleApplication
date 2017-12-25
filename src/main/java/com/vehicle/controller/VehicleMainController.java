package com.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.entity.Vehicle;
import com.vehicle.service.VehicleService;


@CrossOrigin(origins="*")
@RestController
public class VehicleMainController {
	
	@Autowired
	private VehicleService service;
	
	@GetMapping(value="vehicles", produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Vehicle> getAllVehicles(){
		return service.getAllVehicles();
	}
	
	@GetMapping(value = "vehicles/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Vehicle getvehicleById(@PathVariable("id") Integer id){
	   return service.getVehicleById(id);	
	   }
	
	@PostMapping(value="vehicles", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Vehicle createVehicle(@RequestBody Vehicle vehicle){
		return service.createVehicle(vehicle);
	}
	
	@DeleteMapping(value="vehicles/{id}")
	public void deletevehicle(@PathVariable("id") Integer id){
		service.deleteVehicle(id);
	}

	@PutMapping(value= "vehicles",produces=MediaType.APPLICATION_JSON_VALUE)
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle){
		return service.updateVehicle(vehicle);
	}
	
}
