package Hibernate_UserManagemnt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Hibernate_UserManagemnt.dto.User;

public class UserDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ranjit");
		EntityManager em = emf.createEntityManager();
		return em;
	}

	public void saveUser(User user) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(user);
		et.commit();
		System.out.println("SignUp Successfully");

	}

	public boolean loginUser(String email, String password) {
		EntityManager em = getEntityManager();
		
		Query query = em.createQuery("SELECT u FROM User u WHERE u.email=?1");
		query.setParameter(1, email);
		
		try {
			User user = (User) query.getSingleResult();
			
			if(password.equals(user.getPassword())) {
				return true;
			}else
				return false;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public void displayPassword(String email) {
		EntityManager em = getEntityManager();
		Query query = em.createQuery("SELECT u FROM User u WHERE u.email=?1");
		query.setParameter(1, email);
		
		User user = (User) query.getSingleResult();
		
		System.out.println("The Saved Password Are:");
		System.out.println("Facebook : "+user.getFacebook());
		System.out.println("WhatsApp : "+user.getWhatsapp());
		System.out.println("Twitter : "+user.getTwitter());
		System.out.println("SnapChat : "+user.getSnapchat());
		System.out.println("InstaGram : "+user.getInstagram());
	}

	public void updatePassword(String email, User user) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Query query = em.createQuery("SELECT u FROM User u WHERE u.email=?1");
		query.setParameter(1, email);
		User dbuser = (User) query.getSingleResult();
		
		if (dbuser != null) {
			user.setId(dbuser.getId());
			user.setName(dbuser.getName());
			user.setPhone(dbuser.getPhone());
			user.setEmail(dbuser.getEmail());
			user.setPassword(dbuser.getPassword());
			
			et.begin();
			em.merge(user);
			et.commit();
			
		} else {

		}
		
	}
	
}



