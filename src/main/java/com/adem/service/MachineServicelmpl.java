package com.adem.service;

import java.util.List;

import com.adem.entities.Machine;
import com.adem.entities.Utilisation;
import com.adem.repos.ImageRepository;
import com.adem.repos.UtilisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.adem.repos.MachineReposotiry;


@Service
public class MachineServicelmpl implements MachineService{
	 MachineReposotiry machineRepository;
	 UtilisationRepository ul;
	ImageRepository imageRepository;
	public MachineServicelmpl(MachineReposotiry machineRepository,UtilisationRepository u,ImageRepository i) {
		this.machineRepository = machineRepository;
		this.ul=u;
		this.imageRepository=i;
	}

	@Override
	public Machine saveMachine(Machine m) {
		return machineRepository.save(m);
	}
	@Override
	public Machine updateMachine(Machine m) {
			Long oldProdImageId =
					this.getMachine(m.getIdMachine()).getImage().getIdImage();
			Long newProdImageId = m.getImage().getIdImage();
		Machine m1=machineRepository.save(m);
			if (oldProdImageId != newProdImageId) //si l'image a été modifiée
				imageRepository.deleteById(oldProdImageId);

			return m1;

	}
	@Override
	public void deleteMachineById(Long id) {
		Machine m =machineRepository.getById(id);
	imageRepository.deleteById(m.getImage().getIdImage());
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
	
	


	
	
	
	


