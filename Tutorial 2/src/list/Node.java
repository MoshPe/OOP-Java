package list;

public class Node {
	private int val;
	private Node next, prev;
	
	public Node(int val, Node next, Node prev) {
		this.val = val;
		this.next = next;
		this.prev = prev;
		if (prev != null)
				prev.next = this;
		if (next != null)
				next.prev = this;
	}
	public Node getPrev() { return prev; }
	
	public Node getNext() { return next; }
	
	public int discard() {
		if(next != null)
			next.prev = prev;
		if(prev != null)
			prev.next= next;
		return val;
	}
	
	public int getVal() { return val; }
	
	public Node get(int i) {
		if(i==0)
			return this;
		else if (this.next == null)
			return null;
		return next.get(--i);	
	}
	
	public String toString() { 
			return (next == null)?String.format("%d",val) : String.format("%d->",val) ; 
	}
}
