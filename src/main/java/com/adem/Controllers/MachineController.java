package com.adem.Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import com.adem.entities.Utilisation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.adem.entities.Machine;
import com.adem.service.MachineService;


@Controller
public class MachineController {

	MachineService machineService;

	public MachineController(MachineService machineService) {
		this.machineService = machineService;
	}

	@RequestMapping("ajoutermachine")
	public String showCreate(ModelMap modelMap) {
		List <Utilisation> u= machineService.getAllUtilusation();
			Machine machine = new Machine();
		modelMap.addAttribute("utilusation",u);
		modelMap.addAttribute("type","ajouter");
		modelMap.addAttribute("machine",machine);
		return "formulairemachine";
	}

	@RequestMapping("/save")
	public String savemachine(
	       @Valid Machine machine,
		   BindingResult r,
			@RequestParam("ul") String id,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size,
			ModelMap modelMap

	) {
		// Convert the date
		if(r.hasErrors()) {
			List <Utilisation> u= machineService.getAllUtilusation();

			modelMap.addAttribute("utilusation",u);
			modelMap.addAttribute("machine",machine);
			return "formulairemachine";}
		else {

			Long idd = Long.parseLong(id);

			Utilisation u = machineService.getUtilisationbyid(idd);
			machine.setUtulisation(u);
			Machine ajmach = machineService.saveMachine(machine);
			Page<Machine> machines = machineService.getAllMachineByPage(page, size);
			modelMap.addAttribute("machines", machines);
			modelMap.addAttribute("pages", new int[machines.getTotalPages()]);
			int n = machines.getTotalPages();
			modelMap.addAttribute("currentPage", n);

			return ("redirect:/machines?page="+n+"&size="+size);
		}

	}



		@RequestMapping("/machines")
	public String listmachine(
			ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size
	) {
		Page<Machine> machines = machineService.getAllMachineByPage(page, size);
		modelMap.addAttribute("machines", machines);
		modelMap.addAttribute("pages", new int[machines.getTotalPages()]);
		int n=machines.getTotalPages()/2;
		modelMap.addAttribute("currentPage", page);
		return "ListMachines";
	}

	@RequestMapping("/deletemachine")
	public String deleteAlbum(
			@RequestParam("IdMachine") Long id,
			ModelMap modelMap,
			@RequestParam(name = "page") String page,
			@RequestParam(name = "size",defaultValue = "2") int size
	) {
	machineService.deleteMachineById(id);
	int p=Integer.parseInt(page);
		Page<Machine> machine = machineService.getAllMachineByPage(p,size);
		modelMap.addAttribute("machines", machine);
		modelMap.addAttribute("pages", new int[machine.getTotalPages()]);
		int n= machine.getTotalPages()-1;
		if(n>p){
		modelMap.addAttribute("currentPage", 1);}
		else{
			modelMap.addAttribute("currentPage",1);
		}
		modelMap.addAttribute("size", size);
		return "ListMachines"; // Replace with your target URL
	}

	@RequestMapping("/showUpdate")
	public String showUpdate(
			@RequestParam("IdMachine") Long IdMachine,
			ModelMap modelMap
	) {
		Machine machine = machineService.getMachine(IdMachine);
		modelMap.addAttribute("machine", machine);
		modelMap.addAttribute("type","modifier");
		List <Utilisation> u= machineService.getAllUtilusation();
		modelMap.addAttribute("utilusation",u);

		return "formulairemachine";
	}

	@RequestMapping("/Modifiermachine")
	public String updateAlbum(
			@ModelAttribute("machine") Machine machine,
			@RequestParam("dateachat") String date,
			@RequestParam("ul") String id,
			//import page from url

			@RequestParam(name = "page",defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size,
			ModelMap modelMap
	) throws ParseException {
		// Convert the date
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date creationDate = dateFormat.parse(String.valueOf(date));
		machine.setDateachat(creationDate);
		Long idd= Long.parseLong(id);
		Utilisation u= machineService.getUtilisationbyid(idd);
		machine.setUtulisation(u);
		machineService.updateMachine(machine);
		Page<Machine> machines = machineService.getAllMachineByPage(0, 2);
		modelMap.addAttribute("machines", machines);
		modelMap.addAttribute("pages", new int[machines.getTotalPages()]);
		//convert string to int
int n=machines.getTotalPages()/size;
		modelMap.addAttribute("size", size);
		modelMap.addAttribute("currentPage", page);
		return ("redirect:/machines?page="+n+"&size="+size);
	}
}
