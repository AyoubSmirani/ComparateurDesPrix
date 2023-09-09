package com.example.annuaire.controller;



import com.example.annuaire.entities.User;
import com.example.annuaire.jwt.JwtTokenProvider;
import com.example.annuaire.jwt.loginReq;
import com.example.annuaire.jwt.loginres;

import com.example.annuaire.services.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/")
@CrossOrigin(origins="http://localhost:4200/")
public class User2Controller {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService2 userService;



    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody loginReq loginRequest) {

        User user = userService.getUserByEmail(loginRequest.getEmail());
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
        	  return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        String jwt = jwtTokenProvider.generateToken(user);

        return ResponseEntity.ok(new loginres(jwt));
    }

    @GetMapping("/test")
    public ResponseEntity<?> testAuth() {
        return new ResponseEntity<>("Authorized", HttpStatus.OK);
    }
   
}
