package manytoone.pejm16.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytoone.pejm16.dto.Company;
import manytoone.pejm16.dto.Employee;

public class EmployeeDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ranjit");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveEmployee(Employee employee, int company_id) {
		Company company = em.find(Company.class, company_id);
		if (company != null) {
			employee.setCompany(company);

			et.begin();
			em.persist(employee);
			et.commit();
		} else {

		}
	}

	public void findEmployee(int id) {
		Employee employee = em.find(Employee.class, id);
		if (employee != null) {
			System.out.println(employee);
		} else {
			System.out.println("Employee Not Found");
		}
	}

	public void findAllEmployee() {
		Query query = em.createQuery("select e from Employee e");
		
		List<Employee> employees = query.getResultList();
		System.out.println(employees);
		
	}

	public void deleteEmployee(int id) {
		Employee employee = em.find(Employee.class, id);
		if (employee != null) {
			et.begin();
			em.remove(employee);
			et.commit();
			System.out.println("Employee "+id+" Has Been Deleted");
		} else {
			System.out.println("Employee "+id+" Has Not Found");
		}
		
	}

	public void updateEmployee(int id, Employee employee) {
		Employee dbemployee = em.find(Employee.class, id);
		if (dbemployee != null) {
			employee.setId(dbemployee.getId());
			employee.setCompany(dbemployee.getCompany());
			
			et.begin();
			em.merge(employee);
			et.commit();
			System.out.println("Employee "+id+" has Been Updated");
		} else {
			System.out.println("Employee "+id+" Has Not Found");
		}
	}
}
