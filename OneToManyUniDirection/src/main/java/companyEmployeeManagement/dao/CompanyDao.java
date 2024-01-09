package companyEmployeeManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import companyEmployeeManagement.dto.Company;
import companyEmployeeManagement.dto.Employee;

public class CompanyDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("ranjit").createEntityManager();
	}

	public void saveCompany(Company company) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		List<Employee> employees = company.getEmployees();
		for (Employee employee : employees) {
			entityManager.persist(employee);
		}
		entityManager.persist(company);
		entityTransaction.commit();
	}

	public void deleteCompany(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Company company = entityManager.find(Company.class, id);

		entityTransaction.begin();
		if (company != null) {
			List<Employee> employees = company.getEmployees();
			for (Employee employee : employees) {
				entityManager.remove(employee);
			}
			entityManager.remove(company);
			entityTransaction.commit();
		}

	}

	public void findEmployeeById(int id) {
		EntityManager entityManager = getEntityManager();

		Employee employee = entityManager.find(Employee.class, id);
		if (employee != null) {
			System.out.println(employee);
		} else {
			System.out.println("Employee Id Not Found");
		}

	}

	public void findAllEmployee() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from Employee e");
		List<Employee> employees = query.getResultList();

		System.out.println(employees);
	}

	public void fetchCompany(int id) {
		EntityManager entityManager = getEntityManager();
		Company company = entityManager.find(Company.class, id);
		if (company != null) {
			System.out.println(company);
		} else {
			System.out.println("Company Not Found");
		}
	}
	
	public void updateCompanyDeatails(int id , Company company) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Company dbcompany = entityManager.find(Company.class, id);
		if (dbcompany != null) {
			company.setId(id);
			company.setEmployees(dbcompany.getEmployees());
			entityTransaction.begin();
			entityManager.merge(company);
			entityTransaction.commit();
		} else {
			System.out.println("Company Id Not Found");
		}
		
	}

	public void updateAllDetails(int id, Company company) {
		EntityManager entityManager = getEntityManager();
		
		Company dbcompany = entityManager.find(Company.class, id);
		if (dbcompany != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			
			company.setId(id);
			entityTransaction.begin();
			List<Employee> employees = company.getEmployees();
			for (Employee employee : employees) {
				entityManager.merge(employee);
			}
			entityManager.merge(company);
			entityTransaction.commit();
			
		} else {
			System.out.println("Id And Company Not Found");
		}
		
	}
}