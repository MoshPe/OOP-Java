package rooms;

import java.lang.StringBuilder;

public class ParentsRoom extends Room {
	Bathroom bathroom;
	
	public ParentsRoom(int width, int length, int costPerMeter
			,int Bheight
			,int Bwidth
			,int Blength
			) {
		super(length,width,costPerMeter);
		this.bathroom = new Bathroom(Blength,Bwidth,Bheight,costPerMeter);
	}
	

	@Override
	public int cost() {
		return super.cost() + bathroom.cost();
	}
	
	@Override
	public String toString() {
		StringBuilder ParentsRoomString = new StringBuilder();
		ParentsRoomString.append(super.toString());
		ParentsRoomString.append('\n');
		ParentsRoomString.append(bathroom.toString());
		return ParentsRoomString.toString();
	}
	
	public static void main(String[] args) {
		ParentsRoom a = new ParentsRoom(2,2,10,1,1,1);
		System.out.println(a);
	}
	
}
