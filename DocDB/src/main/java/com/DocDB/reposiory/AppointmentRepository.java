package com.DocDB.reposiory;

import com.DocDB.common.AppointmentType;
import com.DocDB.entities.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

//    @Query("SELECT a from Appointment a")
//    List<Appointment> getAppointments();

//    @Query("SELECT a from Appointment a WHERE a.patient_id = :id ORDER by a.date")
    List <Appointment> getAppointmentByPatientId(Long id);

    List<Appointment> getAppointmentByDate(Date date);

    List<Appointment> getAppointmentByDoctorId(Long id);

    Appointment getAppointmentByPatientIdAndDate(Long id, Date date);

    List<Appointment> findAppointmentByPatientIdAndDateGreaterThan(Long id, Date date);

    List<Appointment> findAppointmentByDoctorIdAndDateGreaterThan(Long id, Date date);

    @Query("SELECT a from Appointment a WHERE a.observations LIKE %:filter%")
    List<Appointment> findAppointmentByObservations(@Param("filter") String filter);

    List<Appointment> findByPatient_IdOrderByDateAsc(Long id, Sort sort);

    List<Appointment> findByDoctor_IdOrderByDateAsc(Long id, Sort sort);

    List<Appointment> findByPatient_LastnameLikeIgnoreCaseOrderByPatient_LastnameAsc(String lastname, Sort sort);


}
