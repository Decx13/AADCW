package com.example.lk.ijse.gdse63.travelcw.repo;

import com.example.lk.ijse.gdse63.travelcw.entity.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HotelRepo extends CrudRepository<Hotel,Integer> {
    List<Hotel> findByStar(int star);
}
