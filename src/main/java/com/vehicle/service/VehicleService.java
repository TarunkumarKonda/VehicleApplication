package com.vehicle.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.dao.VehicleDao;
import com.vehicle.entity.Vehicle;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleDao vehicledao;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Vehicle createVehicle(Vehicle vehicle){
		
		return vehicledao.save(vehicle);
		
	}
	
	public Vehicle getVehicleById(Integer id){
		try{
		return vehicledao.findOne(id);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public Iterable<Vehicle> getAllVehicles(){
		
		return vehicledao.findAll();
		
	}
	
	public void deleteVehicle(Integer id){
	
		 vehicledao.delete(id);
		
	}
	
	public Vehicle updateVehicle(Vehicle vehicle ){
		
		Vehicle updating = vehicledao.findOne(vehicle.getId());
		updating.setYear(vehicle.getYear());
		updating.setMake(vehicle.getMake());
		updating.setModel(vehicle.getModel());
		Vehicle updatedVehicle = vehicledao.save(updating);
	
		return updatedVehicle;
	}
	
	
	// cannot include in dao because, of argument type mismatch <Vehicle, Integer> not <Vehicle, String>
	@SuppressWarnings("unchecked")
	public List<Vehicle> getVehicleByMake(String make) {
		
		String query = "FROM Vehicle as vhl WHERE vhl.Make=?" ;
		return (List<Vehicle>)entityManager.createQuery(query).setParameter(1,make).getResultList();
	
	}
	
	@SuppressWarnings("unchecked")
	public List<Vehicle> getVehicleByModel(String model) {
		
		String query = "FROM Vehicle as vhl WHERE vhl.Model=?";
		return (List<Vehicle>)entityManager.createQuery(query).setParameter(1,model).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Vehicle> getVehicleByYear(Integer year) {
		
		String query = "FROM Vehicle as vhl WHERE vhl.Year =?";
		return (List<Vehicle>)entityManager.createQuery(query).setParameter(1,year).getResultList();

	}
	
	@SuppressWarnings("unchecked")
	public List<Vehicle> getVehicleByYearG(Integer year) {

		String query = "FROM Vehicle as vhl WHERE vhl.Year > ?";
		return (List<Vehicle>)entityManager.createQuery(query).setParameter(1,year).getResultList();
	
	}
	@SuppressWarnings("unchecked")
	public List<Vehicle> getVehicleByYearL(Integer year) {
		
		String query = "FROM Vehicle as vhl WHERE vhl.Year <?"; // descending order
		return (List<Vehicle>)entityManager.createQuery(query).setParameter(1,year).getResultList();
		
   }

}
