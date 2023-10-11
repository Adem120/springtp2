package com.adem.restcontroller;

import com.adem.dto.RegistrationDto;
import com.adem.entities.User;
import com.adem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "*")
public class Authrest {

@Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@RequestBody  RegistrationDto user) throws IOException {
        User existingUsername = userService.findUserByUsername(user.getUsername());
        if (existingUsername != null) {
            return ResponseEntity.badRequest().build();
        }
       else {
            userService.saveUserdto(user);
            return ResponseEntity.accepted().build();        }
    }

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }
    @RequestMapping(method= RequestMethod.PUT)
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);

    }
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id" )Long id) {
        userService.deleteUser(id);
    }

}