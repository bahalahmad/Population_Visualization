package com.kb.population.visualization.controller;

import com.kb.population.visualization.model.Model;
import com.kb.population.visualization.service.Servicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/population")
public class Controller {
    @Autowired
    private Servicee service;

    public Controller(Servicee service) {
        this.service = service;
    }

    @GetMapping
    public List<Model> getPopulationData() {
        // Calls the service to get the mock population data and return it as a response
        return service.getPopulationData();
    }
}
