package BiDirection_OneToOne.Pejm16.Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import BiDirection_OneToOne.Pejm16.Dao.PersonDao;
import BiDirection_OneToOne.Pejm16.Dto.AadharCard;
import BiDirection_OneToOne.Pejm16.Dto.Person;

public class MainController {

	public static void main(String[] args) {

		PersonDao personDao = new PersonDao();

		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Enter The Choice \n1.Save Person Details \n2.Fetch Person \n3.Fetch All Person "
				+ "\n4.Update Person \n5.Delete Person");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			AadharCard aadharCard = new AadharCard();
			aadharCard.setName("Ranjit Nanaware");
			aadharCard.setAddress("Pune");

			Person person = new Person();
			person.setName("Ranjit");
			person.setPhone(9595089559l);
			person.setAddress("MAH");

			person.setAadharCard(aadharCard);
			aadharCard.setPerson(person);

			// Save 1 Person
			personDao.savePerson(person);

			AadharCard aadharCard2 = new AadharCard();
			aadharCard2.setName("Amol Nanaware");
			aadharCard2.setAddress("Akluj");

			Person person2 = new Person();
			person2.setName("Amol");
			person2.setPhone(9637076337l);
			person2.setAddress("MAH");

			person2.setAadharCard(aadharCard2);
			aadharCard2.setPerson(person2);

			// Save 2 Person
			personDao.savePerson(person2);
		}
			break;
		case 2: {
			personDao.getPerson(2);
		}
			break;
		case 3: {
			personDao.fetAllPerson();
		}
			break;
		case 4: {
			Person person = new Person();
			person.setName("Amit");
			person.setPhone(7773972655l);
			person.setAddress("MAH");

			personDao.updatePerson(1, person);
		}
			break;
		case 5: {
			personDao.deletePerson(2);
		}
			break;
		default:
			break;
		}
	}
}
