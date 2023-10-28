package com.adem.restcontroller;

import java.io.IOException;
import java.util.List;


import com.adem.entities.Machine;
import com.adem.entities.User;
import com.adem.service.Imageservice;
import com.adem.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/machine")
@CrossOrigin("*")
@Validated
public class MachineRestController {
	@Autowired
	MachineService machineService;
	@Autowired
	Imageservice imageService;
	@Autowired
	com.adem.service.UserService userService;
	@RequestMapping(method=RequestMethod.GET)
	List<Machine> getAllMachine()
	{
		return machineService.getAllMachine();
	}
	 @RequestMapping(method = RequestMethod.POST)
	    public Machine addNewMachine(@RequestBody Machine machine) throws IOException {
		return machineService.saveMachine(machine) ;
	    }
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Machine getMachineById(@PathVariable("id") Long id) {
		return machineService.getMachine(id);
	}
	@RequestMapping(method= RequestMethod.PUT)
	public Machine updateMachine(@RequestBody Machine machine) {
		return machineService.updateMachine(machine);
		
	}

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
public void deleteMachine(@PathVariable("id" )Long id) {
	machineService.deleteMachineById(id);
}
	
	
}
