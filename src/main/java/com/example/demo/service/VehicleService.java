package com.example.demo.service;

import java.util.List;

import com.example.demo.module.Vehicle;

public interface VehicleService 
{
	Vehicle addVehicle(Vehicle v);
	
	Vehicle getById(Integer id);
	
	List<Vehicle> getByColor(String color);
	
	void deleteById(Integer id);
	
	Vehicle updateVehicle(Vehicle v);
	
	List<Vehicle> vehicleByMorePrice(Double price);
	
	List<Vehicle>  vehicleSortPriceSort();
	
	List<Vehicle> getAll();

	
	
}