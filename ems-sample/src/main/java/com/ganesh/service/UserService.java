package com.ganesh.service;


import com.ganesh.dto.UserRegistrationDto;
import com.ganesh.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @created: 11/09/2021 - 11:40 AM
 * @author: Ganesh
 */

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
