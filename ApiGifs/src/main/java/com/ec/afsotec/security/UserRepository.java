package com.ec.afsotec.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.afsotec.security.model.User;




public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
