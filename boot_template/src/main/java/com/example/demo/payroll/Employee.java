package com.example.demo.payroll;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@XmlRootElement(name = "Employee")
public class Employee {

	@Id @GeneratedValue @XmlElement private Long id;
	@XmlElement private String firstName;
	@XmlElement private String lastName;
	@XmlElement private String role;

	/**
	 * Useful constructor when id is not yet known.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param role
	 */
	public Employee(String firstName, String lastName, String role) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
}
