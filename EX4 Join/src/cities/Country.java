package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//this class represent Country with cities that is comparable to other countries

public class Country implements Comparable<Country> {
	private Set<City> cities = new TreeSet<>();
	private String name;

	public Country(String name) {
		this.name = name;
	}

	public void addCity(City city) {
		if (!city.getCountry().equals(this))
			throw new IllegalArgumentException();
		cities.add(city);
	}

	// return the population of the country
	public int population() {
		int populationCount = 0;
		for (City city : cities)
			populationCount += city.getPopulation();
		return populationCount;
	}

	// get list with the cities with population under the given integer
	public List<City> smallCities(int under) {
		List<City> populationUnder = new ArrayList<>();
		for (City city : cities) {
			if (city.getPopulation() < under)
				populationUnder.add(city);
		}
		return populationUnder;
	}

	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Country country) {
		return name.compareTo(country.toString());
	}

	@Override
	public boolean equals(Object country) {
		return name.equals(country.toString());
	}

	// return the string of the country with the population and each city with it's
	// population
	public String report() {
		StringBuilder returnReport = new StringBuilder();
		returnReport.append(name + "(");
		returnReport.append(population() + ") : ");

		// cities are TreeSet - in order for loop
		for (City city : cities) {
			returnReport.append(city.getName() + "(");
			returnReport.append(city.getPopulation() + "), ");
		}
		//Deleting the last 2 chars what contains ',' and ' '
		returnReport.delete(returnReport.length() - 2, returnReport.length());
		return returnReport.toString();
	}
}
