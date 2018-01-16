package sajjad.java.employee.app.department;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sajjad.java.employee.app.employee.Employee;
import sajjad.java.employee.app.employee.EmployeeRepository;

@RestController
public class DepartmentRoute {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@PostMapping(value = "/departments")
	public Department createDepartment(@Valid @RequestBody Department department) {
		return departmentRepository.save(department);
	}
	
	@GetMapping("/departments")
	public List<Department> listDepartment() {
		return departmentRepository.findAll();
	}
	
	@GetMapping("/departments/{id}")
	public ResponseEntity<?> getDepartment(@PathVariable(value = "id")  Long id) {
		Department department = departmentRepository.findOne(id);
		
		if(department == null) {
			return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(department);
	}
	
	@PutMapping("/departments/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(value = "id")  Long id,
											@Valid @RequestBody Department updateData) {
		Department department = departmentRepository.findOne(id);
		
		if(department == null) {
			return ResponseEntity.notFound().build();
		}
		
		department.setName(updateData.getName());
		
		Department updatedDepartment = departmentRepository.save(department);
		
		return ResponseEntity.ok(updatedDepartment);
	}
	
	@DeleteMapping("/departments/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(value = "id")  Long id) {
		Department department = departmentRepository.findOne(id);
		
		if(department == null) {
			return ResponseEntity.notFound().build();
		}
		
		departmentRepository.delete(department);
		
		return ResponseEntity.ok().build();
	}
}
