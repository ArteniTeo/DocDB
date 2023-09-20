package com.DocDB.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "observations")
public class Observation {

    @Id
    @SequenceGenerator(
            name = "observations_id_seq",
            sequenceName = "observations_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "observations_id_seq"
    )
    private Long id;
    private String diagnosis;
    @Column(name = "applied_procedure")
    private String appliedProcedure;
    private String recommendation;
    private String treatment;
    private String referral;

}
