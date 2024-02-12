package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.module.Vehicle;
import com.example.demo.repo.VehicleRepo;
import com.example.demo.service.VehicleService;

@Service
public class VehicleSeriviceImpl implements VehicleService{

	@Autowired
	VehicleRepo repo;
	@Override
	public Vehicle addVehicle(Vehicle v) 
	{
		return repo.save(v);
		
	}
	@Override
	public Vehicle getById(Integer id) {
		
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", id));
	}
	@Override
	public List<Vehicle> getByColor(String color) 
	{
		return repo.getByColor(color);
		
		
	}
	@Override
	public void deleteById(Integer id) 
	{
		repo.deleteById(id);
	}
	@Override
	public Vehicle updateVehicle(Vehicle v) {
		Vehicle v1=repo.findById(v.getId()).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", v));
		if(v1!=null)
		{
			v1.setName(v.getName());
			v1.setModel(v.getModel());
			v1.setColor(v.getColor());
			v1.setPrice(v.getPrice());
			return repo.save(v1);
		}
		else
		{
			throw new ResourceNotFoundException("Vehicle", "id", v.getId());
		}
	}
	@Override
	public List<Vehicle> vehicleByMorePrice(Double price) 
	{
		
		return repo.vehicleByMorePrice(price);
	}
	@Override
	public List<Vehicle> vehicleSortPriceSort() {
		return repo.vehicleSortPriceSort();
	}
	@Override
	public List<Vehicle> getAll() {
		
		return repo.getAll();
	}
	
	
	
	

}
