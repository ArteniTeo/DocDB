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

    @GetMapping(value = "/appointments")
    public List<Appointment> getAllAppointments() {
        return service.getAllAppointments();
    }

    @GetMapping(value = "/appointment")
    public Appointment getAppointmentById(@RequestParam(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/DoctorFutureAppointments")
    public List<Appointment> getFutureAppointmentsByDoctor(@RequestParam(value = "id") Long id) {
        return service.getAppointmentByDoctorIdAndDateGreaterThan(id);
    }

    @GetMapping(value = "/PatientFutureAppointments")
    public List<Appointment> getFutureAppointmentByPatient(@RequestParam(value = "id") Long id) {
        return service.getAppointmentByPatientIdAndDateGreaterThan(id);
    }

    @GetMapping(value = "/appointmentByObservations")
    public List<Appointment> getAppointmentByObservations(@RequestParam(value = "observations") String observations) {
        return service.findAppointmentByObservations(observations);
    }

    @GetMapping(value = "/appointmentsByDoctor")
    public List<Appointment> getAppointmentsByDoctorId(@RequestParam(value = "id") Long id) {
        return service.getDoctorAppointments(id);
    }

    @GetMapping(value = "/appointmentsByPatient")
    public List<Appointment> getAppointmentsByPatientId(@RequestParam(value = "id") Long id) {
        return service.getPatientAppointments(id);
    }

    @PostMapping(value = "/appointment")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment createdAppointment = service.createAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
    }



}