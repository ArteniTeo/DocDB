package com.DocDB.entities;

import com.DocDB.common.AppointmentStatus;
import com.DocDB.common.AppointmentType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.sql.Date;
import java.sql.Time;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment {

    public static final String RESOURCE_NAME = "appointment";

    @Id
    @SequenceGenerator(
            name = "appointments_id_seq",
            sequenceName = "appointments_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointments_id_seq"
    )
    private Long id;
    private Date date;
    private Time time;
    private String details;
    @Column(name = "appointment_status")
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
    @Column(name = "appointment_type")
    @Enumerated(EnumType.STRING)
    private AppointmentType type;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @OneToOne
    @JoinColumn(name = "observation_id")
    private Observation observation;

}
