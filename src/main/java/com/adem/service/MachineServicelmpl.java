package com.adem.service;

import java.util.List;

import com.adem.entities.Machine;
import com.adem.entities.Utilisation;
import com.adem.repos.UtilisationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.adem.repos.MachineReposotiry;


@Service
public class MachineServicelmpl implements MachineService{
	 MachineReposotiry machineRepository;
	 UtilisationRepository ul;
	public MachineServicelmpl(MachineReposotiry machineRepository,UtilisationRepository u) {
		this.machineRepository = machineRepository;
		this.ul=u;
	}

	@Override
	public Machine saveMachine(Machine m) {
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
	@Override
	public Page<Machine> getAllMachineByPage(int page, int size) {
		return machineRepository.findAll(PageRequest.of(page, size));

	}
	@Override
	public List<Utilisation> getAllUtilusation(){
		return ul.findAll();
	}
	@Override
	public Utilisation getUtilisationbyid(Long id){
		return  ul.getReferenceById(id);
	}
	
	}
	
	


	
	
	
	


