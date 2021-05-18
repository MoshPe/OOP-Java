package a;

import java.util.ArrayList;
import java.util.List;

public class Randomer<E> {
	private List<E> genericE = new ArrayList<E>();
	List<E> wasntChosenE= new ArrayList<E>();
	
	public void add(E e) {
		genericE.add(e);
	}
	
	public E randomMember() {
		return Util.randomMember(genericE);
	}
	
	public void dontChoose(E e) {
		List<E> temp = new ArrayList<E>();
		for (E e2 : genericE) {
			if(!e2.equals(e))
				temp.add(e2);
		}
		wasntChosenE = temp;
	}
	
	public E randomMember2() {
		return Util.randomMember(wasntChosenE);
	}
}
