package BWinter2019;

public class mainTest {
	public static void main(String[] args) {
		FunctionDecorator f = new Sum(new DoubleFunction());
		System.out.println(f.toString());
	}
}
