package com.vehicle.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vehicle.entity.Vehicle;
import com.vehicle.service.VehicleService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {
	
	@Autowired
	private VehicleService service;
	
	/*----------- Test case for adding the vehicle and retrieving it by Id----------- */
	
	@Test 
	public void testGetVehicleById(){
		
		Vehicle vehicle1 = new Vehicle(1956,"ford", "focus");
		service.createVehicle(vehicle1);
		
		Vehicle vehicle =  service.getVehicleById(vehicle1.getId());
		
		assertEquals("Successfully fetched the Vehicle Make from the table!","ford",vehicle.getMake());
		assertEquals("Successfully fetched the vehicle by Vehicle_Id from the table!",1,vehicle.getId());
		service.deleteVehicle(vehicle1.getId());
	}
		
   /*-----------Test for updating the vehicle details----------------*/
	
	@Test 
	public void testUpdateVehicle(){
		
		Vehicle vehicle1 = new Vehicle(1956,"ford", "focus");
	   	service.createVehicle(vehicle1);
		
		vehicle1.setModel("fiesta");
		service.updateVehicle(vehicle1);
		
		assertEquals("Successfully updated the Vehicle Model from the table!","fiesta",vehicle1.getModel());
		service.deleteVehicle(vehicle1.getId());
	}
	
	/* -----------Test Case for Deleting the Vehicle record----------*/
	@Test 
	public void testDeleteVehicle(){
		
		Vehicle vehicle1 = new Vehicle(1956,"ford", "focus");
		 service.createVehicle(vehicle1);
		
		int i = vehicle1.getId();
		
		service.deleteVehicle(i);
		
		assertNull("Successfully deleted the Vehicle from the table!", service.getVehicleById(i));
		
	
		}
	
	/*---------------Test Case to retrieve vehicle by Specific Make-----------*/
	@Test 
	public void testGetVehicleByMake(){
		
		//Vehicle vehicle
		 Vehicle v1= service.createVehicle(new Vehicle(2010, "dodge", "charger"));
		 Vehicle v2= service.createVehicle(new Vehicle(2011, "dodge", "challenger"));
		 Vehicle v3= service.createVehicle(new Vehicle(2015, "ford", "focus"));
		
		   List<String> listexpected = new LinkedList<String>();
		   listexpected.add("charger");
		   listexpected.add("challenger");
		
		List<Vehicle> vehicleDetails = service.getVehicleByMake("dodge");
		List<String> actual = new LinkedList<String>();
	    
		for(Vehicle vehicle : vehicleDetails){
			
			actual.add(vehicle.getModel());
		}
		
		assertThat(listexpected, is(actual));
		
		service.deleteVehicle(v1.getId());
		service.deleteVehicle(v2.getId());
		service.deleteVehicle(v3.getId());
	     
	}
	
	/*-------------Test Case to retrieve vehicle by Specific Model*/
	@Test
	public void testGetVehicleByModel(){
		
		//Vehicle vehicle
		Vehicle v1= service.createVehicle(new Vehicle(2010, "dodge", "charger"));
		Vehicle v2=  service.createVehicle(new Vehicle(2017, "dodge", "charger"));
		Vehicle v3=  service.createVehicle(new Vehicle(2012, "ford", "mustang"));
		
		   List<Integer> listexpected = new LinkedList<Integer>();
		   listexpected.add(2010);
		   listexpected.add(2017);
		
		List<Vehicle> vehicleDetails = service.getVehicleByModel("charger");
		List<Integer> actual = new LinkedList<Integer>();
	    
		for(Vehicle vehicle : vehicleDetails){
			
			actual.add(vehicle.getYear());
		}
		
		assertThat(listexpected, is(actual));
		
		service.deleteVehicle(v1.getId());
		service.deleteVehicle(v2.getId());
		service.deleteVehicle(v3.getId());
	     
	}
	
	/*-------------Test Case to retrieve vehicle by Specific Year ---------------*/
	
	@Test 
	public void testGetVehicleByYear(){
		
		//Vehicle vehicle
		Vehicle v1=  service.createVehicle(new Vehicle(2010, "dodge", "charger"));
		Vehicle v2=  service.createVehicle(new Vehicle(2010, "dodge", "dart"));
		Vehicle v3=  service.createVehicle(new Vehicle(2012, "ford", "mustang"));
	
		
		  List<Integer> listExpected = new LinkedList<Integer>();
		  
		  Vehicle ev1 = new Vehicle(2010,"dodge", "charger");
		  Vehicle ev2 = new Vehicle(2010,"dodge", "dart");
		  
		  listExpected.add(ev1.getYear());
		  listExpected.add(ev2.getYear());
		  
		  List<Vehicle> vehicleList = service.getVehicleByYear(2010);
		  List<Integer> listActual = new LinkedList<Integer>();
		  
		  for(Vehicle vehicle: vehicleList){
			  listActual.add(vehicle.getYear());
		  }
		  
		  assertThat(listExpected, is(listActual));
		
		service.deleteVehicle(v1.getId());
		service.deleteVehicle(v2.getId());
		service.deleteVehicle(v3.getId());
	     
	}

	/*-------------Test Case to retrieve vehicles greater than a specific Year ---------------*/
	@Test 
	public void testGetVehicleByYearG(){
		
		//Vehicle vehicle
		Vehicle v1=  service.createVehicle(new Vehicle(2012, "dodge", "charger"));
		Vehicle v2=  service.createVehicle(new Vehicle(2013, "dodge", "dart"));
		Vehicle v3=  service.createVehicle(new Vehicle(2014, "ford", "mustang"));
		Vehicle v4=  service.createVehicle(new Vehicle(2015, "ford", "mustang"));
	
		
		  List<Integer> listExpected = new LinkedList<Integer>();
		  
		  Vehicle ev1=  new Vehicle(2014, "ford", "mustang");
		  Vehicle ev2=  new Vehicle(2015, "ford", "mustang");
		  
		  listExpected.add(ev1.getYear());
		  listExpected.add(ev2.getYear());
		  
		  List<Vehicle> vehicleList = service.getVehicleByYearG(2013);
		  
		  List<Integer> listActual = new LinkedList<Integer>();
		  
		  for(Vehicle vehicle: vehicleList){
			  listActual.add(vehicle.getYear());
		  }
		  
		  assertThat(listExpected, is(listActual));
		
		service.deleteVehicle(v1.getId());
		service.deleteVehicle(v2.getId());
		service.deleteVehicle(v3.getId());
		service.deleteVehicle(v4.getId());
	     
	}
	
	/*-------------Test Case to retrieve vehicles greater than a specific Year ---------------*/
	@Test 
	public void testGetVehicleByYearL(){
		
		//Vehicle vehicle
		Vehicle v1=  service.createVehicle(new Vehicle(2012, "dodge", "charger"));
		Vehicle v2=  service.createVehicle(new Vehicle(2013, "dodge", "dart"));
		Vehicle v3=  service.createVehicle(new Vehicle(2014, "ford", "mustang"));
		Vehicle v4=  service.createVehicle(new Vehicle(2015, "ford", "mustang"));
	
		
		  List<Integer> listExpected = new LinkedList<Integer>();
		  
		  Vehicle ev1=  new Vehicle(2012, "ford", "mustang");
		  Vehicle ev2=  new Vehicle(2013, "ford", "mustang");
		  
		  listExpected.add(ev1.getYear());
		  listExpected.add(ev2.getYear());
		  
		  List<Vehicle> vehicleList = service.getVehicleByYearL(2014);
		  
		  List<Integer> listActual = new LinkedList<Integer>();
		  
		  for(Vehicle vehicle: vehicleList){
			  listActual.add(vehicle.getYear());
		  }
		  
		  assertThat(listExpected, is(listActual));
		
		service.deleteVehicle(v1.getId());
		service.deleteVehicle(v2.getId());
		service.deleteVehicle(v3.getId());
		service.deleteVehicle(v4.getId());
	     
	}

}
