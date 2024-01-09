package manytomany_uni_pjcm16.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany_uni_pjcm16.dto.Course;

public class CourseDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ranjit");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void saveCourse(Course course) {
		et.begin();
		em.persist(course);
		et.commit();
	}
}
