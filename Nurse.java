package people;

import java.util.ArrayList;
import java.util.HashMap;

import people.Doctor.diagnoseType;
import medical_ward.MedicalWard;

public class Nurse extends Person {

	private int experience;
	private MedicalWard myMw;
	
	public Nurse(String name, String telephone, int experience) {
		super(name, telephone);
		this.experience = experience;
	}
	
	public void setMyMw(MedicalWard myMw) {
		this.myMw = myMw;
	}
	
	public MedicalWard getMyMw() {
		return myMw;
	}
	
	public void takePacient(HashMap<diagnoseType, ArrayList<String>> plan) {
		System.out.println("Nurse " + this.getName() + " just took pacient.");
		System.out.println("Diagnose: " + plan.keySet());
		System.out.println("Medicine " + plan.values());
	}
	
}
