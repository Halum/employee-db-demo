package sajjad.java.employee.app.employee;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="employee")
public class Employee  {

	@Id
//	@NotNull
	@Column(unique = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = true)
	private int managerId;

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

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	
	
	
//	public Employee() {}
//	
//	public Employee(Long id, String name, int managerId) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.managerId = managerId;
//	}
}
