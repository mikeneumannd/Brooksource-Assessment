package com.example.demo.model;

import jakarta.persistence.*; 

@Entity
@Table(name = "Employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "emailAddress")
	private String emailAddress;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "birthDate")
	private String birthDate;
	
	@Column(name = "jobTitle")
	private String jobTitle;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "startDate")
	private String startDate;
	
	@Column(name = "managerReporting")
	private String managerReporting;

	public Employee() {

	}

	public Employee(long id, String firstName, String lastName, String emailAddress, String phone, String birthDate, String jobTitle, 
			String department, String location, String startDate, String managerReporting) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phone = phone;
		this.birthDate = birthDate;
		this.jobTitle = jobTitle;
		this.department = department;
		this.location = location;
		this.startDate = startDate;
		this.managerReporting = managerReporting;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getManagerReporting() {
		return managerReporting;
	}

	public void setManagerReporting(String managerReporting) {
		this.managerReporting = managerReporting;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + ", phone=" + phone + ", birthDate=" + birthDate + ", jobTitle=" + jobTitle
				+ ", department=" + department + ", location=" + location + ", startDate=" + startDate
				+ ", managerReporting=" + managerReporting + "]";
	}

}