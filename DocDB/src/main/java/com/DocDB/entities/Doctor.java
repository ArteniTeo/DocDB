package com.DocDB.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor {
    public static final String RESOURCE_NAME = "doctor";

    @Id
    @SequenceGenerator(
            name = "doctors_id_seq",
            sequenceName = "doctors_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctors_id_seq"
    )
    private Long id;
    @Column(name = "user_id", unique = true)
    private Long userId;
    private String firstname;
    private String lastname;
    @OneToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

}
