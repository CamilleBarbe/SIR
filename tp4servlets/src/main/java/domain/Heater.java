package domain;

import javax.persistence.*;


@Entity
public class Heater {
	
	private long id;
	private Home home;
	private String power;
	
	public Heater(long id, Home home, String power) {
		super();
		this.id = id;
		this.home = home;
		this.power = power;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public Heater(){}
	
	public Heater(Home home) {
		super();
		this.home = home;
	}


	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	@ManyToOne
	public Home getHome(){
		return home;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setHome(Home home) {
		this.home = home;
	}
	
	
}
