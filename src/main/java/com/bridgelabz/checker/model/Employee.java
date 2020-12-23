package com.bridgelabz.checker.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "employees")
public @Data class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "---------------------Employee First Name invalid...!!!--------------------------")
	@Column(name = "first_name")
	private String firstName;

	@Pattern(regexp = "^$|^[A-Z]{1}[a-zA-Z]{2,}$", message = "---------------------Employee Last Name invalid...!!!--------------------------")
	@Column(name = "last_name")
	private String lastName;

	@Pattern(regexp = "male|female", message = "---------------------Gender can only be male or female...!!!--------------------------")
	@Column(name = "gender")
	private String gender;

	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "employee_id"))
	@Column(name = "department")
	private List<String> department;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "start_date")
	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull(message = "Start Date shouldn't be empty")
	@PastOrPresent(message = "Start Date should be past or today's date")
	private LocalDate startDate;

	@Column(name = "salary")
	private long salary;

	@Column(name = "note")
	private String note;

	@Column(name = "profilePic")
	private String profilePic;

	public Employee() {

	}

	public Employee(String firstName, String lastName, String gender, List<String> department, String emailId,
			LocalDate startDate, Long salary, String note, String profilePic) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.department = department;
		this.emailId = emailId;
		this.startDate = startDate;
		this.salary = salary;
		this.note = note;
		this.profilePic = profilePic;
	}

	public Employee(String string, List<String> errMsg) {
		// TODO Auto-generated constructor stub
	}
}
