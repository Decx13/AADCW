package lk.ijse.gdse63.travelcw.service;


import lk.ijse.gdse63.travelcw.dto.TravelPackageDTO;
import lk.ijse.gdse63.travelcw.exception.DeleteFailException;
import lk.ijse.gdse63.travelcw.exception.NotFoundException;
import lk.ijse.gdse63.travelcw.exception.SaveFailException;
import lk.ijse.gdse63.travelcw.exception.UpdateFailException;

import java.util.List;


public interface TravelPackageService {

    public String save(TravelPackageDTO obj) throws SaveFailException;
    void update(TravelPackageDTO obj) throws UpdateFailException;
    void delete(String id) throws DeleteFailException;
    List<TravelPackageDTO> getPackagesByCategory(String category);
    TravelPackageDTO fidById(String id) throws NotFoundException;
    List<TravelPackageDTO> findByCategory(String category) throws NotFoundException;
    String generateNextId();
}
