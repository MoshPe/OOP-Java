package cities;

/*
 * Position: save the roads that are connected to the city 
 * 			 and the city's name.
 * 	Methods: return the nearest city's preference in compare to the current city
 * 			 adding a new given road to the roads array which are connected to the current city 			 
 */
public class City {
	// Assumption that the city would not have more than 10 connected roads
	private Road[] roads = new Road[10];
	private int numOfRoads;
	private String cityName;

	public City(String name) {
		this.cityName = name;
		numOfRoads = 0;
	}

	public void connect(Road roadToConnect) {
		roads[numOfRoads] = roadToConnect;
		numOfRoads++;
	}

	/*
	 * Algorithm: First, checking if there are any roads connected to the city and initialize
	 * 			  the variable minDistanceFromCity to the first road length. Going through all
	 * 			  the roads and searching for the minimum road length to a different city
	 */
	public City nearestCity() {
		int minDistanceFromCity = (roads[0] == null) ? null : roads[0].getLength();
		City nearestCity = null;
		for (Road road : roads) {
			if (road != null && road.getLength() <= minDistanceFromCity) {
				// Making sure we're getting the city we're connected to and not the current
				// city
				nearestCity = (road.getCity1().toString() == cityName) ? road.getCity2() : road.getCity1();
				minDistanceFromCity = road.getLength();
			}
		}
		return nearestCity;
	}

	public String toString() {
		return cityName;
	}
}