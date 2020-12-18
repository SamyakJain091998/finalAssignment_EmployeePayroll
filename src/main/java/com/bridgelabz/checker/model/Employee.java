package com.bridgelabz.checker.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Table(name = "employees")
public @Data class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "---------------------Employee Name invalid...!!!--------------------------")
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "salary")
	private long salary;

	@Column(name = "note")
	private String note;

	@Column(name = "profilePic")
	private String profilePic;

	public Employee() {

	}

	public Employee(String firstName, String lastName, String emailId, Long salary, String note, String profilePic) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.salary = salary;
		this.note = note;
		this.profilePic = profilePic;
	}

	public Employee(String string, List<String> errMsg) {
		// TODO Auto-generated constructor stub
	}
}
