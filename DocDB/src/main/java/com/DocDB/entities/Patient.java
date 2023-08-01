package com.DocDB.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "patients")
public class Patient {
    public static final String RESOURCE_NAME = "patient";

    @Id
    @SequenceGenerator(
            name = "patients_id_seq",
            sequenceName = "patients_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patients_id_seq"
    )
    private Long id;
    @Column(name = "user_id", unique = true)
    private Long userId;
    private String firstname;
    private String lastname;
    private String cnp;
    @Column(name = "birth_day")
    private String birthDay;
}
