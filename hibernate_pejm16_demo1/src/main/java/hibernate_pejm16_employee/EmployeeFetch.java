package hibernate_pejm16_employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeFetch {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ranjit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = entityManager.find(Employee.class, 2);
		if(employee != null) {
			System.out.println(employee);
		}else {
			System.out.println("Employee Not Found");
		}
	}
}
