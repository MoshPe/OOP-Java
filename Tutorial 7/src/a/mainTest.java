package a;

import java.util.ArrayList;
import java.util.List;

public class mainTest {
	public static void main(String []argc) {
		String[] strs = { "A","B","C","D","E"};
		System.out.println(Util.randomMember(strs));
		@SuppressWarnings("serial")
		List<Integer> ints = new ArrayList<>() {{ add(1);add(2);add(3);add(4);add(5);}};
		System.out.println(Util.randomMember(ints));
		
	//	Randomer<Integer> r = new Randomer<>() {{add(1);add(2);add(3);add(4);add(5);}};
	}
}
