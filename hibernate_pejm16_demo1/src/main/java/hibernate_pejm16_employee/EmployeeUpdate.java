package hibernate_pejm16_employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeUpdate {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ranjit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
//		To Update Specific Data
		
//		Employee employee = entityManager.find(Employee.class, 2);
//		if(employee != null) {
//			employee.setName("Amol");
//			employee.setPhone(96370763337l);
//			employee.setAddress("Akluj");
//			employee.setEmail("Amol12@gmail.com");
//			employee.setPassword("112233");
//			
//			entityTransaction.begin();
//			entityManager.merge(employee);
//			entityTransaction.commit();
//			
//			System.out.println("Employee Updated");
//		}else {
//			System.out.println("Employee Id Not Found To Update");
//		}
		
//		To Update All Data
		
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Ranjit");
		employee.setPhone(9823300213l);
		employee.setAddress("Karvenagar");
		employee.setEmail("R123@gmail.com");
		employee.setPassword("11223344");
		
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		System.out.println("Employee Updated");
	}
}
