package com.DocDB.reposiory;

import com.DocDB.entities.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationRepository extends JpaRepository<Observation, Long> {

    Observation getById(Long id);

}
