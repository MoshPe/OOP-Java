package AWinter2020CheatSheet;

import java.util.Arrays;
import java.util.Comparator;

public class Player {
	private String name;
	private int age;

	public Player(String name, int age) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public static void sortByAge(Player[] ps) {
		Arrays.sort(ps, new Comparator<Player>() {
			@Override
			public int compare(Player o1, Player o2) {
				if (o1.getAge() > o2.getAge())
					return 1;
				else if (o1.getAge() == o2.getAge())
					return 0;
				return -1;
			}
		});
	}
}
