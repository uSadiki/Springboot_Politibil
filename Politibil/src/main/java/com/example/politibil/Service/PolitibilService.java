package com.example.politibil.Service;

import com.example.politibil.Enums.OppdragType;
import com.example.politibil.Pojo.Politibil;
import com.example.politibil.Pojo.PolitibilUtenOppdragDTO;
import com.example.politibil.Repository.PolitibilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolitibilService {

    @Autowired
    private PolitibilRepository repository;

    public PolitibilUtenOppdragDTO getBilById(Long id) {
        Politibil bil = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bil ikke funnet"));

        return new PolitibilUtenOppdragDTO(
                bil.getId(),
                bil.getMerke(),
                bil.getModell(),
                bil.getÅrsmodell(),
                bil.getRegNr(),
                bil.getStatus()
        );
    }

    public List<Politibil> getTilgjengeligeBiler() {
        return repository.findByStatus("Tilgjengelig");
    }

    public Politibil tildeleOppdrag(Long id, OppdragType oppdrag, String status) {
        Politibil bil = repository.findById(id).orElseThrow(() -> new RuntimeException("Bil ikke funnet"));
        bil.setStatus(status);
        bil.setOppdrag(oppdrag.toString());
        return repository.save(bil);
    }


}
