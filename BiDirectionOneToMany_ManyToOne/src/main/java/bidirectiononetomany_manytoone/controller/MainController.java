package bidirectiononetomany_manytoone.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bidirectiononetomany_manytoone.dto.Collage;
import bidirectiononetomany_manytoone.dto.Student;

public class MainController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Choice \n1.Save Student");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			Collage collage = new Collage();
			collage.setName("FC Collage");
			collage.setLocation("FC Road, Pune");
			collage.setFee(349999);
			
			Student student1= new Student();
			student1.setName("Ranjit");
			student1.setPhone(9595089559l);
			student1.setAddress("Pune");
			student1.setCollage(collage);
			
			Student student2= new Student();
			student2.setName("Uday");
			student2.setPhone(9566565655l);
			student2.setAddress("Kolhapur");
			student2.setCollage(collage);
			
			Student student3= new Student();
			student3.setName("Prashant");
			student3.setPhone(535564684l);
			student3.setAddress("Satara");
			student3.setCollage(collage);
			
			List<Student>list = new ArrayList<Student>();
			list.add(student1);
			list.add(student2);
			list.add(student3);
			
			collage.setStudents(list);
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ranjit");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			et.begin();
//			em.persist(collage);
			em.persist(student1);
			em.persist(student2);
			em.persist(student3);
			et.commit();		}
			break;
		case 2: {

		}
			break;
		default:
			break;
		}

		scanner.close();
	}
}
