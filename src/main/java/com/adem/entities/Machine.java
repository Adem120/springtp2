package com.adem.entities;



import java.util.Date;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
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
	@DateTimeFormat(pattern = "yyyy-MM-dd") // Specify expected date format
	private Date dateachat;
@ManyToOne
private Utilisation utulisation;






}




