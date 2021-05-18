package a;

public class Dog extends Creature implements HasFriend<Person>{
	private Person owner;
	
	public Dog(String name, Person owner) {
		super(name);
		this.owner= owner;
	}

	@Override
	public Person friend() {
		return owner;
	}
	

}
