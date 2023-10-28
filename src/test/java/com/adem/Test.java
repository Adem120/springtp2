package com.adem;

import com.adem.entities.Machine;
import com.adem.entities.Role;
import com.adem.entities.User;
import com.adem.entities.Utilisation;
import com.adem.repos.MachineReposotiry;
import com.adem.restcontroller.Authrest;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class Test {
	@Autowired
	MachineReposotiry machineRepository;
	@Autowired
	com.adem.repos.UserRepository userRepository;
	@Autowired
	com.adem.service.UserService userService;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	Authrest authrest;

	@org.junit.jupiter.api.Test
	void contextLoads() {
	}

	@org.junit.jupiter.api.Test
	void test() {
		List<Machine> m = machineRepository.findByNomAndPrix2("camoin", 20);
		if (m.isEmpty())
			System.out.println("vide");
		else

			for (Machine m1 : m)
				System.out.println(m1.getPrix());
	}

	@org.junit.jupiter.api.Test
	void test2() {
		Utilisation u = new Utilisation();
		u.setIdutili(3L);
		List<Machine> m = machineRepository.findUtilisation(u);
		if (m.isEmpty())
			System.out.println("vide");
		else

			for (Machine m1 : m)
				System.out.println(m1.getPrix());
	}

	@org.junit.jupiter.api.Test
	void test3() {

		List<Machine> m = machineRepository.findByUtulisationIdutili(3L);
		if (m.isEmpty())
			System.out.println("vide");
		else

			for (Machine m1 : m)
				System.out.println(m1.getPrix());
	}

	@org.junit.jupiter.api.Test
	void test4() {
		User existingUsername = userService.findUserByUsername("admin1");
		if (existingUsername != null) {
			System.out.println("username already exists");
		} else {
			System.out.println("username not exists");
		}
	}
	@org.junit.jupiter.api.Test
	void test5() {
		User u=userRepository.findByEmail("adem9958@gmail.com");
		System.out.println(u.getUsername());
	}
	}




