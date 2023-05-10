package com.adem.Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import com.adem.entities.Utilisation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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
			@RequestParam(name = "page",defaultValue = "0") int page,
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
			if(!id.contains("Pas Utilisation")){
			Long idd = Long.parseLong(id);
			Utilisation u = machineService.getUtilisationbyid(idd);
			machine.setUtulisation(u);}
			Machine ajmach = machineService.saveMachine(machine);
			Page<Machine> machines = machineService.getAllMachineByPage(page, size);
			modelMap.addAttribute("machines", machines);
			modelMap.addAttribute("pages", new int[machines.getTotalPages()]);
			int n = machines.getTotalPages();
             if(page==0){
				 System.out.println("ajouter");
				 return ("redirect:/machines?page="+n+"&size="+size);

			 }else{
				 System.out.println("modifier");

				 return ("redirect:/machines?page="+page+"&size="+size);
			}}
		}





		@RequestMapping("/machines")
	public String listmachine(
			ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size
	) {

			AbstractAuthenticationToken authentication= (AbstractAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
			if (authentication != null && authentication.isAuthenticated()) {
				String username = authentication.getName();
				System.out.println("User " + username + " is accessing /machines");}
		Page<Machine> machines = machineService.getAllMachineByPage(page, size);
		modelMap.addAttribute("machines", machines);
		modelMap.addAttribute("pages", new int[machines.getTotalPages()]);
		modelMap.addAttribute("authentification",authentication);
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
		int n=machine.getTotalPages();
        		modelMap.addAttribute("currentPage", p);
		modelMap.addAttribute("size", size);
		return "ListMachines"; // Replace with your target URL
	}

	@RequestMapping("/showUpdate")
	public String showUpdate(
			@RequestParam("IdMachine") Long IdMachine,
			ModelMap modelMap,@RequestParam(name = "page") String page
	) {
		Machine machine = machineService.getMachine(IdMachine);
		modelMap.addAttribute("machine", machine);
		modelMap.addAttribute("type","modifier");
		List <Utilisation> u= machineService.getAllUtilusation();
		modelMap.addAttribute("utilusation",u);
        modelMap.addAttribute("page",page);
		return "formulairemachine";
	}


}
