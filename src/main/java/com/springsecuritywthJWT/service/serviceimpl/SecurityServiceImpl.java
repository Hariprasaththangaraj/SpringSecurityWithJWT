package com.springsecuritywthJWT.service.serviceimpl;

import com.springsecuritywthJWT.entity.Users;
import com.springsecuritywthJWT.repo.SecurityRepository;
import com.springsecuritywthJWT.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    SecurityRepository securityRepository;

    @Override
    public List<Users> getUserDetails() {
        return securityRepository.findAll();
    }
}
