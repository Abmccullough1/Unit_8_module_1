package com.example.people.People;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Person {

    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )

    private Long id;
    private String Name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Person() {
    }

    public Person(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        Name = name;
        this.email = email;
        this.dob = dob;
    }

    public Person(String name, String email, LocalDate dob) {
        Name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getDob() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.Name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}