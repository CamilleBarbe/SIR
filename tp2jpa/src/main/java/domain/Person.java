package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Person {

	private long id;
	private String nom, prenom, mail;
	private Collection<Home> homes;
	private Collection<ElectronicDevice> equipements;
	private Collection<Person> amis;
	private int age;

	public Person() {
	}

	public Person(String nom, String prenom, int age, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.mail = mail;
		
		homes = new ArrayList<Home>();
		equipements = new ArrayList<ElectronicDevice>();
		amis = new ArrayList<Person>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@OneToMany(mappedBy = "proprio", cascade = CascadeType.PERSIST)
	public Collection<Home> getHome() {
		return homes;
	}

	public void setHome(Collection<Home> homes) {
		this.homes = homes;
	}

	@OneToMany(mappedBy = "proprio", cascade = CascadeType.PERSIST)
	public Collection<ElectronicDevice> getEquipement() {
		return equipements;
	}

	public void setEquipement(Collection<ElectronicDevice> equipements) {
		this.equipements = equipements;
	}

	@ManyToMany
	public Collection<Person> getAmis() {
		return amis;
	}

	public void setAmis(Collection<Person> amis) {
		this.amis = amis;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + nom + ", age="
				+ age + "]";
	}

}
