package com.example.lk.ijse.gdse63.travelcw.service;

import com.example.lk.ijse.gdse63.travelcw.dto.GuideDTO;
import com.example.lk.ijse.gdse63.travelcw.exception.DeleteFailException;
import com.example.lk.ijse.gdse63.travelcw.exception.SaveFailException;
import com.example.lk.ijse.gdse63.travelcw.exception.SearchFailException;
import com.example.lk.ijse.gdse63.travelcw.exception.UpdateFailException;

public interface GuidService {
    int saveGuide(GuideDTO guideDTO) throws SaveFailException;
    void updateGuide(GuideDTO guideDTO) throws UpdateFailException;
    void deleteGuide(int id) throws DeleteFailException;
    GuideDTO getGuide(int id) throws SearchFailException;
}
