package manytoone.pejm16.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoone.pejm16.dto.Company;

public class CompanyDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ranjit");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void saveCompany(Company company) {
		et.begin();
		em.persist(company);
		et.commit();
	}	
}
