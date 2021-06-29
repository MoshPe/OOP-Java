package Winter2019;

import java.util.Iterator;

public class TestQ1 {
	public static void main(String[] args) {
		City city1 = new City(1,"Metropolis");
		City city2 = new City(2,"University City");
		City city3 = new City(3,"College City");
		City city4 = new City(4,"The Downtown");
		City city5 = new City(5,"The Capitol");
		City city6 = new City(6,"The Center");
		
		Road road12 = new Road(city1, city2, 10);
		Road road51 = new Road (city5, city1, 13);
		Road road52 = new Road (city5, city2, 11);
		Road road54 = new Road (city5, city4, 14);
		Road road64 = new Road (city6, city4, 8);
		Road road43 = new Road (city4, city3, 12);
		Road road32 = new Road (city3, city2, 17);
		
		city5.connectEdge(road51);
		city5.connectEdge(road52);
		city5.connectEdge(road54);
		city6.connectEdge(road64);
		city3.connectEdge(road43);
		city3.connectEdge(road32);
		city2.connectEdge(road12);
		City.findNearestCity(city5);
		City.findNearestCity(city3);
	}
	


}
