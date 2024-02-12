package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
public class VehicleController 
{
	@Autowired
	VehicleService ser;
	
	@PostMapping("/addVehicle")
	ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle v)
	{
		return new ResponseEntity<Vehicle>(ser.addVehicle(v),HttpStatus.CREATED);
	}
	@GetMapping("/getById")
	ResponseEntity<Vehicle> getById(@RequestHeader Integer id)
	{
		return new ResponseEntity<Vehicle>(ser.getById(id), HttpStatus.FOUND);
	}
	
	@GetMapping("/getByColor")
	ResponseEntity<List<Vehicle>> getByColor(@RequestHeader String color)
	{
		return new ResponseEntity<List<Vehicle>>(ser.getByColor(color), HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteById")
	public void deleteById(@RequestParam("id") Integer id)
	{
		ser.deleteById(id);
		System.out.println("data Deleted");
	}
	@PutMapping("/updateVehicle")
	ResponseEntity<Vehicle > updateVehicle(@RequestBody Vehicle v)
	{
		return new ResponseEntity<Vehicle>(ser.updateVehicle(v), HttpStatus.OK);
	}
	
	@GetMapping("/vehicleByMorePrice")
	ResponseEntity<List<Vehicle>> vehicleByMorePrice(@RequestHeader Double price)
	{
		return new ResponseEntity<List<Vehicle>>(ser.vehicleByMorePrice(price),HttpStatus.FOUND);
	}
	
	@GetMapping("/vehicleSortPriceSort")
	ResponseEntity<List<Vehicle>> vehicleSortPriceSort()
	{
		return new ResponseEntity<List<Vehicle>>(ser.vehicleSortPriceSort(), HttpStatus.FOUND);
	}
	
	@GetMapping("/getAll")
	ResponseEntity<List<Vehicle>> getAll()
	{
		return new ResponseEntity<List<Vehicle>>(ser.getAll(), HttpStatus.FOUND);
	}

}
