package com.mocker.interview.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DialectOverride;

@Data
@Entity
@Table(name = "interviewer")
public class Interviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String firstName;

    private String lastName;

    private int yearsOfExperience;

    private String education;

    private String selfIntro;

    private boolean active=Boolean.TRUE;
}
