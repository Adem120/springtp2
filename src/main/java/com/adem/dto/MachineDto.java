package com.adem.dto;

import com.adem.entities.Image;
import com.adem.entities.Utilisation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MachineDto {
    private Long idMachine;
    private String nom;
    private double prix;
    private Date dateachat;
    private Image image;
    private Utilisation utulisation;


}
