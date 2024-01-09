package personmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import personmanagement.dto.Person;

public class PersonDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ranjit");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void savePerson(Person person) {
		
		et.begin();
		em.persist(person.getAdharcard());
		em.persist(person);
		et.commit();
	}
	
	public void findPersonById(int id) {
		Person person = em.find(Person.class, id);
		System.out.println(person);
	}
	
	
	public void updatePersonOnly(int id,Person person) {
		Person dbPerson = em.find(Person.class, id);
		if(dbPerson != null)
		{
			person.setId(id);
			person.setAdharcard(dbPerson.getAdharcard());
			
			et.begin();
			em.merge(person);
			et.commit();
		}else {
			System.out.println("Id Not Found");
		}
	}

	public void FindAllPerson() {
		Query query = em.createQuery("select p from Person p");
		List<Person> persons = query.getResultList();
		
		System.out.println(persons);
	}

	public void updateAllDetails(int id, Person person) {
		Person dbperson = em.find(Person.class, id);
		if(dbperson != null) {
			person.setId(id);
			person.getAdharcard().setId(dbperson.getAdharcard().getId());
			
			et.begin();
			em.merge(person.getAdharcard());
			em.merge(person);
			et.commit();
			
			
			System.out.println("Successfully Updated");
		}
		
		
	}
}
