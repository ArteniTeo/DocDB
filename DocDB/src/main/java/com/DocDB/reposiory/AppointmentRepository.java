package com.DocDB.reposiory;

import com.DocDB.common.AppointmentType;
import com.DocDB.entities.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

    List <Appointment> getAppointmentByPatientId(Long id);

    List<Appointment> getAppointmentByDate(Date date);

    List<Appointment> getAppointmentByDoctorId(Long id);

    Appointment getAppointmentByPatientIdAndDate(Long id, Date date);

    List<Appointment> findAppointmentByPatientIdAndDateGreaterThan(Long id, Date date);

    List<Appointment> findAppointmentByDoctorIdAndDateGreaterThan(Long id, Date date);

    @Query("SELECT a from Appointment a WHERE a.observations LIKE %:filter%")
    List<Appointment> findAppointmentByObservations(@Param("filter") String filter);

}
