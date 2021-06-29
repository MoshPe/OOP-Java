package Winter2019;

import java.util.Iterator;

public class City extends Node {
	private String name;
	private int id;
	private Road[] roads;

	public City(int id, String name) {
		super(id);
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public static void findNearestCity(City city) {
		Iterator<Road> roadsIterate = city.iterator();
		int min = 0;
		Road temp;
		City nearest = null;
		while (roadsIterate.hasNext()) {
			temp = roadsIterate.next();
			if (temp.getLength() < min) {
				min = temp.getLength();
				nearest = (City) temp.getTo();
			}
		}
		System.out.println(city.toString() + " " + min + " " + nearest.toString());
	}
}
