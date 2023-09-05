package com.DocDB.reposiory;

import com.DocDB.entities.LabResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabResultRepository extends JpaRepository<LabResult, Long> {

    LabResult findLabResultById (Long id);

    List<LabResult> findLabResultByPatientId (Long id);

}
