package com.DocDB.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lab_results")
public class LabResult {

    @Id
    @SequenceGenerator(
            name = "lab results_id_seq",
            sequenceName = "lab results_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lab results_id_seq"
    )
    private Long id;

    @Column(name = "patient_id", unique = true)
    private Long patientId;
    @Column(name = "doctor_id", unique = true)
    private Long doctorId;
    @Column(name = "exam_date")
    private Date examDate;
    @Column(name = "exam_name")
    private String examinationName;
    private String results;

}
