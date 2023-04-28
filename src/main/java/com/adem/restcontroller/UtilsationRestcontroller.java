package com.adem.restcontroller;


import java.util.List;


import com.adem.entities.Utilisation;
import com.adem.repos.UtilisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
@RequestMapping(value="/utilisations")
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
