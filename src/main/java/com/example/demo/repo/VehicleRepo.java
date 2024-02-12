package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.module.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>
{
	@Query(value = "select * from Vehicle where color=?1", nativeQuery=true)
	List<Vehicle> getByColor(String color);
	
	@Query(value="select * from Vehicle where price>=?1", nativeQuery = true)
	List<Vehicle> vehicleByMorePrice(Double price);
	
	@Query(value="select * from Vehicle order by price asc", nativeQuery = true)
	List<Vehicle> vehicleSortPriceSort();
	
	@Query(value="select * from Vehicle", nativeQuery = true)
	List<Vehicle> getAll();
}
