package com.adem.service;

import com.adem.dto.RegistrationDto;
import com.adem.entities.Role;
import com.adem.entities.User;

public interface UserService {

    User saveUser(User user);

    User addRoleToUser(String username, String rolename);

    Role addRole(Role role);

    User findUserByUsername(String username);
}
