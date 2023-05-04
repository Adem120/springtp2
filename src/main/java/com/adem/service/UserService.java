package com.adem.service;

import com.adem.dto.RegistrationDto;
import com.adem.entities.User;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    User findUserByUsername(String username);
}
