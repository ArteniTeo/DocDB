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

    /**
     *     @ManyToOne(fetch = FetchType.LAZY, optional = false)
     *     @JoinColumn(name = "post_id", nullable = false)
     *     @OnDelete(action = OnDeleteAction.CASCADE)
     *     @JsonIgnore
     */

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "patient_id", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Patient patient;

}
