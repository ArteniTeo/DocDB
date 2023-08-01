package com.DocDB.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "specialities")
public class Speciality {

    @Id
    @SequenceGenerator(
            name = "spec_id_seq",
            sequenceName = "spec_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "spec_id_seq"
    )
    private Long id;
    private String name;
    private String description;

}
