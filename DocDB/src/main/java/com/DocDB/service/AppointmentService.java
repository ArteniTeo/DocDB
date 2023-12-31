package com.DocDB.service;

import com.DocDB.common.AppointmentStatus;
import com.DocDB.entities.Appointment;
import com.DocDB.entities.Observation;
import com.DocDB.reposiory.AppointmentRepository;
import com.DocDB.reposiory.ObservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository repository;
    private final ObservationRepository obsRepository;

    public Appointment findById(Long id) {
        return repository.findById(id).orElse(new Appointment());
    }

    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    // PATIENT APPOINTMENTS SERVICE ==========================================================

    public Appointment createAppointment(Appointment appointment) {
        return repository.save(appointment);
    }

    public List<Appointment> getPatientAppointmentsOrderByAscendingDate(Long patientId) {
        return repository.findByPatient_IdOrderByDateAsc(patientId, Sort.by("date"));
    }

    public List<Appointment> getPatientAppointmentsOrderByDescendingDate(Long patientId) {
        return repository.findByPatient_IdOrderByDateDesc(patientId, Sort.by("date"));
    }

    public List<Appointment> getPatientAppointmentsFromDateToLastAndOrderedDescByDate(Long patientId, Date fromDate) {
        return repository.findByPatient_IdAndDateGreaterThanOrderByDateDesc(patientId, fromDate);
    }

    public List<Appointment> getPatientAppointmentsFromFirstToDateAndOrderedDescByDate(Long patientId, Date toDate) {
        return repository.findByPatient_IdAndDateLessThanOrderByDateDesc(patientId, toDate);
    }

    public List<Appointment> getPatientAppointmentsFromDateToDateAndOrderedDescByDate(Long patientId, Date fromDate, Date toDate) {
        return repository.findByPatient_IdAndDateGreaterThanAndDateLessThanOrderByDateDesc(patientId, fromDate, toDate);
    }

    public void rescheduleAppointment(Appointment appointment) {
        repository.updateDateForAppointment(appointment.getDate(), appointment.getTime(), appointment.getId());
    }

    public void cancelAppointment(Long id) {
        Appointment canceledAppointment = repository.getById(id);
        canceledAppointment.setStatus(AppointmentStatus.CANCELED);
        repository.save(canceledAppointment);
    }

    // DOCTOR APPOINTMENTS SERVICE ==========================================================

    public List<Appointment> getDoctorAppointmentsOrderByAscendingDate(Long patientId) {
        return repository.findByDoctor_IdOrderByDateAsc(patientId, Sort.by("date"));
    }

    public List<Appointment> getDoctorAppointmentsOrderByDescendingDate(Long patientId) {
        return repository.findByDoctor_IdOrderByDateDesc(patientId, Sort.by("date"));
    }

    public List<Appointment> getAppointmentByDoctorIdAndDateGreaterThan(Long id) {
        return repository.findAppointmentByDoctorIdAndDateGreaterThan(id, new java.sql.Date(System.currentTimeMillis()));
    }

    public List<Appointment> getDoctorAppointments(Long id) {
        return repository.getAppointmentByDoctorId(id);
    }

    public Appointment completeAnAppointment(Long appointmentId, Long observationId) {
        Appointment completedAppointment = repository.getById(appointmentId);
        completedAppointment.setStatus(AppointmentStatus.COMPLETED);
        Observation obs = obsRepository.getById(observationId);
        completedAppointment.setObservation(obs);
        return repository.save(completedAppointment);
    }
}
