package com.example.lk.ijse.gdse63.travelcw.repo;


import com.example.lk.ijse.gdse63.travelcw.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepo extends CrudRepository<Vehicle,Integer> {
    List<Vehicle> findByCategory(String category);
}
