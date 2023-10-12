package com.example.lk.ijse.gdse63.travelcw.api;

import com.example.lk.ijse.gdse63.travelcw.dto.GuideDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/guide")
@CrossOrigin
public class GuideApi {
    @GetMapping(value= "/id")

    public void search(@PathVariable String id){
        System.out.println("Search pressed");


    }

    @PostMapping
    public void save(@RequestBody GuideDTO userDTO){
        System.out.println("Save pressed :" + userDTO);

    }

    @PutMapping
    public void update(){
        System.out.println("Update pressed");

    }

    @DeleteMapping(value = "/id:\\d+")
    public void delete(){
        System.out.println("Delete pressed");

    }
}
