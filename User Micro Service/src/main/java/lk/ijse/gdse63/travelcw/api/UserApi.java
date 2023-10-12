package lk.ijse.gdse63.travelcw.api;

import lk.ijse.gdse63.travelcw.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserApi {
    @GetMapping(value= "/id")

    public void search(@PathVariable String id){
        System.out.println("Search pressed");


    }

    @PostMapping
    public void save(@RequestBody UserDTO userDTO){
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