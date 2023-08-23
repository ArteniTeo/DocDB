package com.DocDB.controller;

import com.DocDB.entities.Appointment;
import com.DocDB.reposiory.AppointmentRepository;
import com.DocDB.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService service;

    private final AppointmentRepository repository;

    @GetMapping(value = "/appointment")
    public Appointment getAppointmentById(@RequestParam(value = "id") Long id){
        return repository.findById(id).orElseThrow();
    }

    @PostMapping(value = "/appointment")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment createdAppointment = service.createAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
    }

}