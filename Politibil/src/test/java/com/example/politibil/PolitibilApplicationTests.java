package com.example.politibil;

import com.example.politibil.Controller.PolitibilController;
import com.example.politibil.Enums.OppdragType;
import com.example.politibil.Pojo.Politibil;
import com.example.politibil.Pojo.PolitibilUtenOppdragDTO;
import com.example.politibil.Repository.PolitibilRepository;
import com.example.politibil.Service.PolitibilService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PolitibilApplicationTests {

    @Autowired
    private PolitibilRepository repository;
    @Autowired
    private PolitibilController controller;
    @Autowired
    private PolitibilService service;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void testGetBil() {
        Politibil dummyBil = new Politibil(1L, "Merke", "Modell", "REG1", "Tilgjengelig", OppdragType.AKTIV_BILJAKT, 2022);
        repository.save(dummyBil);

        PolitibilUtenOppdragDTO result = controller.getBil(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Merke", result.getMerke());
        assertEquals("Modell", result.getModell());
        assertEquals(2022, result.getÅrsmodell());
        assertEquals("REG1", result.getRegNr());
        assertEquals("Tilgjengelig", result.getStatus());
    }


    @Test
    void testGetTilgjenglige() {
        Politibil dummyBil1 = new Politibil(1L, "Merke", "Modell", "REG1", "Tilgjengelig", OppdragType.AKTIV_BILJAKT, 2022);
        Politibil dummyBil2 = new Politibil(2L, "Merke", "Modell", "REG1", "Tilgjengelig", OppdragType.AKTIV_BILJAKT, 2022);
        Politibil dummyBil3 = new Politibil(3L, "Merke", "Modell", "REG1", "non", OppdragType.AKTIV_BILJAKT, 2022);
        repository.save(dummyBil1);
        repository.save(dummyBil2);
        repository.save(dummyBil3);
        
        List<Politibil> result = controller.getTilgjengeligeBiler();

        assertEquals(2,result.size());
    }

    @Test
    void testPatchTildele() {
        Politibil dummyBil1 = new Politibil(1L, "Merke", "Modell", "REG1", "Tilgjengelig", OppdragType.AKTIV_BILJAKT, 2022);
        repository.save(dummyBil1);

        service.tildeleOppdrag(1l,OppdragType.BRANN,"NyStatus");

        assertEquals("NyStatus",controller.getBil(1L).getStatus());
    }



}
