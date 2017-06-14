package DAO;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import POJO.Address;
import POJO.Employee;
import utilities.HibernateSessionfactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	SessionFactory sessionFactory = HibernateSessionfactory.getSessionFactory();

	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Serializable identifier = session.save(employee);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return null;

	}

	public void deleteEmployee(int empNo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Employee employee = findEmployee(empNo);
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(employee);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public Employee updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(employee);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return employee;
	}

	public Employee findEmployee(int empNo) {
		return (Employee) sessionFactory.openSession().get(Employee.class, new Integer(empNo));

	}

	public void createQuery() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Employee emp=(Employee) session.createQuery("from Employee where salary.salary > 10000 and deptId=10").uniqueResult();
		System.out.println("HQL to query Employee information (Employee, Salary, Address) who's salary greater than $10000 and Department is 10"+"\n"+emp.getFirstName()+"\n"+emp.getSalary().getSalary()+"\n"+emp.getAddressSet().iterator().next().toString());
		
	}

	public void createCriteria() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();

		//Criteria cr = session.createCriteria(Employee.class);
		Criteria c = session.createCriteria(Employee.class, "employee");
		c.createAlias("employee.salary", "salary"); // inner join by default
		c.createAlias("employee.address", "address");
		c.add(Restrictions.eq("salary.salary", new Integer(100000)));
		c.add(Restrictions.eq("address.zipcode", new Integer(62901)));
		Employee employee=(Employee) c.uniqueResult();
		/*cr.add(Restrictions.gt("salary", 10000));
		cr.add(Restrictions.eq("address",));
		Employee emp=(Employee) cr.uniqueResult();
	*/	System.out.println(employee.toString());
	}

}