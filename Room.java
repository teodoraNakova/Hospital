package room;

import java.util.ArrayList;

public class Room {

	private ArrayList<Bed> beds = new ArrayList<Bed>(); // 3 beds
	private boolean isRoomForMen;
	//only patients of same gender
	
	public Room(boolean isRoomForMen) {
		for(int i = 0; i < 3; i++) {
			Bed bed = new Bed();
			beds.add(bed);
		}
		this.isRoomForMen = isRoomForMen;
	}
	
	public ArrayList<Bed> getBeds() {
		return beds;
	}
	
	public boolean getIsRoomForMen() {
		return this.isRoomForMen;
	}
	
}
