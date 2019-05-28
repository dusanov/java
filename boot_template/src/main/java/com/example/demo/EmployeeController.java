package com.example.demo;

import com.example.demo.payroll.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
class EmployeeController {

	private final EmployeeRepository repository;

	EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/employees")
	ResponseEntity<Resources<Resource<Employee>>> findAll() {

		List<Resource<Employee>> employees = StreamSupport.stream(repository.findAll().spliterator(), false)
			.map(employee -> new Resource<>(employee,
				linkTo(methodOn(EmployeeController.class).findOne(employee.getId())).withSelfRel(),
				linkTo(methodOn(EmployeeController.class).findAll()).withRel("employees")))
			.collect(Collectors.toList());

log.info(" +++ get required link  =+++++++ ");

		return ResponseEntity.ok(
			new Resources<>(employees,
				linkTo(methodOn(EmployeeController.class).findAll()).withSelfRel()));
	}

	@PostMapping("/employees")
	ResponseEntity<?> newEmployee(@RequestBody Employee employee) {

		try {
			Employee savedEmployee = repository.save(employee);

			Resource<Employee> employeeResource = new Resource<>(savedEmployee,
				linkTo(methodOn(EmployeeController.class).findOne(savedEmployee.getId())).withSelfRel());

log.info(" +++ get required link  =+++++++ ");

			return ResponseEntity
				.created(new URI(employeeResource.getLink(Link.REL_SELF).getHref()))
				.body(employeeResource);
		} catch (URISyntaxException e) {
			return ResponseEntity.badRequest().body("Unable to create " + employee);
		}
	}

	@GetMapping("/employees/{id}")
	ResponseEntity<Resource<Employee>> findOne(@PathVariable long id) {

		return repository.findById(id)
			.map(employee -> new Resource<>(employee,
				linkTo(methodOn(EmployeeController.class).findOne(employee.getId())).withSelfRel(),
				linkTo(methodOn(EmployeeController.class).findAll()).withRel("employees")))
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/employees/{id}")
	ResponseEntity<?> updateEmployee(@RequestBody Employee employee, @PathVariable long id) {

		Employee employeeToUpdate = employee;
		employeeToUpdate.setId(id);
		repository.save(employeeToUpdate);

		Link newlyCreatedLink = linkTo(methodOn(EmployeeController.class).findOne(id)).withSelfRel();

		try {
			return ResponseEntity.noContent()
				.location(new URI(newlyCreatedLink.getHref()))
				.build();
		} catch (URISyntaxException e) {
			return ResponseEntity.badRequest().body("Unable to update " + employeeToUpdate);
		}
	}

}
