package com.vehicle.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

	
	@Entity
	@Table
	public class Vehicle implements Serializable  {
		
		private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
    @Min(1950)
	@Max(2050)
	private int Year;

	@NotNull
	private String Make;

	@NotNull
	private String Model;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	// No-Arg constructor
	public Vehicle() {
		super();
	}
    // Constructor overrided with  Year, Make and Model in order to create vehicle during Test Cases
	public Vehicle(int year, String make, String model) {
		super();
		Year = year;
		Make = make;
		Model = model;
	}
    
	// to String method for future development of API
	@Override
	public String toString() {
		return "Vehicle [Id=" + Id + ", Year=" + Year + ", Make=" + Make + ", Model=" + Model + "]";
	}


	}
