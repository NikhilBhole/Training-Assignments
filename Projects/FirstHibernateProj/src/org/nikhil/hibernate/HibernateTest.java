package org.nikhil.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.nikhil.dto.Address;
import org.nikhil.dto.FourWheeler;
import org.nikhil.dto.TwoWheeler;
import org.nikhil.dto.UserDetails;
import org.nikhil.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

//		UserDetails user = new UserDetails();
//		user.setName("User-1");
		
/*		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("vehicle-1");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setSteeringHandle("Bike Steering handle");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Car");
		fourWheeler.setSteeringWheel("Car Steering wheel");*/
		
/*		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("vehicle-2");
*/		
//		user.getVehicle().add(vehicle1);
//		user.getVehicle().add(vehicle2);
		
//		vehicle1.getUserList().add(user);
//		vehicle2.getUserList().add(user);
		
//		vehicle1.setUser(user);
//		vehicle2.setUser(user);
		
//		user.setVehicle(vehicle);
//		user.setAddress("address-1");
//		user.setJoinedDate(new Date());
//		user.setDiscription("Disciption for user-1");		
//		user.setHomeAddress(address);
		
/*		Address address1 = new Address();
		address1.setStreet("street-1");
		address1.setCity("city-1");
		address1.setState("state-1");
		address1.setPincode("pincode-1");
		
		Address address2 = new Address();
		address2.setStreet("street-2");
		address2.setCity("city-2");
		address2.setState("state-2");
		address2.setPincode("pincode-2");
*/
//		user.getListOfAddress().add(address1);
//		user.getListOfAddress().add(address2);
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
//		session.save(vehicle);
//		session.save(twoWheeler);
//		session.save(fourWheeler);
		
//		session.persist(user);
		
//		session.save(user);
//		session.save(vehicle1);
//		session.save(vehicle2);
		
//		String min = "5";
//		String name = "user-1";
	/*	Query query = session.createQuery("select name from UserDetails where id > ? and name = ?");
		query.setInteger(0, Integer.parseInt(min));//or query.setString(0, min);
		query.setString(1, name);
		
		Query query = session.createQuery("select name from UserDetails where id :id ? and name = :name");
		query.setInteger("id", Integer.parseInt(min));//or query.setString(0, min);
		query.setString("name", name);
		query.setFirstResult(1);
		query.setMaxResults(5);*/
		
//		Query query = session.getNamedQuery("UserDetails.byId");
//		query.setInteger(0, 5);
		
/*		Query query = session.getNamedQuery("UserDetails.byName");
		query.setString(0, "User-5");
		List<String> users = (List<String>) query.list();*/
//		List<UserDetails> users=(List<UserDetails>)query.list();
		
/*		UserDetails user = new UserDetails();
		user.setName("User-1%");
		
		Example userExample = Example.create(user).enableLike();//.excludeProperty("name");
		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(userExample);
//		criteria.setProjection(Projections.max("id"))
//		criteria.addOrder(Order.desc("id"));
//		criteria.add(Restrictions.eq("name", "user-5"))
//				.add(Restrictions.gt("id", 5));
		List<String> users = (List<String>) criteria.list();
		*/
		Query query = session.createQuery("from UserDetails user where user.id=5");
		query.setCacheable(true);
				
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		Query query2 = session2.createQuery("from UserDetails user where user.id=5");
		query2.setCacheable(true);
		session2.getTransaction().commit();
		session2.close();
//		for(UserDetails user : users){
//		System.out.println(user.getName());
		
/*		for(String user : users){
			System.out.println(user);
		}*/
/*		user=null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user.getListOfAddress().size());
		
	*/		
	}

}
