package domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Singleton {
	private static Singleton s = null;
	private static EntityManager manager;
	
	private Singleton(){
		s = this ;
	}
	
	
	
	public static Singleton getS() {
		return s;
	}



	public static void setS(Singleton s) {
		Singleton.s = s;
	}



	public static EntityManager getManager() {
		return manager;
	}



	public static void setManager(EntityManager manager) {
		Singleton.manager = manager;
	}



	public static Singleton getInstance(){
		if(s == null){
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("example");
			
			manager = factory.createEntityManager();
			return new Singleton();
		}
		return s;
	}
}
