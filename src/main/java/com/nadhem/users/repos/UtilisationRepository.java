package com.nadhem.users.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nadhem.users.entities.Utilisation;




public interface UtilisationRepository extends JpaRepository<Utilisation,Long> {
	
}
