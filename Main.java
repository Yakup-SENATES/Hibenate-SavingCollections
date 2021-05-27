package com.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.Adress;
import com.hibernate.demo.City;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		City city = new City() ; 	
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			
			city.setName("Test1");
			
			city.setCountryCode("TUR");
			
			city.setDistrict("Akdeniz");
			
			
			city.setPopulation(215000);
			
			Adress addr = new Adress();
			Adress addr2 = new Adress();
					
			addr2.setStreet("Second street");
			addr2.setState("Second State");
			addr2.setPincode("0123");
			
			addr.setStreet("Street");
			addr.setState("Türkiye");
			addr.setPincode("0101"); 
			
			
			city.getListOfAdresses().add(addr);
			city.getListOfAdresses().add(addr2);
			
			session.save(city);
			
			
			session.getTransaction().commit();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}finally {
			
			session.close();
		}
		
		
	}

}



	
