package hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;

import people.Doctor;
import people.Nurse;
import people.Pacient;
import people.Doctor.diagnoseType;
import room.Bed;
import room.Room;
import medical_ward.Cardio;
import medical_ward.MedicalWard;
import medical_ward.Ortho;
import medical_ward.Virology;

public class Hospital {

	private HashMap<String, MedicalWard> medicalWards = new HashMap<String, MedicalWard>();
	private ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
	private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	private ArrayList<Nurse> nurses = new ArrayList<Nurse>();
	
	public Hospital(ArrayList<Doctor> docs, ArrayList<Nurse> nurs) {
		assignMedicalWards();
		this.doctors = docs;
		this.nurses = nurs;
		assignNurses();
	}
	
	private void assignMedicalWards() {
		Cardio cardio = new Cardio("cardio");
		Ortho ortho = new Ortho("ortho");
		Virology viro = new Virology("viro");
		medicalWards.put("cardio", cardio);
		medicalWards.put("ortho", ortho);
		medicalWards.put("viro", viro);
	}
	
	private void assignNurses() {
		for(int i = 0; i < nurses.size(); i++) {
			int random = new Random().nextInt(3);
			String key = "";
			if(random == 0) {
				key = "cardio";
			}
			if(random == 1) {
				key = "ortho";
			}
			if(random == 2) {
				key = "viro";
			}
			nurses.get(i).setMyMw(medicalWards.get(key)); 
		}
	}
	
	public void takeInPacient(Pacient p) {
		MedicalRecord md = new MedicalRecord(p.getName(), p.getAge(), p.getTelephone());
		p.setMyMr(md);
		this.medicalRecords.add(md);
		Doctor doc = doctors.get(new Random().nextInt(doctors.size()));
		p.setMyDoctor(doc);
		doc.setBusy(true);
		startTreatment(p, doc);
	}
	
	public void startTreatment(Pacient p, Doctor d) {
		HashMap<diagnoseType, ArrayList<String>> plan = d.planForTreatment();
		for(Entry<diagnoseType, ArrayList<String>> e : plan.entrySet()) {
			p.setDiagnose(e.getKey());
		}
		printInfoForPacient(p);
		String medicalWard = "";
		if(plan.containsKey(diagnoseType.BROKEN_LEG) || plan.containsKey(diagnoseType.BROKEN_NECK)){
			medicalWard = "ortho";
		}
		if(plan.containsKey(diagnoseType.HEART_ATTACK) || plan.containsKey(diagnoseType.HEART_PAIN)) {
			medicalWard = "cardio";
		}
		if(plan.containsKey(diagnoseType.SMALL_POX) || plan.containsKey(diagnoseType.FLU)) {
			medicalWard = "viro";
		}
		for(int i = 0; i < nurses.size(); i++) {
			if(nurses.get(i).getMyMw().getName().equals(medicalWard)) {
				nurses.get(i).takePacient(plan);
				break;
			}
		}
		ArrayList<Room> rooms = medicalWards.get(medicalWard).getRooms();
		boolean putInBed = false;
		for(int i = 0; i < rooms.size(); i++) {
			ArrayList<Bed> beds = rooms.get(i).getBeds();
		    if(rooms.get(i).getIsRoomForMen() == true && p.getIsMale() == true || rooms.get(i).getIsRoomForMen() == false && p.getIsMale() == false) {
		    	for(int j = 0; j < beds.size(); j++) {
					if(beds.get(j).getIsEmpty()) {
						beds.get(j).setEmpty(false);
						p.setMedicalWardName(medicalWard);
						p.setMyRoomIndex(i);
						p.setMyBedIndex(j);
						putInBed = true;
						break;
					}
				}
		    }	
		    if (putInBed == true) {
	    		break;
	    	}
		}	
	}
	
	private void printInfoForPacient(Pacient p) {
		System.out.println("Pacient " + p.getName() + " from gender " + (p.getIsMale() ? "male" : "female") + " is in the hospital with diagnose " + p.getDiagnose() + ". "
				+ "Doctor: " + p.getMyDoctor().getName());
	}
	
	public void dischargePacient(Pacient p) {
		p.getMyDoctor().setBusy(false);
		medicalWards.get(p.getMedicalWardName()).getRooms().get(p.getMyRoomIndex()).getBeds().get(p.getMyBedIndex()).setEmpty(true);
	}
	
	public void printInfoForMedicalWards (){
		for(Entry<String, MedicalWard> e : medicalWards.entrySet()) {
			System.out.println(e.getKey());
			ArrayList<Room> rooms = e.getValue().getRooms();
			for(int i = 0; i < rooms.size(); i++) {
				ArrayList<Bed> beds = rooms.get(i).getBeds();
				for(int j = 0; j < beds.size(); j++) {
					System.out.print("Is the bed empty? : ");
					System.out.print(beds.get(j).getIsEmpty());
					System.out.println();
				}
			}
		}
	}
}
