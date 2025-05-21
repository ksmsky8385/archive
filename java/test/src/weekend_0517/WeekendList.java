package weekend_0517;

public class WeekendList {
	private Node nodes;
	
	public void insert(int num) {
		if(nodes == null) {
		nodes = new Node(num);
		return;
		}
		Node other = nodes;
		while(other.next != null) {
			other = other.next;
			
		}
		other.next = new Node(num);
	}
	
	public int getNum() {
		return nodes.num;
	}
	
	public void print() {
		if(nodes == null)
			return;
		
		Node other = nodes;
		while(other != null) {
			System.out.print(other.num + " ");
			other = other.next;
		}
	}
	
	public void delete(int num) {
		if(nodes == null)
			return;

		Node other = nodes;
		Node prev = null;
		Node next = nodes.next;
		
		while(other != null) {
			if(other.num == num) {
				if(prev == null) {
					nodes = next;
				}
				else {
				prev.next = next;
				}
			}
			
			prev = other;
			other = other.next;
			
			if(other != null) {
			next = other.next;
			}
				
		}
	}
	
}
