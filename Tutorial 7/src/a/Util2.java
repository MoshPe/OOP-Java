package a;

public class Util2 {
	public static <E extends HasFriend<E>> boolean areFriends(E first, E seconds) {
		return first.friend().equals(seconds) && seconds.friend().equals(first);  
	}

}
