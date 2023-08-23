package com.DocDB.reposiory;

import com.DocDB.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

    Appointment getAppointmentByPatientId(Long id);

    Appointment getAppointmentByDoctorId(Long id);

    List<Appointment> getAppointmentByDate(Date date);

    Appointment getAppointmentByPatientIdAndDate(Long id, Date date);



}
