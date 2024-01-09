package manytomany_uni_pjcm16.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytomany_uni_pjcm16.dto.Course;
import manytomany_uni_pjcm16.dto.Student;

public class StudentDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ranjit");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveStudent(Student student) {
		et.begin();
		List<Course> courses = student.getCourses();
		for (Course course : courses) {
			em.persist(course);
		}
		em.persist(student);
		et.commit();
	}

//	public void saveStudent(Student student, List<Integer> ids) {
//		et.begin();
//		List<Course> list = new ArrayList<Course>();
//		for (Integer integer : ids) {
//			Course course = em.find(Course.class, integer);
//			list.add(course);
//		}
//		student.setCourses(list);
//		em.persist(student);
//		et.commit();
//	}

	public void fetchStudent(int id) {
		Student dbstStudent = em.find(Student.class, id);
		if (dbstStudent != null) {
			System.out.println(dbstStudent);
		} else {
			System.out.println("Student Not Found");
		}
	}

	public void findAllStudent() {
		Query query = em.createQuery("Select s from Student s");

		List<Student> students = query.getResultList();

		System.out.println(students);
	}

	public void deleteStudent(int id) {
		Student dbstudent = em.find(Student.class, id);

		if (dbstudent != null) {
			String name = dbstudent.getName();
			et.begin();
			em.remove(dbstudent);
			et.commit();
			System.out.println(name + " Student Deleted Succesfully");

		} else {
			System.out.println("Id not found");
		}

	}

	public void updateStudent(int id, Student student) {
		Student dbstudent = em.find(Student.class, id);

		if (dbstudent != null) {
			student.setId(id);
			student.setCourses(dbstudent.getCourses());
			et.begin();
			em.merge(student);
			et.commit();
			System.out.println(student.getName() + " details Updated Succesfully");

		} else {
			System.out.println("Id not found");
		}

	}
}