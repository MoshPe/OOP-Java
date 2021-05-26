package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class World {
	private Map<String, Country> countries = new TreeMap<>();

	public void addCountry(String name) {
		if (countries.containsKey(name))
			throw new IllegalArgumentException();
		countries.put(name, new Country(name));
	}

	public void addCity(String name, String countryName, int population) {
		if (!countries.containsKey(countryName))
			throw new IllegalArgumentException();
		countries.get(countryName).addCity(new City(name, countries.get(countryName), population));
	}

	public int population() {
		int populationCount = 0;
		for (Country country : countries.values())
			populationCount += country.population();
		return populationCount;
	}

	public List<City> smallCities(int under) {
		List<Country> sortCountries = new ArrayList<>();
		for (Country country : countries.values())
			sortCountries.add(country);
		List<City> populationUnder = new ArrayList<>();
		for (Country country : sortCountries)
			populationUnder.addAll(country.smallCities(under));
		return populationUnder;
	}

	public String report() {
		StringBuilder worldReport = new StringBuilder();
		for (Country country : countries.values())
			worldReport.append(country.report() + "\n");
		worldReport.append("Total population is " + population() + "\n");
		return worldReport.toString();
	}

//	public static void main(String[] args) {
//		World w = new World();
//		w.addCountry("Spain");
//		w.addCity("Granada", "Spain", 233764);
//		w.addCountry("Brazil");
//		w.addCity("Salvador", "Brazil", 2677000);
//		w.addCity("Barcelona", "Spain", 1615000);
//		w.addCity("Rio de Janeiro", "Brazil", 6320000);
//
//		System.out.println(w.report());
//		int bound = 2000000;
//		System.out.println("Cities with population under " + bound + ":");
//		System.out.println(w.smallCities(bound));
//
//	}
}
