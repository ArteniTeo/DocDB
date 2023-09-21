package com.DocDB.controller;

import com.DocDB.entities.Appointment;
import com.DocDB.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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

    // PATIENT APPOINTMENTS CONTROLLERS ==========================================================

    @PostMapping(value = "/appointment")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment createdAppointment = service.createAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
    }

    @GetMapping(value = "/patientAppointmentsAscOrdered")
    public List<Appointment> getFutureAppointmentByPatientAsc(@RequestParam(value = "id") Long id) {
        return service.getPatientAppointmentsOrderByAscendingDate(id);
    }

    @GetMapping(value = "/patientAppointmentsDescOrdered")
    public List<Appointment> getFutureAppointmentByPatientDesc(@RequestParam(value = "id") Long id) {
        return service.getPatientAppointmentsOrderByDescendingDate(id);
    }

    @GetMapping(value = "/patientDateSpecificAppointment")
    public List<Appointment> getPatientAppointmentsByGivenDates(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "fromDate", required = false) Date fromDate,
            @RequestParam(value = "toDate", required = false) Date toDate){

        if(fromDate == null && toDate == null){
            return service.getPatientAppointmentsOrderByDescendingDate(id);
        } else if (fromDate != null && toDate == null) {
            return service.getPatientAppointmentsFromDateToLastAndOrderedDescByDate(id, fromDate);
        } else if (fromDate == null && toDate != null){
            return service.getPatientAppointmentsFromFirstToDateAndOrderedDescByDate(id, toDate);
        } else {
            return service.getPatientAppointmentsFromDateToDateAndOrderedDescByDate(id, fromDate, toDate);
        }
    }

    @PutMapping(value = "/rescheduleAppointment")
    public void rescheduleAppointment(@RequestBody Appointment appointment) {
        service.rescheduleAppointment(appointment);
    }

    @PutMapping(value = "/cancelAppointment")
    public void cancelAppointment(@RequestParam(value = "id") Long id) {
        service.cancelAppointment(id);
    }

    // DOCTOR APPOINTMENTS CONTROLLERS ==========================================================

    @GetMapping(value = "/DoctorFutureAppointments")
    public List<Appointment> getFutureAppointmentsByDoctor(@RequestParam(value = "id") Long id) {
        return service.getAppointmentByDoctorIdAndDateGreaterThan(id);
    }

    @GetMapping(value = "/appointmentsByDoctor")
    public List<Appointment> getAppointmentsByDoctorId(@RequestParam(value = "id") Long id) {
        return service.getDoctorAppointments(id);
    }

    @GetMapping(value = "/docAppointmentsAscOrdered")
    public List<Appointment> getFutureAppointmentByDocAsc(@RequestParam(value = "id") Long id) {
        return service.getDoctorAppointmentsOrderByAscendingDate(id);
    }

    @GetMapping(value = "/docAppointmentsDescOrdered")
    public List<Appointment> getFutureAppointmentByDocDesc(@RequestParam(value = "id") Long id) {
        return service.getDoctorAppointmentsOrderByDescendingDate(id);
    }

}