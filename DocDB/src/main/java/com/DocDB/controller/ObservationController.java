package com.DocDB.controller;

import com.DocDB.entities.Observation;
import com.DocDB.service.ObservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequiredArgsConstructor
public class ObservationController {

    private final ObservationService service;

    @GetMapping(value = "/obs")
    public Optional<Observation> getObservation(@RequestParam(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/obsS")
    public List<Observation> getAllObservations() {
        return service.findAll();
    }

    @PostMapping(value = "/obs")
    public Observation createObservation(@RequestBody Observation observation) {
        return service.createObservation(observation);
    }

}
