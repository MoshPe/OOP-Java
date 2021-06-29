package CSpring2020;

import java.util.HashSet;
import java.util.Set;

public class Employee {
	private final long id;
	protected String name;
	
	public Employee(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee other = (Employee) obj;
		return id == other.id;
	}
	
	@Override
	public int hashCode() {
		return Long.hashCode(id);
	}
	
	public static void main(String[] args) {
		Set<Employee> set = new HashSet<>();
		set.add(new Employee(22, "Anakin Skywalker"));
		set.add(new Employee(11,"Obi-Wan Kenobi"));
		System.out.println(set.contains(new Employee(22, "Darth Vader")));
		System.out.println(set.contains(new Employee(33, "Obi-Wan Kenobi")));
	}
}
