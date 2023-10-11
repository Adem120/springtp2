package com.adem.service;

import com.adem.dto.RegistrationDto;
import com.adem.entities.Role;
import com.adem.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User addRoleToUser(String username, String rolename);

    Role addRole(Role role);

    User findUserByUsername(String username);

    void saveUserdto(RegistrationDto registrationDto);

    User updateUser(User user);


    void deleteUser(Long id);

    List< User > findAllUser();

    User findUserById(Long id);
}
