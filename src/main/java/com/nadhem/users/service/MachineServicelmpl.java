package com.nadhem.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadhem.users.entities.Machine;
import com.nadhem.users.repos.MachineReposotiry;


@Service
public class MachineServicelmpl implements MachineService{
	@Autowired
	 MachineReposotiry machineRepository;
	@Override
	public Machine saveMachine( Machine m) {
		return machineRepository.save(m);
	}
	@Override
	public Machine updateMachine(Machine m) {
	return machineRepository.save(m);
	
	}
	@Override
	public void deleteMachineById(Long id) {
	machineRepository.deleteById(id);
	}
	@Override
	public Machine getMachine(Long id) {
	return machineRepository.findById(id).get();
	}
	@Override
	public List<Machine> getAllMachine() {
	return machineRepository.findAll();
	}
	
	}
	
	


	
	
	
	


