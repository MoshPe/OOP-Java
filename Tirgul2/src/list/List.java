package list;

public class List {
	private Node head = null;
	private Node Tail = null;
	
	
	public void addAtHead(int val) {
		head = new Node(val,head,null);
	}
	
	public void addAtTail(int val) {
		Tail = new Node(val,null,Tail);
		if(head == null)
			head = Tail;

	}
	public int deleteHead() {
		Node n = head;
		head = head.getNext();
		return n.discard(); 
	}
	
	public int deleteTail() { 
		Node n = Tail;
		Tail = Tail.getPrev();
		return n.discard(); 	
	}
	
	public int deleteAt(int i) { 
		return head.get(i).discard();
	}
	
	
	public String toString() {
		String res = " ";
		for(Node temp = head; temp != null ; temp=temp.getNext())
			res+=temp.getVal() + " ";
		return res;
	}
}
