package com.nadhem.users.entities;



import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Machine {
	public Machine(String nom, double prix, Date dateachat) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.dateachat = dateachat;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long IdMachine;
private String nom;
private double prix;
private Date dateachat;
@ManyToOne
private Utilisation utulisation;






}




