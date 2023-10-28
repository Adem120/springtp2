package com.adem.restcontroller;

import com.adem.dto.RegistrationDto;
import com.adem.entities.Role;
import com.adem.entities.User;
import com.adem.repos.UserRepository;
import com.adem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class Authrest {

@Autowired
    UserService userService;
 @Autowired

    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public ResponseEntity<String> registerUser(@RequestBody  RegistrationDto user) throws IOException {
        System.out.println(user.getUsername());
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
    @RequestMapping(method = RequestMethod.GET,value = "/all")
    public List<com.adem.entities.User> getAllUser() {
      return userService.findAllUser();

    }
    @RequestMapping(method = RequestMethod.GET,value = "/roles")
    public List<Role> getAllRoles() {
        return userService.getRoles();

    }
    @RequestMapping(method = RequestMethod.GET,value = "/user/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return userService.findUserByUsername(username);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/verifier")
    public ResponseEntity verifyUser(@RequestParam("email") String email, @RequestParam("code") String  code) {
        Long code1 = Long.parseLong(code);

      return   userService.verifyUser(email, code1);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/verifier/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return userService.findUserByEmail(email);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/block/{id}")
    public void blockUser(@PathVariable("id") Long id) {
        userService.blockUser(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/unblock/{id}")
    public void unblockUser(@PathVariable("id") Long id) {
        userService.unblockUser(id);
    }





}