package com.ganesh.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @created: 11/09/2021 - 11:22 AM
 * @author: Ganesh
 */

@Entity
@Table(name="role")
@Data
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role(String name){
        super();
        this.name = name;
    }
}
