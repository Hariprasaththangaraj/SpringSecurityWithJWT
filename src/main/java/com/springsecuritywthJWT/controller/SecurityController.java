package com.springsecuritywthJWT.controller;

import com.springsecuritywthJWT.entity.UserRequest;
import com.springsecuritywthJWT.entity.Users;
import com.springsecuritywthJWT.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
public class SecurityController {

    @Autowired
    SecurityService securityService;

    @GetMapping("/getUserDetails")
    public List<Users> getUserDetails() {
        return securityService.getUserDetails();
    }

    @PostMapping("/postUserDetails")
    public ResponseEntity<String> postUserDetails(@RequestBody UserRequest userRequest) throws Exception {
        try {
            securityService.postUserDetails(userRequest);
            return ResponseEntity.ok("User Created Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody UserRequest userRequest) {
        return securityService.userLogin(userRequest);
    }

}
