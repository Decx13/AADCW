package com.example.lk.ijse.gdse63.travelcw.api;

import com.example.lk.ijse.gdse63.travelcw.dto.HotelDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hotel")
@CrossOrigin
    public class HotelApi {

        @GetMapping(value= "/{id:\\d+}")

        public void search(@PathVariable String id){
            System.out.println("Search hotel");


        }

        @PostMapping
        public void save(@RequestBody HotelDTO hotelDTO){
            System.out.println("Save hotel :" + hotelDTO);

        }

        @PutMapping
        public void update(@RequestBody HotelDTO hotelDTO){
            System.out.println("Update hotel" +hotelDTO);

        }

        @DeleteMapping(value= "/{id:\\d+}")
        public void delete(@PathVariable int id){
            System.out.println("Delete hotel");

        }
    }

