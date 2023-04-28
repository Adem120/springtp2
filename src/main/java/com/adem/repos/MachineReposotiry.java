package com.adem.repos;


import com.adem.entities.Machine;
import com.adem.entities.Utilisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MachineReposotiry extends JpaRepository<Machine, Long> {
    @Query("select m from Machine m where m.nom = ?1 and m.prix> ?2")
   List <Machine> findByNomAndPrix(String nom, double prix);
    @Query("select m from Machine m where m.nom like %:nom and m.prix>:prix")
    List<Machine> findByNomAndPrix2(@Param("nom") String nom, @Param("prix") double prix);
    @Query("select m from Machine m where m.utulisation = :u")
    List<Machine> findUtilisation(Utilisation u);
    List<Machine> findByUtulisationIdutili(Long id);

    @Query("select m from Machine m ORDER BY m.nom ASC ")
    List<Machine> findAllOrderByNomAsc();



	
	


}
