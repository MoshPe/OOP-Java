package list;

public class MainForNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Node n1 = new Node(1, null, null);
//		Node n2 = new Node(2, null, n1);
////		System.out.println(n1);
////		System.out.println(n2);
//////		System.out.println(n1.getNext());
//////		System.out.println(n2.getPrev());
//		System.out.println(n1.get(0));
		List l = new List();
//		l.addAtHead(1);
//		l.addAtHead(2);
//		l.addAtHead(3);
//		l.addAtHead(4);
//		l.addAtHead(5);
		
		
		l.addAtTail(1);
		l.addAtTail(2);
		l.addAtTail(3);
		l.addAtTail(4);
		l.addAtTail(5);
		
		System.out.println(l);
		l.deleteHead();
		System.out.println(l);
	}
}
