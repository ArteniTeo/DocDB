package com.DocDB.service;

import com.DocDB.entities.Appointment;
import com.DocDB.reposiory.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository repository;

    public Appointment getAppointmentById(Long id){return repository.getById(id);}

    public List<Appointment> getAppointmentByDoctorIdAndDateGreaterThan(Long id){
        return repository.findAppointmentByDoctorIdAndDateGreaterThan(id, new java.sql.Date(System.currentTimeMillis()));
    }

    public List<Appointment> getAppointmentByPatientIdAndDateGreaterThan(Long id){
        return repository.findAppointmentByPatientIdAndDateGreaterThan(id, new java.sql.Date(System.currentTimeMillis()));
    }

    public List<Appointment> findAppointmentByObservations(String observations){
        return repository.findAppointmentByObservations(observations);
    }


    public Appointment createAppointment(Appointment appointment){
        return repository.save(appointment);
    }

    public Appointment modifyAppointment(Appointment appointment){
        return repository.save(appointment);
    }

    public void cancelAppointment(Appointment appointment){
        repository.delete(appointment);
    }

    public List<Appointment> getDoctorAppointments(Long id){
        return repository.getAppointmentByDoctorId(id);
    }

    public List<Appointment> getPatientAppointments(Long id){
        return repository.getAppointmentByPatientId(id);
    }

    public List<Appointment> getPatientLabResults(Long id){return null;}

    public Appointment findById(Long id) {
        return repository.findById(id).orElse(new Appointment());
    }

    public List<Appointment> getAllAppointments() {
        return repository.getAppointments();
    }
}
