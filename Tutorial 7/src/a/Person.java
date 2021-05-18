package a;

public class Person extends Creature implements HasFriend<Person> {
	private Person friend;

	public Person(String name, Person friend) {
		super(name);
		this.friend = friend;
	}

	@Override
	public Person friend() {
		return friend;
	}

}
