package com.nadhem.users.entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity 
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long Idutili;
private String nomUtilisation;
@JsonIgnore
@OneToMany(mappedBy = "utulisation")
private List<Machine> machine;



}
