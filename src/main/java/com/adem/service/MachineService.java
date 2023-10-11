package com.adem.service;

import java.util.List;

import com.adem.dto.MachineDto;
import com.adem.entities.Machine;
import com.adem.entities.Utilisation;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface MachineService {

	Machine saveMachine(Machine m);

	Machine updateMachine(Machine p);

	void deleteMachineById(Long id);

	Machine getMachine(Long id);

	List<Machine> getAllMachine();


    Page<Machine> getAllMachineByPage(int page, int size);

	List<Utilisation> getAllUtilusation();

	Utilisation getUtilisationbyid(Long id);

	MachineDto convertEntityToDto(Machine machine);
}
