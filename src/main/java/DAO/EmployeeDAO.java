package DAO;

import POJO.Employee;

public interface EmployeeDAO {
	Employee createEmployee(Employee employee);

	void deleteEmployee(int empNo);

	Employee updateEmployee(Employee employee);

	Employee findEmployee(int empNo);
	void createQuery();

	void createCriteria();
}
