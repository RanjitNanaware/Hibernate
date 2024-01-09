package bidirection_manytomany.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bidirection_manytomany.dto.Language;
import bidirection_manytomany.dto.Person;

public class MainController {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Choice \n1.Save Person");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			Language language1 = new Language();
			language1.setName("Marathi");
			language1.setOrigin("MH");

			Language language2 = new Language();
			language2.setName("Kannada");
			language2.setOrigin("KAR");

			Language language3 = new Language();
			language3.setName("Telugu");
			language3.setOrigin("AP");

			Person person1 = new Person();
			person1.setName("Amol");
			person1.setPhone(9637076337l);
			person1.setAddress("Akluj");

			Person person2 = new Person();
			person2.setName("Ranjit");
			person2.setPhone(9595089559l);
			person2.setAddress("KarveNagar");

			Person person3 = new Person();
			person3.setName("Amit");
			person3.setPhone(9637076337l);
			person3.setAddress("Akurdi");

			// Set Person To Language First
			List<Language> list1 = new ArrayList<Language>();
			list1.add(language1);
			list1.add(language2);

			person1.setLanguages(list1);

			List<Language> list2 = new ArrayList<Language>();
			list2.add(language3);
			list2.add(language2);

			person2.setLanguages(list2);

			List<Language> list3 = new ArrayList<Language>();
			list3.add(language1);
			list3.add(language2);
			list3.add(language3);

			person3.setLanguages(list3);

			// Set Language To Person
			List<Person> list5 = new ArrayList<Person>();
			list5.add(person1);
			list5.add(person3);

			language1.setPersons(list5);

			List<Person> list6 = new ArrayList<Person>();
			list6.add(person1);
			list6.add(person2);

			language2.setPersons(list6);

			List<Person> list7 = new ArrayList<Person>();
			list7.add(person1);
			list7.add(person2);
			list7.add(person3);

			language3.setPersons(list7);

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ranjit");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();

			et.begin();
			em.persist(person1);
			em.persist(person2);
			em.persist(person3);
			em.persist(language1);
			em.persist(language2);
			em.persist(language3);
			et.commit();

		}
			break;

		default:
			break;
		}
		System.out.println("Person To Language Project Completed");
		scanner.close();
	}
}
