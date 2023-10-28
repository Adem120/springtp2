package com.adem.service;


import com.adem.dto.RegistrationDto;
import com.adem.entities.Role;
import com.adem.entities.User;
import com.adem.repos.RoleRepository;
import com.adem.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Arrays;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRep;
    @Autowired
    RoleRepository roleRep;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
@Autowired
 private JavaMailSender javaMailSender;
    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRep.save(user);
    }
    @Override
    public User addRoleToUser(String username, String rolename) {
        User usr = userRep.findByUsername(username);
        Role r = roleRep.findByName(rolename);
        usr.getRoles().add(r);
        return usr;
    }
    @Override
    public Role addRole(Role role) {
        return roleRep.save(role);
    }
    @Override
    public User findUserByUsername(String username) {
        return userRep.findByUsername(username);
    }
    @Override
    public void saveUserdto(RegistrationDto registrationDto) {
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setEmail(registrationDto.getEmail());
        Role role = roleRep.findByName("User");
        user.setRoles(Arrays.asList(role));
        int i = (int) (Math.random() * 1000000);
        user.setCode(i);
        user.setEnabled("not verified");
            String lien="http://localhost:4200/verifierCompte/"+user.getEmail();
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setFrom("adembensaid1508@gmail.com");
        msg.setTo("adem99538@gmail.com");
        msg.setSubject("Verification de compte");
        msg.setText("ouvrire se lien pour vérifier votre compte : "+lien +
                " votre code de vérification est : "+i);

        javaMailSender.send(msg);

        userRepository.save(user);
    }
    @Override
    public User updateUser(User user) {
         return userRepository.save(user);
    }
    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        user.setRoles(null);
        userRepository.save(user);
        userRepository.deleteById(id);
    }
    @Override
    public List<com.adem.entities.User> findAllUser() {
        return userRepository.findAll();
    }
    @Override
    public User findUserById(Long id) {


        return userRepository.findById(id).get();
    }
    @Override
    public List<Role> getRoles(){
        return roleRep.findAll();
    }
    @Override
    public ResponseEntity verifyUser(String email, Long code) {
        User user = userRepository.findByEmail(email);

        if (user.getCode() == code && user.getEnabled().equals("not verified")) {
            System.out.println(code);
            user.setEnabled("active");
            userRepository.save(user);
            return ResponseEntity.ok(200);
        }

        else {
            return ResponseEntity.badRequest().body(501);
        }

    }
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Override
    public void blockUser(Long id) {
        User user = userRepository.findById(id).get();
        user.setEnabled("blocked");
        userRepository.save(user);
    }
    @Override
    public void unblockUser(Long id) {
        User user = userRepository.findById(id).get();
        user.setEnabled("active");
        userRepository.save(user);
    }
}
