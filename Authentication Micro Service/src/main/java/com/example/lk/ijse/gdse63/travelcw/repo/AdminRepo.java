package com.example.lk.ijse.gdse63.travelcw.repo;

import com.example.lk.ijse.gdse63.travelcw.entity.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepo extends CrudRepository<Admin, String> {

    Admin findByEmail(String email);

}