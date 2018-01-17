package sajjad.java.employee.app.employee;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRoute {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping(value = "/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> listEmployee() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable(value = "id")  Long id) {
		Employee employee = employeeRepository.findOne(id);
		
		if(employee == null) {
			return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable(value = "id")  Long id,
											@Valid @RequestBody Employee updateData) {
		Employee employee = employeeRepository.findOne(id);
		
		if(employee == null) {
			return ResponseEntity.notFound().build();
		}
		
		employee.setName(updateData.getName());
		if(updateData.getDepartment() != null) {
			employee.setDepartment(updateData.getDepartment());
		}
		
		Employee updatedEmployee = employeeRepository.save(employee);
		
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id")  Long id) {
		Employee employee = employeeRepository.findOne(id);
		
		if(employee == null) {
			return ResponseEntity.notFound().build();
		}
		
		employeeRepository.delete(employee);
		
		return ResponseEntity.ok().build();
	}
}
