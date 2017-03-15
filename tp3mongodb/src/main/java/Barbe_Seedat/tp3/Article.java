package Barbe_Seedat.tp3;

import java.util.*;

import org.mongodb.morphia.annotations.*;

@Entity("adresses")
public class Article {
	
	private Object id;
	private String name;
	private int stars;
	@Reference
	private Collection<Person> buyers;
	
	
	public Article(String name, int stars, Collection<Person> buyers) {
		super();
		this.name = name;
		this.stars = stars;
		this.buyers = buyers;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	
}
