package com.adem.Controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.adem.entities.Utilisation;
import com.adem.repos.UtilisationRepository;

@Controller

public class Utilsationcontroller {
	@Autowired
	UtilisationRepository utilisationRepository;
	


    @RequestMapping("ajouterutil")
    public String showCreate() {

        return "ajouterutil";
    }
    @RequestMapping("/ajouteutl")
    public String saveutil(
            @ModelAttribute("utilisation") Utilisation utilisation,

            ModelMap modelMap
    ) {
        Utilisation util = utilisationRepository.save(utilisation);
        List<Utilisation> utilisations = utilisationRepository.findAll();
        modelMap.addAttribute("utilisations", utilisations);

        return "Listeutilisation";}
    @RequestMapping("/utilisation")
    public String listutil(
            ModelMap modelMap
    ) {
        List<Utilisation> utilisations = utilisationRepository.findAll();
        modelMap.addAttribute("utilisations", utilisations);

        return "Listeutilisation";
    }
@RequestMapping("/deleteutilisation")
public String deleteutil(
        @RequestParam("idutili") Long id,
        ModelMap modelMap
) {
    utilisationRepository.deleteById(id);
    List<Utilisation> utilisations = utilisationRepository.findAll();
    modelMap.addAttribute("utilisations", utilisations);

    return "Listeutilisation";
}
}
