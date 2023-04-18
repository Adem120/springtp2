package com.adem.repos;

import com.adem.entities.Utilisation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilisationRepository extends JpaRepository<Utilisation,Long> {
	
}
