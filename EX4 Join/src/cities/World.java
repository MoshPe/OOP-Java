package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//This class represent world class which manages the countries

public class World {
	private Map<String, Country> countries = new TreeMap<>();

	public void addCountry(String name) {
		// Check if the country is already in the world
		if (countries.containsKey(name))
			throw new IllegalArgumentException();
		countries.put(name, new Country(name));
	}

	public void addCity(String name, String countryName, int population) {
		// Check if the country isn't already in the world
		if (!countries.containsKey(countryName))
			throw new IllegalArgumentException();
		countries.get(countryName).addCity(new City(name, countries.get(countryName), population));
	}

	// Get the world population
	public int population() {
		int populationCount = 0;
		for (Country country : countries.values())
			populationCount += country.population();
		return populationCount;
	}

	// Get all the cities that has their population count less than given bound
	public List<City> smallCities(int under) {
		List<City> populationUnder = new ArrayList<>();
		for (Country country : countries.values())
			populationUnder.addAll(country.smallCities(under));
		return populationUnder;
	}

	// Get the all world countries and cities with their population
	public String report() {
		StringBuilder worldReport = new StringBuilder();
		for (Country country : countries.values())
			worldReport.append(country.report() + "\n");
		worldReport.append("Total population is " + population() + "\n");
		return worldReport.toString();
	}
}
