package com.DocDB.dao.impl;

import com.DocDB.dao.LabResultsDao;
import com.DocDB.entities.LabResult;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

public class LabResultsDaoImpl implements LabResultsDao {

    private final JdbcTemplate jdbcTemplate;

    public LabResultsDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(LabResult labResult) {
        jdbcTemplate.update(
                "INSERT INTO \"DocDB\".lab_results (appointment_id, examination_name) VALUES ( ?, ?)",
                labResult.getAppointmentId(),
                labResult.getExaminationName()
        );
    }

    @Override
    public Optional<LabResult> find(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(LabResult labResult) {

    }

    @Override
    public void delete(Long id) {

    }
}
