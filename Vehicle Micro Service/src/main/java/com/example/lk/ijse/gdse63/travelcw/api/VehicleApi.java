package com.example.lk.ijse.gdse63.travelcw.api;


import com.example.lk.ijse.gdse63.travelcw.dto.VehicleDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehical")
@CrossOrigin
public class VehicleApi {

    @GetMapping(value= "/{id:\\d+}")

    public void search(@PathVariable String id){
        System.out.println("Search Vehical");


    }

    @PostMapping
    public void save(@RequestBody VehicleDTO vehicalDTO){
        System.out.println("Save vehical :" + vehicalDTO);

    }

    @PutMapping
    public void update(@RequestBody VehicleDTO vehicalDTO){
        System.out.println("Update vehical" +vehicalDTO);

    }

    @DeleteMapping(value= "/{id:\\d+}")
    public void delete(@PathVariable int id){
        System.out.println("Delete vehical");

    }
}