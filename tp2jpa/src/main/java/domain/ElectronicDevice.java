package domain;

import javax.persistence.*;

@Entity
public class ElectronicDevice extends IntelligentElectronicDevice {

	public ElectronicDevice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElectronicDevice(String nom, double consoMoy, Person proprio) {
		super(nom, consoMoy, proprio);
		// TODO Auto-generated constructor stub
	}

	
	
}
