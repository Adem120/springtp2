package com.adem;

import com.adem.entities.Machine;
import com.adem.entities.Utilisation;
import com.adem.repos.MachineReposotiry;
import com.adem.security.CustomUserDetailsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;

import java.util.Iterator;
import java.util.List;

@SpringBootTest
class Test {
	@Autowired
	MachineReposotiry machineRepository;
  @Autowired
  private CustomUserDetailsService customUserDetailsService;

	@org.junit.jupiter.api.Test
	void contextLoads() {
	}
	@org.junit.jupiter.api.Test
	void test() {
		List<Machine> m=machineRepository.findByNomAndPrix2("camoin", 20);
		if(m.isEmpty())
			System.out.println("vide");
		else

		for(Machine m1:m)
			System.out.println(m1.getPrix());
	}

@org.junit.jupiter.api.Test
	void test2() {
	Utilisation u = new Utilisation();
	u.setIdutili(3L);
		List<Machine> m=machineRepository.findUtilisation(u);
		if(m.isEmpty())
			System.out.println("vide");
		else

			for(Machine m1:m)
				System.out.println(m1.getPrix());
	}
	@org.junit.jupiter.api.Test
	void test3() {

		List<Machine> m=machineRepository.findByUtulisationIdutili(3L);
		if(m.isEmpty())
			System.out.println("vide");
		else

			for(Machine m1:m)
				System.out.println(m1.getPrix());
	}
	@org.junit.jupiter.api.Test
	void test4() {
		List<Machine> m=machineRepository.findAllOrderByNomAsc();
		if(m.isEmpty())
			System.out.println("vide");
		else{

			for(Machine m1:m)
				System.out.println(m1);
		}}
	@org.junit.jupiter.api.Test
	void test5(){
		System.out.println(customUserDetailsService.loadUserByUsername("admin1"));

	}
}
