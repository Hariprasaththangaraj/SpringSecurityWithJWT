package com.springsecuritywthJWT.service;

import com.springsecuritywthJWT.entity.Users;

import java.util.List;

public interface SecurityService {
    List<Users> getUserDetails();
}
