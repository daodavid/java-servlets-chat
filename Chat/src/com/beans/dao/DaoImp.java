package com.beans.dao;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;

import com.beans.entity.Gender;
import com.beans.entity.Massage;
import com.beans.entity.Town;
import com.beans.entity.User;

@Configurable()
@Repository
public class DaoImp implements Dao {
	@Autowired
	SessionFactory sessionFact;

	@Override
	public boolean addUser(User user) {
		try {
			Session se = sessionFact.openSession();
			se.beginTransaction();
			se.save(user);

			se.getTransaction().commit();
			se.close();
			return true;
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		return false;

	}

	@Override
	public User getUser(String username) {
		Session ses = sessionFact.openSession();
		Criteria crit = ses.createCriteria(User.class);
		System.out.println("from hibernate" + username);
		crit.add(Restrictions.eq("username", username));

		List<User> users = crit.list();
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;

	}

	@Override
	public List<User> getUsers() {
		Session ses = sessionFact.openSession();
		Criteria crit = ses.createCriteria(User.class);

		List<User> users = crit.list();
		return users;

	}

	@Override
	public Gender getGender(String name) {
		Session ses = sessionFact.openSession();
		Criteria crit = ses.createCriteria(Gender.class);
		crit.add(Restrictions.eq("name", name));

		List<Gender> genders = crit.list();

		// ses.close();
		if (!genders.isEmpty()) {
			System.out.println("gender" + genders.get(0).getId() + genders.get(0).getName());
			return genders.get(0);

		}
		return null;
	}

	@Override
	public Town getTown(String name) {
		Session ses = sessionFact.openSession();
		Criteria crit = ses.createCriteria(Town.class);
		crit.add(Restrictions.eq("name", name));

		List<Town> towns = crit.list();
		System.out.println(towns.get(0));

		// ses.close();
		if (!towns.isEmpty()) {
			System.out.println("town  " + towns.get(0).getName() + towns.get(0).getId());
			return towns.get(0);

		}
		return null;

	}

	@Override
	public boolean addMassage(Massage msg) {
		try {
			Session se = sessionFact.openSession();
			se.beginTransaction();
			se.save(msg);

			se.getTransaction().commit();
			se.close();
			return true;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public Massage getMassage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Massage> getMassage(String usenameMassge, String withRetriever) {
		Session ses = sessionFact.openSession();

		/**
		 * Query qry =ses.createQuery(" select m.msg ,u.username as
		 * user_sender,v.username as user_retriever from massage as m join user
		 * as u on(u.id=m.user_sender) join user as v where
		 * v.id=m.user_retriever"); List<Massage> massages = qry.list()
		 **/
       if(usenameMassge!=null && withRetriever!=null){
		Criteria crit = ses.createCriteria(Massage.class);
		int idSender = getUser(usenameMassge).getId();
		int idRetriever = getUser(withRetriever).getId();
		crit.add(Restrictions.eq("friendShipId", (idSender+idRetriever ))).addOrder(Order.asc("id"));
		
		List<Massage> massages = crit.list();
		return massages;
       }
		return null;

	}

	@Override
	public List<Massage> getMassageRead(String usenameMassage, String NotRead) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteMassage(String msg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMassage(int id) {
		Session ses = sessionFact.openSession();
		Massage m = (Massage)ses.load(Massage.class,id);
		System.err.println("***************************************************8delete msg"+m.getMsg());    ses.delete(m);
		ses.flush();
		return true;
	}

}
