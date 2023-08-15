package com.DocDB.entities;

import com.DocDB.common.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient{
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
    private Gender gender;

    public Patient(Long userId, String firstname, String lastname, String cnp, String phoneNumber, Date birthDay, Gender gender) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.cnp = cnp;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.gender = gender;
    }
}
