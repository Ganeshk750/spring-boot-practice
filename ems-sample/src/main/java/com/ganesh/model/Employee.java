package com.ganesh.model;


import lombok.Data;

import javax.persistence.*;

/**
 * @created: 11/09/2021 - 11:21 AM
 * @author: Ganesh
 */


@Entity
@Table(name="employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;
}
