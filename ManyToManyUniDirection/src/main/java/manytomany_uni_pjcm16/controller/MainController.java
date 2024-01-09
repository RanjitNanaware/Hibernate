package manytomany_uni_pjcm16.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany_uni_pjcm16.dao.CourseDao;
import manytomany_uni_pjcm16.dao.StudentDao;
import manytomany_uni_pjcm16.dto.Course;
import manytomany_uni_pjcm16.dto.Student;

public class MainController {
	
	public static void main(String[] args) {
		Course course = new Course();
		course.setName("SQL");
		course.setFee(15000);
		course.setDuration(2);
		
		Course course2 = new Course();
		course2.setName("Java");
		course2.setFee(40000);
		course2.setDuration(4);
		
		Course course3 = new Course();
		course3.setName("J2EE");
		course3.setFee(20000);
		course3.setDuration(2);
		
		Student student = new Student();
		student.setName("Amol");
		student.setPhone(9637076337l);
		student.setAddress("Solapur");
		
		Student student2 = new Student();
		student2.setName("Ranjit");
		student2.setPhone(9595089559l);
		student2.setAddress("Pune");
		
		Student student3 = new Student();
		student3.setName("Amit");
		student3.setPhone(7773972655l);
		student3.setAddress("Akurdi");
		
		// 1. Operation All Methods
		
		List<Course> list = new ArrayList<Course>();
		list.add(course);
		list.add(course2);
		list.add(course3);
		student.setCourses(list);
		student3.setCourses(list);
		
		List<Course> list2 = new ArrayList<Course>();
		list2.add(course);
		list2.add(course3);
		student2.setCourses(list2);
		
		
		StudentDao studentDao = new StudentDao();
		studentDao.saveStudent(student);
		studentDao.saveStudent(student2);
		studentDao.saveStudent(student3);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ranjit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		em.persist(student);
		em.persist(student2);
		em.persist(student3);
		em.persist(course);
		em.persist(course2);
		em.persist(course3);
		
		et.commit();
		
		
//		CourseDao courseDao = new CourseDao();
//		courseDao.saveCourse(course);
//		courseDao.saveCourse(course2);
//		courseDao.saveCourse(course3);
//		
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		studentDao.saveStudent(student, list);
//		
		// 2. Operation Fetch Student
		
		// studentDao.fetchStudent(1);
		
		// 3. Operation To Fetch All Data
		
		// studentDao.findAllStudent();
		
		// 4. Operation To Update Student
		
		// studentDao.updateStudent(2, student2);
		
		// 5. Operation To Delete Student
		
		// studentDao.deleteStudent(2);
		
		
		
		
	}
}
