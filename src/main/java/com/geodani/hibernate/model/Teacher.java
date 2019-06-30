package com.geodani.hibernate.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator ="teacher_seq_gen")
    @SequenceGenerator(name= "teacher_seq_gen",
            sequenceName = "teacher_sequence")
    private Long id;

    @Column(name ="first_name")
    private String firstName;

    @Column (name= "last_name")
    private String lastName;

    @Column(name = "hide_date")
    @Temporal (TemporalType.TIMESTAMP)
    private Date hireDate;

    @Column(name= "salary")
    private Double salary;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
