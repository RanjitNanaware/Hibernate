package personmanagement.controller;

import java.util.Scanner;

import personmanagement.dao.PersonDao;
import personmanagement.dto.AdharCard;
import personmanagement.dto.Person;

public class PersonController {

	static Scanner scanner = new Scanner(System.in);
	static PersonDao dao = new PersonDao();

	public static void main(String[] args) {
		System.out.println(
				"Enter The Option \n1.Save Person \n2.Find Person By Id \n3.Find All Person "
				+ "\n4.updatePersonOnly \n5.UpdateAll");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			savePerson();
			break;
		case 2:
			FindPersonById();
			break;
		case 3:
			FindAllPerson();
			break;
		case 4:
			updatePersonOnly();
			break;
		case 5:
			updateAllDetails();
			break;
		default:
			break;
		}
	}

	private static void savePerson() {
		AdharCard adharcard = new AdharCard();

		System.out.println("Enter ID For Adhar");
		adharcard.setId(scanner.nextInt());

		System.out.println("Enter Name For Adhar");
		adharcard.setName(scanner.next());

		System.out.println("Enter Address For Adhar");
		adharcard.setAddress(scanner.next());

		Person person = new Person();
		System.out.println("Enter Person Details \n");

		System.out.println("Enter Person Id");
		person.setId(scanner.nextInt());
		person.setName(adharcard.getName());
		System.out.println("Enter Person PhoneNumber");
		person.setPhone(scanner.nextLong());
		person.setAddress(adharcard.getAddress());
		System.out.println("Enter Person Age");
		person.setAge(scanner.nextInt());

		person.setAdharcard(adharcard);

		dao.savePerson(person);
	}

	private static void FindPersonById() {
		System.out.println("Enter Person Id To Fetch Details : ");
		int id = scanner.nextInt();

		dao.findPersonById(id);
	}

	private static void FindAllPerson() {
		dao.FindAllPerson();
	}

	private static void updatePersonOnly() {
		System.out.println("Enter Person New Id");
		int id = scanner.nextInt();

		Person person = new Person();
		System.out.println("Enter Person New Address");
		person.setAddress(scanner.next());
		System.out.println("Enter Person New Name");
		person.setName(scanner.next());
		System.out.println("Enter Person PhoneNumber");
		person.setPhone(scanner.nextLong());
		System.out.println("Enter Person Age");
		person.setAge(scanner.nextInt());

		dao.updatePersonOnly(id, person);
	}

	private static void updateAllDetails() {
		AdharCard adharcard = new AdharCard();
		Person person = new Person();
		
		System.out.println("Enter Person Id");
		int id = scanner.nextInt();

		System.out.println("Enter Name For Adhar");
		adharcard.setName(scanner.next());

		System.out.println("Enter Address For Adhar");
		adharcard.setAddress(scanner.next());

		System.out.println("Enter Person Details \n");

		person.setName(adharcard.getName());
		System.out.println("Enter Person PhoneNumber");
		person.setPhone(scanner.nextLong());
		person.setAddress(adharcard.getAddress());
		System.out.println("Enter Person Age");
		person.setAge(scanner.nextInt());

		person.setAdharcard(adharcard);
		
		dao.updateAllDetails(id, person);
	}

}
