package a;

public abstract class Creature {
	private String name;
	
	public Creature (String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + ":" + name;
	}

}
