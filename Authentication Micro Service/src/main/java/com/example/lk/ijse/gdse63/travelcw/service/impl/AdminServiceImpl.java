package com.example.lk.ijse.gdse63.travelcw.service.impl;

import com.example.lk.ijse.gdse63.travelcw.dto.AdminDTO;
import com.example.lk.ijse.gdse63.travelcw.entity.Admin;
import com.example.lk.ijse.gdse63.travelcw.repo.AdminRepo;
import com.example.lk.ijse.gdse63.travelcw.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepo adminRepository;

    private final ModelMapper modelMapper;

    public AdminServiceImpl(AdminRepo adminRepository , ModelMapper modelMapper ){
        this.adminRepository = adminRepository;
        this.modelMapper = modelMapper ;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByEmail(email);
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(admin.getEmail())
                        .password(admin.getPassword())
                        .roles(roles.toArray(new String[0]))
                        .build();
        return userDetails;
    }


    @Override
    public AdminDTO searchUser(String email) {
        Admin byEmail = adminRepository.findByEmail(email);
        System.out.println(byEmail);
        return modelMapper.map(byEmail , AdminDTO.class);
    }
}
