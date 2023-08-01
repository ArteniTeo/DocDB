package com.DocDB.reposiory;

import com.DocDB.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor findByUserId(Long id);
    Doctor findByFirstname(String firstname);
    Doctor findByLastname(String lastname);
    Doctor findByFirstnameAndLastname(String firstname, String lastname);
    List<Doctor> findBySpeciality(String speciality);


}
