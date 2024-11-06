package com.example.politibil.Controller;

import com.example.politibil.Enums.OppdragType;
import com.example.politibil.Pojo.Politibil;
import com.example.politibil.Pojo.PolitibilUtenOppdragDTO;
import com.example.politibil.Service.PolitibilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/politibiler")
public class PolitibilController {

    @Autowired
    private PolitibilService service;

    @GetMapping("/{id}")
    public PolitibilUtenOppdragDTO getBil(@PathVariable Long id) {
        return service.getBilById(id);
    }

    @GetMapping("/tilgjengelige")
    public List<Politibil> getTilgjengeligeBiler() {
        return service.getTilgjengeligeBiler();
    }

    @PatchMapping("/tildel/{id}")
    public Politibil tildeleOppdrag(@PathVariable Long id, @RequestParam OppdragType oppdrag, @RequestParam String status) {
        return service.tildeleOppdrag(id, oppdrag, status);
    }
}
