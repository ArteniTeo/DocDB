package com.DocDB.service;

import com.DocDB.entities.Appointment;
import com.DocDB.reposiory.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository repository;

    public Appointment getAppointmentById(Long id){return repository.getById(id);}

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

}
