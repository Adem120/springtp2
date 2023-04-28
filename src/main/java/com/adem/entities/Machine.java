package com.adem.entities;



import java.util.Date;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Machine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idMachine;
@NotNull
@Size(min = 3, max = 20)
private String nom;


@NotNull
@Min(value=10)
@Max(value=10000)
	private double prix;
@PastOrPresent
@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd") // Specify expected date format
	private Date dateachat;
@ManyToOne
private Utilisation utulisation;



}




