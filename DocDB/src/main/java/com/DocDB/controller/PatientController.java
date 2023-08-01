package com.DocDB.controller;

import com.DocDB.entities.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequiredArgsConstructor
public class PatientController {

    private final PatientService service;

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public Patient findById(@RequestParam(value = "id") Long id) {
        return service.findByUserId(id);
    }

    @RequestMapping(value = "/patientByFirstname", method = RequestMethod.GET)
    public List<Patient> getByFirstname(@RequestParam(value = "fname") String fname) {
        return service.findByFirstname(fname);
    }

    @RequestMapping(value = "/patientByLastname", method = RequestMethod.GET)
    public List<Patient> getByLastname(@RequestParam(value = "lname") String lname) {
        return service.findByLastname(lname);
    }

    @RequestMapping(value = "/patientByFullName", method = RequestMethod.GET)
    public List<Patient> getByFullName(@RequestParam(value = "fname") String firstname,
                                      @RequestParam(value = "lname") String lastname) {
        return service.findByFirstnameAndLastname(firstname,lastname);
    }

    @RequestMapping(value = "/patientByCnp", method = RequestMethod.GET)
    public Patient findByCnp(@RequestParam(value = "cnp") String cnp) {
        return service.findByCnp(cnp);
    }

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public Patient registerPatient(@RequestBody Patient Patient) {
        return service.createPatient(Patient);
    }

    @RequestMapping(value = "/patient", method = RequestMethod.PUT)
    public Patient updatePatient(@RequestBody Patient Patient) {
        return service.updatePatient(Patient);
    }
}
