package com.DocDB.controller;

import com.DocDB.entities.Doctor;
import com.DocDB.reposiory.IDoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DoctorService {

    private final IDoctorRepository repository;

    public Doctor createDoctor(Doctor doctor) {

        //TODO implement security check and verification when making a doctor

        return repository.save(doctor);
    }

    public Doctor updateDoctor(Doctor doctor){
        return repository.save(doctor);
    }

    Doctor findByUserId(Long id){return repository.findByUserId(id);}

    List<Doctor> findByFirstname(String firstname){return repository.findByFirstname(firstname);}
    List<Doctor> findByLastname(String lastname){return repository.findByLastname(lastname);}
    List<Doctor> findByFirstnameAndLastname(String firstname, String lastname){return repository.findByFirstnameAndLastname(firstname, lastname);}

    public List<Doctor> findBySpeciality(String speciality){
        return repository.findBySpeciality(speciality);
    }


}
