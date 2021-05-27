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
	
	public static void main(String[] args) {
		System.out.println(Type.ACOUSTIC);
	}
}
