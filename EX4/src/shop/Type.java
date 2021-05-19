package shop;

public enum Type {
	ACOUSTIC("Acoustic"), ELECTRIC("Electric"), CLASSICAL("Classical");

	private String value;

	private Type(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
