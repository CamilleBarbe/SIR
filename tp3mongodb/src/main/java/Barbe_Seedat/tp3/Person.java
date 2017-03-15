package Barbe_Seedat.tp3;

import java.util.*;

import org.mongodb.morphia.annotations.*;


@Entity("persons")
public class Person {
	@Id
	private ObjectId id;
	private String name;
	@Reference
	private Collection<Address> add;
	
	
	
	public Person(String name, Collection<Address> add) {
		super();
		this.name = name;
		this.add = add;
	}

	public ObjectId getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Address> getAdd() {
		return add;
	}
	public void setAdd(Collection<Address> add) {
		this.add = add;
	}
	
	
	
}
