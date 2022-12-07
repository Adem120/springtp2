package com.nadhem.users.restControllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nadhem.users.entities.Machine;
import com.nadhem.users.service.MachineService;




@RestController
@RequestMapping("/machine")
@CrossOrigin
@Validated
public class MachineRestController {
	@Autowired
	MachineService machineService;
	@RequestMapping(method=RequestMethod.GET)
	List<Machine> getAllMachine()
	{
		return machineService.getAllMachine();
	}
	 @RequestMapping(method = RequestMethod.POST)
	    public Machine addNewMachine(@RequestBody Machine machine) {
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
