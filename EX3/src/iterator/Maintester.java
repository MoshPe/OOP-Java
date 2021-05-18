package iterator;

public class Maintester {

	public static void main(String[] args) {
		MyIterator it = new Fibonacci(20);
		while(it.hasNext())
			System.out.print(it.next() + " ");

		
	}

}
