package com.adem.repos;

import com.adem.entities.Machine;
import com.adem.entities.Utilisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UtilisationRepository extends JpaRepository<Utilisation,Long> {

}
