package com.nadhem.users.restControllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nadhem.users.entities.Utilisation;
import com.nadhem.users.repos.UtilisationRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/utilisation")
public class UtilsationRestcontroller {
	@Autowired
	UtilisationRepository utilisationRepository;
	
    @RequestMapping(method = RequestMethod.GET)
    public List<Utilisation> getAllUtilisation(){
    	return utilisationRepository.findAll();
    }
  
    @RequestMapping(value = "/{Idutili}" , method = RequestMethod.GET)
    public Utilisation getUtilisationByID(@PathVariable("Idutili") Long Idutili) {
        return utilisationRepository.findById(Idutili).get() ;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Utilisation addNewUtilisation(@RequestBody Utilisation utilisation) {
        return utilisationRepository.save(utilisation) ;
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void deleteUtilisation(@PathVariable("id") Long idutili){
        utilisationRepository.deleteById(idutili);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public Utilisation updateutilisation(@RequestBody Utilisation utilisation){
        return utilisationRepository.save(utilisation);
    }
}
