package hospital;

import people.Doctor;
import people.Pacient;

public class MedicalRecord {

	private String pacientName;
	private int pacientAge;
	private String pacientTel;
	private Doctor doc;
	
	public MedicalRecord(String pacientName, int pacientAge, String pacientTel) {
		this.pacientName = pacientName;
		this.pacientAge = pacientAge;
		this.pacientTel = pacientTel;
	}

}
