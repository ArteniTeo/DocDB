package com.DocDB.reposiory;

import com.DocDB.common.AppointmentType;
import com.DocDB.entities.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    @Transactional
    @Modifying
    @Query("update Appointment a set a.date = ?1, a.time = ?2 where a.id = ?3")
    void updateDateForAppointment(Date date, Time time, Long id);

    List<Appointment> getAppointmentByDoctorId(Long id);

    List<Appointment> findAppointmentByDoctorIdAndDateGreaterThan(Long id, Date date);

    @Query("SELECT a from Appointment a WHERE a.observations LIKE %:filter%")
    List<Appointment> findAppointmentByObservations(@Param("filter") String filter);

    List<Appointment> findByPatient_IdOrderByDateAsc(Long id, Sort sort);

    List<Appointment> findByPatient_IdOrderByDateDesc(Long id, Sort sort);

    List<Appointment> findByDoctor_IdOrderByDateAsc(Long id, Sort sort);

    List<Appointment> findByPatient_LastnameLikeIgnoreCaseOrderByPatient_LastnameAsc(String lastname, Sort sort);

}
