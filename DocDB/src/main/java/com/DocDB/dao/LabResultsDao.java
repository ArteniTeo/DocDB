package com.DocDB.dao;

import com.DocDB.entities.LabResult;

import java.util.Optional;

public interface LabResultsDao {

    void create(LabResult labResult);

    Optional<LabResult> find(Long id);

    void update(LabResult labResult);

    void delete(Long id);

}
