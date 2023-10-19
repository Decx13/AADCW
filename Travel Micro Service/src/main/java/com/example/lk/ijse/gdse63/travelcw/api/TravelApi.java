package com.example.lk.ijse.gdse63.travelcw.api;


import com.example.lk.ijse.gdse63.travelcw.dto.TravelDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/travel")
@CrossOrigin
public class TravelApi {
    @GetMapping(value = "/{id:\\d+}")
    public void search(@PathVariable String id){
        System.out.println("Search pressed :" +id );
    }
    @PostMapping
    public void save(@RequestBody TravelDTO travelPackageDTO){
        System.out.println("Save pressed :" + travelPackageDTO );
    }
    @PutMapping
    public void update(@RequestBody TravelDTO travelPackageDTO){
        System.out.println("Update pressed :" + travelPackageDTO);
    }
    @DeleteMapping(value = "/{id:\\d+}")
    public void delete(@PathVariable int id){
        System.out.println("Delete pressed : " + id);
    }
}