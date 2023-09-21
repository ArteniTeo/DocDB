package com.DocDB.reposiory;

import com.DocDB.entities.Appointment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

    // PATIENT APPOINTMENTS REPOSITORIES ==========================================================
    @Transactional
    @Modifying
    @Query("update Appointment a set a.date = ?1, a.time = ?2 where a.id = ?3")
    void updateDateForAppointment(Date date, Time time, Long id);

    List<Appointment> findByPatient_IdOrderByDateAsc(Long id, Sort sort);

    List<Appointment> findByPatient_IdOrderByDateDesc(Long id, Sort sort);

    List<Appointment> findByPatient_IdAndDateGreaterThanOrderByDateDesc(Long id, Date fromDate);

    List<Appointment> findByPatient_IdAndDateLessThanOrderByDateDesc(Long id, Date toDate);

    List<Appointment> findByPatient_IdAndDateGreaterThanAndDateLessThanOrderByDateDesc(Long id, Date fromDate, Date toDate);

    // DOCTOR APPOINTMENTS REPOSITORIES ==========================================================

    List<Appointment> findByDoctor_IdOrderByDateAsc(Long id, Sort sort);

    List<Appointment> findByDoctor_IdOrderByDateDesc(Long id, Sort sort);

    List<Appointment> getAppointmentByDoctorId(Long id);

    List<Appointment> findAppointmentByDoctorIdAndDateGreaterThan(Long id, Date date);

}
