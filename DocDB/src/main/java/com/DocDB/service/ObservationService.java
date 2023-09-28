package com.DocDB.service;

import com.DocDB.entities.Observation;
import com.DocDB.reposiory.ObservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ObservationService {

    private final ObservationRepository repository;

    public Observation createObservation (Observation observation) {
        return repository.save(observation);
    }

    public Optional<Observation> findById(Long id) {
        return repository.findById(id);
    }

    public List<Observation> findAll() {
        return repository.findAll();
    }
}
