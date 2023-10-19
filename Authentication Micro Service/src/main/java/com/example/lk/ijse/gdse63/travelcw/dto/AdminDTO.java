package com.example.lk.ijse.gdse63.travelcw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private int id;
    private String username;
    private String password;
    private String email;
    private String type;
}
