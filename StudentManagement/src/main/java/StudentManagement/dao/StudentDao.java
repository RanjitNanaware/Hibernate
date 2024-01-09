package StudentManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import StudentManagement.dto.Student;

public class StudentDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ranjit");
		EntityManager em = emf.createEntityManager();
		return em;
	}

	public void saveStudent(Student student) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(student);
		et.commit();

		if (student != null) {
			System.out.println("Student Inserted");
		} else {
			System.out.println("Failed To Insert Student");
		}
	}

	public void updateStudent(Student student) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(student);
		et.commit();

		if (student != null) {
			System.out.println("Student Updated");
		} else {
			System.out.println("Failed To Update Student");
		}

	}

	public void deleteStudent(int id3) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		Student student = em.find(Student.class, id3);

		if (student != null) {
			et.begin();
			em.remove(student);
			et.commit();
			System.out.println("Student Deleted");
		} else {
			System.out.println("Student with given id "+id3+" is Not Found");
		}
	}

	public void fetchStudent(int id4) {
		EntityManager em = getEntityManager();

		Student student = em.find(Student.class, id4);

		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("Student with given id "+id4+" is Not Found");
		}

	}

	public void showAllStudent() {
		EntityManager em = getEntityManager();

		Query query = em.createQuery("SELECT s FROM Student s");
		List<Student> students = query.getResultList();
		System.out.println(students);

	}

}
