package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository EmployeeRepository;

	@GetMapping("/Employees")
	public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(required = false) long id) {
		try {
			List<Employee> Employees = new ArrayList<Employee>();

			if (id == 0)
				EmployeeRepository.findAll().forEach(Employees::add);
			else
				EmployeeRepository.findByIDContaining(id).forEach(Employees::add);

			if (Employees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(Employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
		Optional<Employee> EmployeeData = EmployeeRepository.findById(id);

		if (EmployeeData.isPresent()) {
			return new ResponseEntity<>(EmployeeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/Employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee Employee) {
		try {
			Employee _Employee = EmployeeRepository
					.save(new Employee(Employee.getId(), Employee.getFirstName(), Employee.getLastName(), Employee.getEmailAddress(), Employee.getPhone()
							,Employee.getBirthDate(), Employee.getJobTitle(), Employee.getDepartment(), Employee.getLocation(), Employee.getStartDate()
							,Employee.getManagerReporting()));
			return new ResponseEntity<>(_Employee, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/Employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee Employee) {
		Optional<Employee> EmployeeData = EmployeeRepository.findById(id);

		if (EmployeeData.isPresent()) {
			Employee _Employee = EmployeeData.get();
			_Employee.setId(Employee.getId());
			_Employee.setFirstName(Employee.getFirstName());
			_Employee.setLastName(Employee.getLastName());
			_Employee.setEmailAddress(Employee.getEmailAddress());
			_Employee.setPhone(Employee.getPhone());
			_Employee.setBirthDate(Employee.getBirthDate()); 
			_Employee.setJobTitle(Employee.getJobTitle());
			_Employee.setDepartment(Employee.getDepartment());
			_Employee.setLocation(Employee.getLocation());
			_Employee.setStartDate(Employee.getStartDate());
			_Employee.setManagerReporting(Employee.getManagerReporting());
			return new ResponseEntity<>(EmployeeRepository.save(_Employee), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/Employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
		try {
			EmployeeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/Employees")
	public ResponseEntity<HttpStatus> deleteAllEmployees() {
		try {
			EmployeeRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}