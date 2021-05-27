package cities;

public class City implements Comparable<City> {

	private String name;
	private Country country;
	private int population;

	public City(String name, Country country, int population) {
		this.name = name;
		this.country = country;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}

	public int getPopulation() {
		return population;
	}

	public String toString() {
		return String.format("%s (of %s)", name, country);
	}

	@Override
	public int compareTo(City city) {
		if (country.compareTo(city.getCountry()) == 0)
			return name.compareTo(city.getName());
		return -1;
	}

	public boolean equals(Object city) {
		City temp = (City) city;
		return name.equals(temp.getName()) && country.equals(temp.getCountry());
	}

}
