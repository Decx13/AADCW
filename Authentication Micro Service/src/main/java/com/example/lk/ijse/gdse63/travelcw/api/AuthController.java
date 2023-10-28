package com.example.lk.ijse.gdse63.travelcw.api;

import com.example.lk.ijse.gdse63.travelcw.config.JwtUtil;
import com.example.lk.ijse.gdse63.travelcw.dto.AdminDTO;
import com.example.lk.ijse.gdse63.travelcw.dto.ErrorResponse;
import com.example.lk.ijse.gdse63.travelcw.dto.LoginRequest;
import com.example.lk.ijse.gdse63.travelcw.dto.LoginResponse;
import com.example.lk.ijse.gdse63.travelcw.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/login")
@CrossOrigin
public class AuthController {

    private final AuthenticationManager authenticationManager;
    @Autowired
    private AdminService adminServiceImpl;
    private JwtUtil jwtUtil;
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;

    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginRequest loginReq)  {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword()));
            String email = authentication.getName();
            AdminDTO user = adminServiceImpl.searchUser(email);
            String token = jwtUtil.createToken(user);
            LoginResponse loginRes = new LoginResponse(email,token);
            return ResponseEntity.ok(loginRes);

        }catch (BadCredentialsException e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity getUser(@PathVariable String email){
        return ResponseEntity.ok(adminServiceImpl.searchUser(email));
    }
}