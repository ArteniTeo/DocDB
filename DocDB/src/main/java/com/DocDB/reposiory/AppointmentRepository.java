package com.DocDB.reposiory;

import com.DocDB.common.AppointmentType;
import com.DocDB.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

    List <Appointment> getAppointmentByPatientId(Long id);

    List<Appointment> getAppointmentByDate(Date date);

    List<Appointment> getAppointmentByDoctorId(Long id);

    Appointment getAppointmentByPatientIdAndDate(Long id, Date date);

    List<Appointment> findAppointmentByPatientIdAndDateGreaterThan(Long id, Date date);

    List<Appointment> findAppointmentByDoctorIdAndDateGreaterThan(Long id, Date date);






}
