package people;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Doctor extends Person {
	
	public enum diagnoseType {FLU, BROKEN_LEG, SMALL_POX, BROKEN_NECK, HEART_PAIN, HEART_ATTACK};

	private String specialization;
	private boolean isBusy;
	
	public Doctor(String name, String telephone, String specialization) {
		super(name, telephone);
		this.specialization = specialization;
	}
	
	public void setBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}
	
	public HashMap<diagnoseType, ArrayList<String>> planForTreatment() {
		ArrayList<diagnoseType> digs = new ArrayList<diagnoseType>();
		digs.add(diagnoseType.BROKEN_LEG);
		digs.add(diagnoseType.BROKEN_NECK);
		digs.add(diagnoseType.FLU);
		digs.add(diagnoseType.HEART_ATTACK);
		digs.add(diagnoseType.HEART_PAIN);
		digs.add(diagnoseType.SMALL_POX);
		int randomDig = new Random().nextInt(digs.size());
		HashMap<diagnoseType, ArrayList<String>> plan = new HashMap<Doctor.diagnoseType, ArrayList<String>>();
		ArrayList<String> drugs = new ArrayList<String>();
		drugs.add("Pills");
		drugs.add("Drugs");
		drugs.add("Pills");
		drugs.add("Drugs");
		plan.put(digs.get(randomDig), drugs);
		return plan;
	}
	
}
