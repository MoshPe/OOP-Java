package BWinter2019;

public interface Function {
	public int getValue(int x) throws OutOfDomainException;
	public int getDomainStart();
	public int getDomainEnd();
}
