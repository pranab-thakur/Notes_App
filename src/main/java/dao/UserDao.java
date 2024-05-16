package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.User;

public class UserDao {
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("karthik");
     EntityManager em=emf.createEntityManager();
     EntityTransaction et=em.getTransaction();
     
     
	public void SaveAndUpdateUser(User user) {
		
		et.begin();
		em.merge(user);
		et.commit();
		
	}
	
	public User FetchUserById(int id) {
		return em.find(User.class, id);
			
	}
	
	public User FetchUserByEmailAndPassword(String email,String password) {
		
		Query query=em.createQuery("select u from User u where u.email=?1 and u.password=?2");
		List<User>list=query.getResultList();
		if(list.isEmpty()) {
			return null;
		}else {
			return list.get(0);
		}
		
		

		 
	}
}
