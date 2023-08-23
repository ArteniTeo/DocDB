package com.DocDB.entities;

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

    @Column(name = "doctor_id")
    private Long doctorId;
    private Date date;
    private String details;
    private String observations;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
