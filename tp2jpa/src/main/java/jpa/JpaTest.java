package jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.*;


public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try{
			test.createPersons();
			test.createHomes();
			test.createElectronicDevices();
			test.createHeaters();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		tx.commit();

			test.listPersons();
			test.listHomes();
			test.listElectronicDevices();
			test.listHeaters();
		
		manager.close();
		
		System.out.println("done");
	}
	
	private void createPersons(){
		int numOfPersons = manager.createQuery("Select a From Person a", Person.class).getResultList().size();	
		System.out.println(numOfPersons);
		if(numOfPersons == 0){
			manager.persist(new Person("Tho", "Jeremy", 21, "j.tho@mail.com"));
			manager.persist(new Person("Cohonner", "Jules", 22, "j.cohonner@mail.com"));
			manager.persist(new Person("Barb�", "Jeanne", 19, "j.barbe@mail.com"));
		}
	}
	
	private void createHeaters(){
		int numOfHeaters = manager.createQuery("Select a From Heater a", Heater.class).getResultList().size();
		if(numOfHeaters == 0){
			manager.persist(new ArrayList<Home>());	
		}
	}
	
	private void createElectronicDevices(){
		int numOfElectronicDevices = manager.createQuery("Select a From ElectroniDevice a", ElectronicDevice.class).getResultList().size();
		if(numOfElectronicDevices == 0){
			Person marieElisabeth = new Person();
			
			manager.persist(new ElectronicDevice("Proprio1", 6.3, marieElisabeth));
		}
	}

	private void createHomes(){
		int numOfHomes = manager.createQuery("Select a From ElectroniDevice a", ElectronicDevice.class).getResultList().size();
		if(numOfHomes == 0){
			Person safiah = new Person();
			Collection<Heater> collect = new ArrayList<Heater>();
			
			manager.persist(new Home(15.5, 4, safiah));
		}
		
	}
	
	private void listPersons(){
		List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
		System.out.println("num of Persons : " + resultList.size());
		for (Person next : resultList){
			System.out.println("next person : " + next);
		}
	}
	
	private void listHeaters(){
		List<Heater> resultList = manager.createQuery("Select a From Heater a", Heater.class).getResultList();
		System.out.println("num of Heaters : " + resultList.size());
		for (Heater next : resultList){
			System.out.println("next heater : " + next);
		}
	}
	
	private void listElectronicDevices(){
		List<ElectronicDevice> resultList = manager.createQuery("Select a From ElectronicDevice a", ElectronicDevice.class).getResultList();
		System.out.println("num of ElectronicDevice : " + resultList.size());
		for (ElectronicDevice next : resultList){
			System.out.println("next electronicDevice : " + next);
		}
	}
	
	private void listHomes(){
		List<Home> resultList = manager.createQuery("Select a From Home a", Home.class).getResultList();
		System.out.println("num of Homes : " + resultList.size());
		for (Home next : resultList){
			System.out.println("next home : " + next);
		}
	}
	
}
	
	
	
	

	
	
	

	



