package com.example.politibil.Pojo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PolitibilUtenOppdragDTO {

    private Long id;
    private String merke;
    private String modell;
    private int årsmodell;
    private String regNr;
    private String status;

    public PolitibilUtenOppdragDTO(Long id, String merke, String modell, int årsmodell, String regNr, String status) {
        this.id = id;
        this.merke = merke;
        this.modell = modell;
        this.årsmodell = årsmodell;
        this.regNr = regNr;
        this.status = status;
    }
}
