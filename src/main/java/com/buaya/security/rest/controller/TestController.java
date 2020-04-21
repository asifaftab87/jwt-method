package com.buaya.security.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.buaya.security.model.Employee;
import com.buaya.security.model.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestController {

	private final Logger log = LoggerFactory.getLogger(TestController.class);

	private List<Employee> employees = createList();

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> firstPage() {
		log.info("-------------------------------firstPage------------------------------------------------");
		return employees;
	}

	@RequestMapping(value = "/emp", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> dfsd() {
		log.info("-------------------------------dfsd------------------------------------------------");
		return employees;
	}

	private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<>();
		Employee emp1 = new Employee();
		emp1.setName("emp1");
		emp1.setDesignation("manager");
		emp1.setEmpId("1");
		emp1.setSalary(3000);

		Employee emp2 = new Employee();
		emp2.setName("emp2");
		emp2.setDesignation("developer");
		emp2.setEmpId("2");
		emp2.setSalary(3000);
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		return tempEmployees;
	}

	@DeleteMapping(value = "/employees/delete/{id}")
	public Employee delete(@PathVariable("id") int id) {
		log.info("-------------------------------delete------------------------------------------------");
		Employee deletedEmp = null;
		for (Employee emp : employees) {
			if (emp.getEmpId().equals(id + "")) {
				employees.remove(emp);
				deletedEmp = emp;
				break;
			}
		}
		return deletedEmp;
	}

	@PostMapping("/employees/add")
	public Employee create(@RequestBody Employee user) {
		log.info("-------------------------------create------------------------------------------------ user: " + user);
		employees.add(user);
		log.info("emp list: " + employees);
		return user;
	}

	@PostMapping("/employees/postData")
	public void postData(@RequestBody User user) {
		System.out.println(user.toString());
	}

}
