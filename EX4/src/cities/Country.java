package cities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

	public int population() {
		int populationCount = 0;
		for (City city : cities)
			populationCount += city.getPopulation();
		return populationCount;
	}

	public List<City> smallCities(int under) {
		List<City> populationUnder = new ArrayList<>();
		for (City city : cities) {
			if (city.getPopulation() < under)
				populationUnder.add(city);
		}
		Collections.sort(populationUnder);
		return populationUnder;
	}

	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Country country) {
		return name.compareTo(country.toString());
	}

	public boolean equals(Object country) {
		return name.equals(country.toString());
	}

	public String report() {
		StringBuilder returnReport = new StringBuilder();
		returnReport.append(name + "(");
		returnReport.append(population() + ") : ");

		for (City city : cities) {
			returnReport.append(city.getName() + "(");
			returnReport.append(city.getPopulation() + "), ");
		}
		returnReport.delete(returnReport.length() - 2, returnReport.length());
		return returnReport.toString();
	}
}
