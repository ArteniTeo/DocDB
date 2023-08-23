package com.DocDB.service;

import com.DocDB.common.Status;
import com.DocDB.entities.Patient;
import com.DocDB.entities.User;
import com.DocDB.reposiory.IPatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.DocDB.validator.PatientValidator.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class PatientService {

    private final IPatientRepository repository;
    private final UserService userService;

    public Patient createPatient(Patient patient) {
        verifyPhoneNumber(patient.getPhoneNumber());
        verifyAge(patient.getBirthDay());
        System.out.println("CNP = " + patient.getCnp() + " and BirthDay = " + patient.getBirthDay());
        verifyCnp(patient.getCnp(), patient.getBirthDay(), patient.getGender());

        if(findByCnp(patient.getCnp()) != null) throw new RuntimeException("CNP already in use.");

        User updateUser = userService.getUserById(patient.getUserId());
        updateUser.setStatus(Status.ACTIVE);
        userService.updateUser(updateUser);

        return repository.save(patient);
    }

    public Patient updatePatient(Patient patient){
        return repository.save(patient);
    }

    public Patient findByUserId(Long id){
        return repository.findByUserId(id);
    }

    public Patient findByCnp(String cnp){return repository.findByCnp(cnp);}
    public Patient findByPhoneNumber(String phoneNumber){return repository.findByPhoneNumber(phoneNumber);}

    public List<Patient> findByFirstname(String firstname){return repository.findByFirstname(firstname);}
    public List<Patient> findByLastname(String lastname){return repository.findByLastname(lastname);}
    public List<Patient> findByFirstnameAndLastname(String firstname, String lastname){return repository.findByFirstnameAndLastname(firstname, lastname);}


}
