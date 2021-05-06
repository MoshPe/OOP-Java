package StringSet;

import java.util.Scanner;

public class mainString {
	public static void main(String[] argc) {
		StringSet set = new StringSet(5);
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter stuff: ");
		try {
			while (true) {
				String str = sc.next();
				if (str.equals("Done"))
					break;
				else
					set.add(str);
			}
			sc.close();
		} catch (StringSetFullException e) {
			System.out.println("StringSet full.");
		} catch (NullPointerException e) {
			System.out.println("null were inputed");
		}
		System.out.println("finished!");
	}
}
