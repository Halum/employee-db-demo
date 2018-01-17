package sajjad.java.employee.app.employee;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import sajjad.java.employee.app.department.Department;

@Entity
@Table(name="employee")
public class Employee  {

	@Id
	@Column(unique = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String name;
	
	@JsonBackReference
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "departmentId")
	private Department department;
	
	public Employee() {}
	
	public Employee(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
