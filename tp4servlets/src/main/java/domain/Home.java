package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Home {

	private long id;
	private double taille;
	private int nbPieces;
	private Collection<Heater> chauffages;
	private Person proprio;

	public Home() {
	}

	public Home(double taille, int nbPieces, Person proprio) {
		super();
		this.taille = taille;
		this.nbPieces = nbPieces;
		this.proprio = proprio;
		chauffages = new ArrayList<Heater>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	public Person getProprio() {
		return proprio;
	}

	public void setProprio(Person proprio) {
		this.proprio = proprio;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public int getNbPieces() {
		return nbPieces;
	}

	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}

	@OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
	public Collection<Heater> getChauffage() {
		return chauffages;
	}

	public void setChauffage(Collection<Heater> chauffages) {
		this.chauffages = chauffages;
	}

}
