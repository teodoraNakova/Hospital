package medical_ward;

import java.util.ArrayList;

import room.Room;

public abstract class MedicalWard {
	
	private String name;
	private ArrayList<Room> rooms = new ArrayList<Room>();
	
	public MedicalWard(String name) {
		this.name = name;
		Room r;
		for(int i = 0; i < 10; i++) {
			if(i < 5) {
				 r = new Room(true);
			} else {
				 r = new Room(false);
			}		
			rooms.add(r);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	
}
