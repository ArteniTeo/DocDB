package com.DocDB.service;

import com.DocDB.entities.Doctor;
import com.DocDB.reposiory.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository repository;

    public Doctor createDoctor(Doctor doctor) {

        //TODO implement security check and verification when making a doctor

        return repository.save(doctor);
    }

    public Doctor updateDoctor(Doctor doctor){
        return repository.save(doctor);
    }

    public Doctor findByUserId(Long id){ return repository.findByUserId(id);}
    public List<Doctor> findByFirstname(String firstname){return repository.findByFirstname(firstname);}
    public List<Doctor> findByLastname(String lastname){return repository.findByLastname(lastname);}
    public List<Doctor> findByFirstnameAndLastname(String firstname, String lastname){return repository.findByFirstnameAndLastname(firstname, lastname);}

    public List<Doctor> findBySpeciality(String speciality){
        return repository.findBySpeciality(speciality);
    }


}
