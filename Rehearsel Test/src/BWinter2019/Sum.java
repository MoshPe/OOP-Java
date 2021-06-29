package BWinter2019;

import java.util.Iterator;

public class Sum extends FunctionDecorator {

	public Sum(Function f) {
		super(f);
	}

	@Override
	public int getValue(int x) throws OutOfDomainException {
		f.getValue(x);
		int sum = 0;
		Iterator<int[]> a = iterator();
		while(a.hasNext()) {
			int[] temp = a.next();
			if(temp[0] == x) {
				sum += temp[1];
				break;
			}
			sum+=temp[1];
		}
		return sum;
	}
	public static void main(String[] args) throws OutOfDomainException {
		Function f = new Sum(new DoubleFunction());
		System.out.println(f.getValue(-2));
	}
}
