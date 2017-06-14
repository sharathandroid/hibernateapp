package com.sharath.HiberanteApplication;

import java.util.HashSet;

import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import POJO.Address;
import POJO.Employee;
import POJO.Salary;

/**
 * Hello world!
 *
 */
public class Application 
{
    public static void main( String[] args )
    {
		Employee employee = new Employee(new Integer(1),new Integer(10), "Sharath", "Jaligama", "M");
		Address address = new Address(null, "1026 San Jacinto Dr.", "Irving", "Texas", 62901, employee);
    	Salary salary = new Salary(null,100000);

	//	employee.setEmployee(1, "Safee", "Bashir", "M", 10);
	//	salary.setSalary(null, 65000);
		employee.setSalary(salary);
		salary.setEmployee(employee);
	//	address.setAddress(null, "1026 San Jacinto Dr.", "Irving", "Texas", "USA", employee);
		employee.getAddressSet().add(address);
		EmployeeDAO employeeServices = new EmployeeDAOImpl();
		employeeServices.createEmployee(employee);
		employeeServices.createQuery();
		employeeServices.createCriteria();
		}
}
