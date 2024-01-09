package hibernate_pejm16_employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeInsert {
	
	public static void main(String[] args) {
		
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Ranjit");
		employee.setPhone(9595089559l);
		employee.setAddress("Pune");
		employee.setEmail("Ranjit9559@gmail.com");
		employee.setPassword("123456");
		
		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setName("Shubham");
		employee2.setPhone(8380990809l);
		employee2.setAddress("Kolhapur");
		employee2.setEmail("Shubham123@gmail.com");
		employee2.setPassword("56789");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ranjit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(employee2);
		entityTransaction.commit();
		
		System.out.println("Data Inserted SuccessFully");
	}
}
