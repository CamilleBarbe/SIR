package domain;

import javax.persistence.*;


@Entity
public class Heater extends IntelligentHeater {

	public Heater() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Heater(Home home) {
		super(home);
		// TODO Auto-generated constructor stub
	}
	
	
}
