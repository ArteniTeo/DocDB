package com.DocDB.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LabResult {

    private Long id;

    private Long patientId;

    private Long doctorId;

    private Date examDate;

    private String examinationName;

    private String results;

}
