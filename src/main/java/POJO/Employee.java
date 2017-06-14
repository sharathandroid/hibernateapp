package POJO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee implements Serializable {
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private Integer employeeId;
	public Employee(Integer employeeId, Integer deptId, String firstName, String lastName, String gender) {
		super();
		this.employeeId = employeeId;
		this.deptId = deptId;
		FirstName = firstName;
		LastName = lastName;
		this.gender = gender;
	}

	private Integer deptId;
	private String FirstName;
	private String LastName;
	private String gender;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	private Salary salary;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee",cascade = CascadeType.ALL)
	private Set<Address> address = new HashSet<Address>();

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public Set<Address> getAddressSet() {
		return address;
	}

	public void setAddressSet(Set<Address> addressSet) {
		this.address = addressSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
	//	result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((deptId == null) ? 0 : deptId.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
	//	result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (FirstName == null) {
			if (other.FirstName != null)
				return false;
		} else if (!FirstName.equals(other.FirstName))
			return false;
		if (LastName == null) {
			if (other.LastName != null)
				return false;
		} else if (!LastName.equals(other.LastName))
			return false;
//		if (address == null) {
//			if (other.address != null)
//				return false;
//		} else if (!address.equals(other.address))
//			return false;
		if (deptId == null) {
			if (other.deptId != null)
				return false;
		} else if (!deptId.equals(other.deptId))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
//		if (salary == null) {
//			if (other.salary != null)
//				return false;
//		} else if (!salary.equals(other.salary))
//			return false;
		return true;
	}

	public Employee(Integer employeeId, Integer deptId, String firstName, String lastName, String gender, Salary salary,
			Set<Address> addressSet) {
		super();
		this.employeeId = employeeId;
		this.deptId = deptId;
		FirstName = firstName;
		LastName = lastName;
		this.gender = gender;
		this.salary = salary;
		this.address = addressSet;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", deptId=" + deptId + ", FirstName=" + FirstName + ", LastName="
				+ LastName + ", gender=" + gender + ", salary=" + salary + ", address=" + address + "]";
	}

}
