package com.example.lk.ijse.gdse63.travelcw.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String category;
    private boolean petAllowed;
    private String mapLink;
    private int star;
    private String address;
    @Column(columnDefinition = "TEXT")
    private String phone;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String prices;
    @Column(columnDefinition = "TEXT")
    private String images;
    private String remarks;
}
