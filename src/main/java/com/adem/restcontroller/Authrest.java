package com.adem.restcontroller;

import com.adem.dto.RegistrationDto;
import com.adem.entities.Image;
import com.adem.entities.Machine;
import com.adem.entities.User;
import com.adem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "*")
public class Authrest {

@Autowired
    UserService userService;


}