package com.springsecuritywthJWT.service.serviceimpl;

import com.springsecuritywthJWT.config.JwtTokenGenerate;
import com.springsecuritywthJWT.entity.UserRequest;
import com.springsecuritywthJWT.entity.Users;
import com.springsecuritywthJWT.repo.SecurityRepository;
import com.springsecuritywthJWT.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    SecurityRepository securityRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenGenerate jwtTokenGenerate;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public List<Users> getUserDetails() {
        return securityRepository.findAll();
    }

    @Override
    public void postUserDetails(UserRequest userRequest) {
        Users users = new Users();
        users.setUsername(userRequest.getUsername());
        users.setPassword(encoder.encode(userRequest.getPassword()));
        users.setRole(userRequest.getRole().toUpperCase());
        users.setDate(new Date(System.currentTimeMillis()));
        securityRepository.save(users);

    }

    @Override
    public String userLogin(UserRequest userRequest) {
        Authentication autheneticate = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
        if (autheneticate.isAuthenticated()) {
            return jwtTokenGenerate.generateToken(userRequest.getUsername());
        }
        return "fail";
    }
}
