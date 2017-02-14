package demo;

import java.util.ArrayList;

import people.Doctor;
import people.Nurse;
import people.Pacient;
import hospital.Hospital;

public class Demo {

	public static void main(String[] args) {
		
		Doctor d1 = new Doctor("Doctor 1", "0887643844", "Orthopedic");
		Doctor d2 = new Doctor("Doctor 2", "0887653844", "Cardio spec");
		Doctor d3 = new Doctor("Doctor 3", "0887663844", "Common");
		ArrayList<Doctor> setOfDoctors = new ArrayList<Doctor>();
		setOfDoctors.add(d1);
		setOfDoctors.add(d2);
		setOfDoctors.add(d3);
		setOfDoctors.add(d1);
		setOfDoctors.add(d2);
		setOfDoctors.add(d3);
		
		Nurse n1 = new Nurse("Nurse 1", "0884235563", 6);
		Nurse n2 = new Nurse("Nurse 2", "0884231563", 5);
		Nurse n3 = new Nurse("Nurse 3", "0884232563", 10);
		ArrayList<Nurse> setOfNurses = new ArrayList<Nurse>();
		setOfNurses.add(n1);
		setOfNurses.add(n2);
		setOfNurses.add(n3);
		setOfNurses.add(n1);
		setOfNurses.add(n2);
		setOfNurses.add(n3);
		Hospital hospital = new Hospital(setOfDoctors, setOfNurses);
		
		Pacient p1 = new Pacient("Ivan Ivanov", "0887663685", 25, true);
		hospital.takeInPacient(p1);
		Pacient p2 = new Pacient("Stefan Duchev", "0887663685", 25, true);
		hospital.takeInPacient(p2);
		Pacient p3 = new Pacient("Divna Ruseva", "0887663685", 45, false);
		hospital.takeInPacient(p3);
		
		hospital.printInfoForMedicalWards();
		
		hospital.dischargePacient(p1);
		hospital.printInfoForMedicalWards();
	}

}
