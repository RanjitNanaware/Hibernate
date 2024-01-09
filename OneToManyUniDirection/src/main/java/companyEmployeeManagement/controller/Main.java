package companyEmployeeManagement.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import companyEmployeeManagement.dto.Company;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ranjit");
		EntityManager em = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager();
		
		em.find(Company.class, 1);
		em.find(Company.class, 1);
		em.find(Company.class, 1);
		
		
		
		em2.find(Company.class, 1);
		em2.find(Company.class, 1);
		em2.find(Company.class, 1);
		
		
	}
}
