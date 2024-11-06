package com.example.politibil.Service;

import com.example.politibil.Pojo.Politibil;
import com.example.politibil.Repository.PolitibilRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class DummyDataService {

    private final PolitibilRepository repository;
    private final RestTemplate restTemplate;

    public DummyDataService(PolitibilRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void fetchAndSaveDummyData() {
        String url = "https://politibiler-case.bks-dev.politiet.no/";
        try {
            Politibil[] biler = restTemplate.getForObject(url, Politibil[].class);
            if (biler != null) {
                for (Politibil bil : biler) {
                    repository.save(bil);
                }
            }
        } catch (RestClientException e) {
            System.err.println("Fikk ikke hentet data: " + e.getMessage());
        }
    }
}