package com.example.politibil.Pojo;

import com.example.politibil.Enums.OppdragType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Politibil {
    @Id
    private Long id;
    private String merke;
    private String modell;
    private int årsmodell;
    private String regNr;
    private String status;
    private String oppdrag;
    public Politibil(Long id, String merke, String modell, String regNr, String status, OppdragType oppdrag, int årsmodell) {
        this.id = id;
        this.merke = merke;
        this.modell = modell;
        this.årsmodell = årsmodell;
        this.regNr = regNr;
        this.status = status;
        this.oppdrag = oppdrag.toString();
    }
}
