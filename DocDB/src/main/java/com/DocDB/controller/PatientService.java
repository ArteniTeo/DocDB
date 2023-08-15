package com.DocDB.controller;

import com.DocDB.entities.Patient;
import com.DocDB.reposiory.IPatientRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.DocDB.validator.PatientValidator.verifyPhoneNumber;
import static com.DocDB.validator.PatientValidator.verifyAge;

@Slf4j
@Service
@RequiredArgsConstructor
public class PatientService {

    private final IPatientRepository repository;

    public Patient createPatient(Patient patient) {
        verifyPhoneNumber(patient.getPhoneNumber());
        verifyAge(patient.getBirthDay());

        return repository.save(patient);
    }

    public Patient updatePatient(Patient patient){
        return repository.save(patient);
    }

    Patient findByUserId(Long id){return repository.findByUserId(id);}

    Patient findByCnp(String cnp){return repository.findByCnp(cnp);}
    Patient findByPhoneNumber(String phoneNumber){return repository.findByPhoneNumber(phoneNumber);}

    List<Patient> findByFirstname(String firstname){return repository.findByFirstname(firstname);}
    List<Patient> findByLastname(String lastname){return repository.findByLastname(lastname);}
    List<Patient> findByFirstnameAndLastname(String firstname, String lastname){return repository.findByFirstnameAndLastname(firstname, lastname);}


}