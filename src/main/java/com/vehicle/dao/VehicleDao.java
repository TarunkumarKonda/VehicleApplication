package com.vehicle.dao;

import org.springframework.data.repository.CrudRepository;

import com.vehicle.entity.Vehicle;

public interface VehicleDao extends CrudRepository<Vehicle, Integer> {
	
	

}
