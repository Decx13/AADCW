package com.example.lk.ijse.gdse63.travelcw.service;

import com.example.lk.ijse.gdse63.travelcw.dto.AdminDTO;
import org.json.JSONException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AdminService extends UserDetailsService {

    AdminDTO searchUser(String email) throws JSONException;

}
