package people;

import medical_ward.MedicalWard;
import hospital.MedicalRecord;
import people.Doctor.diagnoseType;
import room.Room;

public class Pacient extends Person {

	private int age;
	private boolean isMale;
	private Doctor myDoctor;
	private diagnoseType diagnose;
	private MedicalRecord myMd;
	private int myRoomIndex;
	private int myBedIndex;
	private String medicalWardName;
	
	public Pacient(String name, String telephone, int age, boolean isMale) {
		super(name, telephone);
		this.age = age;
		this.isMale = isMale;
	}
	
	public int getAge() {
		return age;
	}
	
	public Doctor getMyDoctor() {
		return myDoctor;
	}
	
	public void setMyDoctor(Doctor myDoctor) {
		this.myDoctor = myDoctor;
	}
	
	public void setMyMr(MedicalRecord myMd) {
		this.myMd = myMd;
	}
	
	public boolean getIsMale() {
		return this.isMale;
	}
	
	public void setDiagnose(diagnoseType diagnose) {
		this.diagnose = diagnose;
	}
	
	public diagnoseType getDiagnose() {
		return diagnose;
	}
	
	public void setMyBedIndex(int myBedIndex) {
		this.myBedIndex = myBedIndex;
	}
	
	public int getMyBedIndex() {
		return myBedIndex;
	}
	
	public void setMedicalWardName(String medicalWardName) {
		this.medicalWardName = medicalWardName;
	}
	
	public String getMedicalWardName() {
		return medicalWardName;
	}
	
	public void setMyRoomIndex(int myRoomIndex) {
		this.myRoomIndex = myRoomIndex;
	}
	
	public int getMyRoomIndex() {
		return myRoomIndex;
	}
}
