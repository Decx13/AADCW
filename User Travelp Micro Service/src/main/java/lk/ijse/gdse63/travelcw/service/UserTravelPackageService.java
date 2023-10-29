package lk.ijse.gdse63.travelcw.service;


import lk.ijse.gdse63.travelcw.dto.UserTravelPackageDTO;
import lk.ijse.gdse63.travelcw.exception.SaveFailException;

public interface UserTravelPackageService {
    int save(UserTravelPackageDTO ob) throws SaveFailException;

}
