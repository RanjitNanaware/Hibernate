package BiDirection_OneToOne.Pejm16.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import BiDirection_OneToOne.Pejm16.Dto.AadharCard;
import BiDirection_OneToOne.Pejm16.Dto.Person;

public class PersonDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ranjit");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void savePerson(Person person) {
//		AadharCard aadharCard = person.getAadharCard();

		et.begin();
//		em.persist(aadharCard);
		em.persist(person);
		et.commit();
	}

	public void getPerson(int id) {
		Person person = em.find(Person.class, id);
		if (person != null) {
			System.out.println(person);
		} else {
			System.out.println("Person Not Found");
		}

	}

	public void fetAllPerson() {
		Query query = em.createQuery("select p from Person p");
		List<Person> persons = query.getResultList();
		if (persons != null) {
			System.out.println(persons);
		} else {
			System.out.println("List Is Empty");
		}

	}

	public void updatePerson(int id, Person person) {
		Person dbperson = em.find(Person.class, id);

		if (dbperson != null) {
			person.setId(id);
			person.getAadharCard().setId(dbperson.getAadharCard().getId());
			
			et.begin();
			em.merge(person);
			et.commit();
		} else {
			System.out.println(person.getName() + " Not Found");
		}
	}

	public void deletePerson(int id) {
		Person dbperson = em.find(Person.class, id);

		if (dbperson != null) {
//			AadharCard dbaadharCard = dbperson.getAadharCard();
			et.begin();
//			em.remove(dbaadharCard);
			em.remove(dbperson);
			et.commit();
		} else {
			System.out.println("Person Not Found");
		}

	}

}