package com.example.lk.ijse.gdse63.travelcw.service;



import com.example.lk.ijse.gdse63.travelcw.dto.HotelDTO;
import com.example.lk.ijse.gdse63.travelcw.exception.DeleteFailException;
import com.example.lk.ijse.gdse63.travelcw.exception.NotFoundException;
import com.example.lk.ijse.gdse63.travelcw.exception.SaveFailException;
import com.example.lk.ijse.gdse63.travelcw.exception.UpdateFailException;

import java.util.List;

public interface HotelService {
    int save(HotelDTO hotelDTO) throws SaveFailException;
    void update(HotelDTO hotelDTO) throws UpdateFailException;
    void delete(int id) throws DeleteFailException, NotFoundException;
    HotelDTO search(int id) throws NotFoundException;
    List<HotelDTO> findByStarRate(int id) throws NotFoundException;
}
