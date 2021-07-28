package com.ganesh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name="department")
@Entity
public class Department {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int departmentid;
	private String departmentname;
}
