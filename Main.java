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
					
			addr2.setStreet("SEcond street");
			addr2.setState("second State");
			addr2.setPincode("0123");
			addr.setStreet("Street");
			addr.setState("Türkiye");
			addr.setPincode("0101"); 
			
			
			city.getListOfAdresses().add(addr);
			city.getListOfAdresses().add(addr2);
			
			session.save(city);
			
//-----------------READ---------------------
//			List<String> countryCodes = 
//					session.createQuery("select c.countryCode FROM City c GROUP BY c.countryCode").getResultList();
//	 
//			for (String countryString : countryCodes) {
//				
//				//System.out.println(countryString);
//			}
//			City city = new City() ; 
//			city=				
//			session.get(City.class, 1);
//			
//			System.out.println(city.getDistrict());
			
			
//	--------------INSERT--------------------
//			City city = new City();
//			
//			city.setName("Test1");
//			
//			city.setCountryCode("TUR");
//			
//			city.setDistrict("Akdeniz");
//			
//			
//			city.setPopulation(215000);
//
//			//multiple record
//		
//			session.save(city);
//			
			
//----------------UPDATE----------------------------
			
//			City city = session.get(City.class, 4088);
//			
//			city.setName("Zalimli");
//			
//			session.save(city);
			
//---------------Delete-------------------------
//			City city = session.get(City.class, 4088); 
//			
//			session.delete(city);
//			
//			
			session.getTransaction().commit();
			
			//System.out.println("Deleted");
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}finally {
			
			session.close();
		}
		
		
	}

}



//Select/*from

//from City c where c.countryCode='TUR' AND c.district='AKdeniz'
//from City c where c.name LIKE '%kar%'
//from City c order by c.name default olarak asc gelir (ascending) tersten sýralamak için descending kullanýlýr

/*			List<City> cities = session.createQuery("from City c order by c.name desc").getResultList();

for (City city : cities) {
	
	System.out.println(city.getName());
}
*/	
