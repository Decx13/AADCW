package com.example.lk.ijse.gdse63.travelcw.service;

import com.example.lk.ijse.gdse63.travelcw.dto.VehicleDTO;
import com.example.lk.ijse.gdse63.travelcw.exception.DeleteFailException;
import com.example.lk.ijse.gdse63.travelcw.exception.NotFoundException;
import com.example.lk.ijse.gdse63.travelcw.exception.SaveFailException;
import com.example.lk.ijse.gdse63.travelcw.exception.UpdatefailException;


import java.util.List;

public interface VehicleService {
    int saveVehicle(VehicleDTO dto) throws SaveFailException, SaveFailException;

    VehicleDTO searchVehicle(int id) throws NotFoundException, NotFoundException;

    List<VehicleDTO> searchByCategory(String category) throws NotFoundException;

    void updateVehicle(VehicleDTO dto) throws UpdatefailException, UpdatefailException;

    void deleteVehicle(int id) throws NotFoundException, DeleteFailException, DeleteFailException;

}
