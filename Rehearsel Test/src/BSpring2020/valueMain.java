package BSpring2020;

import java.util.Collection;

public class valueMain {

	
	
	
	
	
	public static <T> T best(Collection<? extends T> cl, Valuer<T> valuer) {
		double temp = 0;
		T returnBest = null;
		boolean flag = true;
		for (T t : cl) {
			if(flag) {  
				temp = valuer.val(t);
				flag = false;
				returnBest = t;
			}
			if(temp < valuer.val(t)) {
				temp = valuer.val(t);
				returnBest = t;	
			}
		}
		return returnBest;
	}
}
