package com.springsecuritywthJWT.config;

import com.springsecuritywthJWT.entity.Users;
import com.springsecuritywthJWT.repo.SecurityRepository;
import com.springsecuritywthJWT.utils.UserPrincipals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityConfig implements UserDetailsService {
    @Autowired
    SecurityRepository securityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = securityRepository.findByUsername(username);

        if (user == null) {
            try {
                throw new Exception("User Not Found");
            } catch (Exception e) {
               new RuntimeException(e);
            }
        }
        return new UserPrincipals(user);
    }
}
