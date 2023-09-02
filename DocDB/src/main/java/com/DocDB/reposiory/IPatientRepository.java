package com.DocDB.reposiory;

import com.DocDB.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface IPatientRepository extends JpaRepository<Patient, Long>{

//    @Query("SELECT * FROM \"DocDB\".doctors WHERE id = ?")
    Patient findByUserId(Long id);
    List <Patient> findByFirstname(String firstname);
    List <Patient> findByLastname(String lastname);
    List<Patient> findByFirstnameAndLastname(String firstname, String lastname);
    Patient findByCnp(String cnp);
    Patient findByPhoneNumber(String phoneNumber);

}
