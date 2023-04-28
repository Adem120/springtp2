package com.adem.entities;


import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Utilisation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idutili;
private String nomUtilisation;




}
