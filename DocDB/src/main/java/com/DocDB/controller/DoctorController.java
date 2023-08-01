package com.DocDB.controller;

import com.DocDB.entities.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService service;

    @RequestMapping(value = "/doctor", method = RequestMethod.GET)
    public Doctor findById(@RequestParam(value = "id") Long id) {
        return service.findByUserId(id);
    }

    @RequestMapping(value = "/docByFirstname", method = RequestMethod.GET)
    public Doctor getByFirstname(@RequestParam(value = "fname") String fname) {
        return service.findByFirstname(fname);
    }

    @RequestMapping(value = "/docByLastname", method = RequestMethod.GET)
    public Doctor getByLastname(@RequestParam(value = "lname") String lname) {
        return service.findByLastname(lname);
    }

    @RequestMapping(value = "/docByFullName", method = RequestMethod.GET)
    public Doctor getByFullName(@RequestParam(value = "fname") String firstname,
                                @RequestParam(value = "lname") String lastname) {
        return service.findByFirstnameAndLastname(firstname,lastname);
    }

    @RequestMapping(value = "/docBySpeciality", method = RequestMethod.GET)
    public List<Doctor> findBySpeciality(@RequestParam(value = "speciality") String speciality) {
        return service.findBySpeciality(speciality);
    }

    @RequestMapping(value = "/doctor", method = RequestMethod.POST)
    public Doctor registerDoctor(@RequestBody Doctor doctor) {
        return service.createDoctor(doctor);
    }

    @RequestMapping(value = "/doctor", method = RequestMethod.PUT)
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return service.updateDoctor(doctor);
    }

}
