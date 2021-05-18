package rooms;

public class Room {
    protected int length, width;
    protected int costPerMeter;

    public Room(int length, int width, int costPerMeter) {
	this.length = length;
	this.width = width;
	this.costPerMeter = costPerMeter;
    }

    public int area() {
	return length * width;
    }

    public int cost() {
	return area() * costPerMeter;
    }

    //getClass().getSimpleName() returns the class name
    @Override
    public String toString() {
       return String.format("%s %d X %d, cost = %d", getClass().getSimpleName(),length, width, cost());
    }
}

