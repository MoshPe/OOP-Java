package root;
			// Class that represent the accuracy of a root calculation
public class Rooter {
	private double precision;

			// Constructor that set precision that he received
	public Rooter(double precision) {this.precision=precision;}
	
			// Set precision into the argument
	public void setPrecision(double precision) {
		this.precision = precision;
	}
			// Calculate the square root of x precisely as the value of the precision in argument
	public double sqrt(double x){
		double one = x/2.0;
		double two;
		while(true) {
			two = x/one;
			if(one == two)
				return one;
			if(two>one) {
				if((two-one) < precision)
					return two;
			}
			else if((one-two) < precision)
					return one;
			one = (two+one)/2.0;
		}
	}
}
