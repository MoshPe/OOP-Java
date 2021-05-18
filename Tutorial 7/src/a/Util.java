package a;

import java.util.List;
import java.util.Random;

public class Util {
	private static Random random = new Random();
	
	public static<T> T randomMember(T[] arr) {
		return arr[random.nextInt(arr.length)];	
	}
	
	public static<T> T randomMember(List<T> list) {
		return list.get(random.nextInt(list.size()));
		
	}
}
