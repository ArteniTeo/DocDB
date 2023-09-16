package com.DocDB.reposiory;

import com.DocDB.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {


    // Aparent exista deja o mtoda pt asta. Incredibil.
//    @Query("SELECT d from Doctor d")
//    List<Doctor> getDoctor();
    Doctor findByUserId(Long id);

    List<Doctor> findByFirstname(String firstname);

    List<Doctor> findByLastname(String lastname);

    List<Doctor> findByFirstnameAndLastname(String firstname, String lastname);
//    List<Doctor> findBySpeciality(String speciality);


}
