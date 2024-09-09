package com.springsecuritywthJWT.repo;

import com.springsecuritywthJWT.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
