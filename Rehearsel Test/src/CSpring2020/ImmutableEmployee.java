package CSpring2020;

public class ImmutableEmployee extends Employee{
	
	public ImmutableEmployee(long id, String name) {
		super(id, name);
	}
	
	@Override
	public void setName(String name) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean equals(Object obj) {
		ImmutableEmployee other = (ImmutableEmployee) obj;
		if(name.equals(other.name))
			return super.equals(obj);
		return false;
	}
	

}
