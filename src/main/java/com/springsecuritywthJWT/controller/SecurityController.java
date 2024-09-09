package com.springsecuritywthJWT.controller;

import com.springsecuritywthJWT.entity.Users;
import com.springsecuritywthJWT.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
