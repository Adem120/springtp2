package com.nadhem.users.service;

import java.util.List;

import com.nadhem.users.entities.Machine;



public interface MachineService {

	Machine saveMachine(Machine m);

	Machine updateMachine(Machine p);

	void deleteMachineById(Long id);

	Machine getMachine(Long id);

	List<Machine> getAllMachine();



	



	



}
