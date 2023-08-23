package com.DocDB.entities;

import com.DocDB.common.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.sql.Date;

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
    @Column(unique = true)
    private String cnp;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "birth_day")
    private Date birthDay;
    @Enumerated(EnumType.STRING)
    private Gender gender;

//    @OneToOne
//    @JoinColumn(name = "appointment_id")

    @ToString.Exclude
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "appointment_id")
    @Fetch(FetchMode.JOIN)
    private Appointment appointment;
}
