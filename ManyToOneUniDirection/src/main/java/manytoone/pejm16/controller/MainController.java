package manytoone.pejm16.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoone.pejm16.dao.CompanyDao;
import manytoone.pejm16.dao.EmployeeDao;
import manytoone.pejm16.dto.Company;
import manytoone.pejm16.dto.Employee;

public class MainController {
	
	public static void main(String[] args) {
		Company company = new Company();
		company.setId(101);
		company.setName("BlackRock");
		company.setLocation("Washington");
		company.setGst("25");
//		
//		Employee employee1 = new Employee();
//		employee1.setId(1);
//		employee1.setName("Ranjit");
//		employee1.setPhone(9595089559l);
//		employee1.setAddress("KarveNagar");
//
//		Employee employee2 = new Employee();
//		employee2.setId(2);
//		employee2.setName("Swapnil");
//		employee2.setPhone(6464646333l);
//		employee2.setAddress("Warje");
//
//		Employee employee3 = new Employee();
//		employee3.setId(3);
//		employee3.setName("Nirbhay");
//		employee3.setPhone(95955553213l);
//		employee3.setAddress("Nigdi");
//		
//		employee1.setCompany(company);
//		employee2.setCompany(company);
//		employee3.setCompany(company);
		
		EmployeeDao dao = new EmployeeDao();
		CompanyDao companyDao = new CompanyDao();
		
		// 1 st Operation
		// Save Employee
//		EmployeeDao dao = new EmployeeDao();
//		dao.saveEmployee(employee1, 101);
//		dao.saveEmployee(employee2, 101);
//		dao.saveEmployee(employee3, 101);
		// To save Company
//		CompanyDao companyDao = new CompanyDao();
//		companyDao.saveCompany(company);
		
		// 2 nd Operation
		// dao.findEmployee(2);
		
		// 3 rd Operation
		// dao.findAllEmployee();
		
		// 4 th Operation
		// dao.deleteEmployee(1);
		
		// 5 th Operation
		
		Employee employee = new Employee();
		employee.setId(2);
		employee.setName("Juvekar");
		employee.setPhone(8380990809l);
		employee.setAddress("Kolhapur");
		employee.setCompany(company);
		
		dao.updateEmployee(2,employee);
		
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ranjit");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();
//		
//		et.begin();
//		em.persist(employee1);
//		em.persist(employee2);
//		em.persist(employee2);
//		em.persist(company);
//		et.commit();
		
	}
}
