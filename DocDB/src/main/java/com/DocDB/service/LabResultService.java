package com.DocDB.service;

import com.DocDB.entities.LabResult;
import com.DocDB.reposiory.LabResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LabResultService {

    private final LabResultRepository repository;

    public LabResult createResult(LabResult result) {
        return repository.save(result);
    }

    public LabResult findResultById(Long id) {
        return repository.findLabResultById(id);
    }

    public List<LabResult> findPatientLabResultsBytPatientId(Long id) {
        return repository.findLabResultByPatientId(id);
    }

}
