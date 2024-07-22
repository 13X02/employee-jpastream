package com.ust.Employee_jpastreamer.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ustdemo")
public class Employee {


    @Id
    @GeneratedValue
    @Column(name = "id")

    private Integer id;

    @Column(name = "Education")
    private String education;

    @Column(name = "JoiningYear")
    private Integer joiningYear;

    @Column(name = "City")
    private String city;

    @Column(name = "PaymentTier")
    private Integer paymentTier;

    @Column(name = "Age")
    private Integer age;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "EverBenched")
    private String everBenched;

    @Column(name = "ExperienceInCurrentDomain")
    private Integer experienceInCurrentDomain;

    @Column(name = "LeaveOrNot")
    private Integer leaveOrNot;
}
