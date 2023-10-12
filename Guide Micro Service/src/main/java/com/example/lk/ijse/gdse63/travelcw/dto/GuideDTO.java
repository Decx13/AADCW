package com.example.lk.ijse.gdse63.travelcw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuideDTO {
    private int id;
    private String guidename;
    private String address;
    private LocalDate birthday;
    private String contact;
    private String dayvalue;
    private String[] guideImg;
    private String gender;
    private String experience;
    private String remarks;
}
