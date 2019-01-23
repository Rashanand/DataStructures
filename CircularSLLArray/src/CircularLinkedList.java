
public class CircularLinkedList {
	private LinkedList head;

	public CircularLinkedList() {
		super();
	}
	
	public void add(Object obj) {
		LinkedList node = new LinkedList(obj, null);
		
		if(head == null) {
			head = node;
			node.setNext(node);
			
			return;
		}
		
		LinkedList currNode = head;
		do {
			currNode = currNode.getNext();
		}while(currNode.getNext() != head);
		
		node.setNext(head);
		currNode.setNext(node);
	}
	
	public void addFirst(Object obj) {
		LinkedList node = new LinkedList(obj, null);
		
		if(head == null) {
			head = node;
			node.setNext(node);
			
			return;
		}
		
		LinkedList currNode = head;
		do {
			currNode = currNode.getNext();
		}while(currNode.getNext() != head);
		
		node.setNext(head);
		currNode.setNext(node);
		head = node;
	}
	
	public void addToIndex(Object obj, int index) {
		if(head == null) {
			System.out.println("Can'nt perform task - null list.");
			return ;
		}
		if(index < 0) {
			System.out.println("Can'nt perform task - negative index : "+index);
			return ;
		}
		if(index>size()-1) {
			System.out.println("Can'nt perform task - index out of bounds : "+index);
			return ;
		}
		
		if(index == 0) {
			addFirst(obj);
		}	
		else if (index == size()-1) {
			add(obj);
		}	
		else {
			LinkedList newNode = new LinkedList(obj, null);
			
			LinkedList currNode = head;
			for(int i = 1; i < index; i++) {
				currNode = currNode.getNext();
			}
			newNode.setNext(currNode.getNext());
			currNode.setNext(newNode);
		}	
	}
	
	public Object get(int index) {
		Object obj = null;
		
		if(head == null) {
			System.out.println("Can'nt perform task - null list.");
			return null;
		}
		if(index < 0) {
			System.out.println("Can'nt perform task - negative index : "+index);
			return null;
		}
		if(index>size()-1) {
			System.out.println("Can'nt perform task - index out of bounds : "+index);
			return null;
		}
		
		LinkedList currNode = head;
		for(int i = 0; i < index; i++) {
			currNode = currNode.getNext();
		}
		
		obj = currNode.getData();
		
		return obj;
	}
	
	public Object replace(Object existObj, Object newObj) {
		Object oldObj = null;
		
		if(head == null) {
			System.out.println("Can'nt perform task - null list.");
			return null;
		}
		
		LinkedList currNode = head;
		do {
			if(currNode.getData().equals(existObj)) {
				currNode.setData(newObj);
				oldObj = existObj;
			}
			currNode = currNode.getNext();
		} while(currNode != head);
		
		return oldObj;
	}
	
	public boolean deleteFirst() {
		return deleteIndex(0);
	}
	
	public boolean deleteLast() {
		return deleteIndex(size() - 1);
	}
	
	public boolean deleteIndex(int index) {
		boolean isDeleted = false;
		
		return isDeleted;
	}
	
	public boolean delete(Object obj) {
		boolean isDeleted = false;
		
		return isDeleted;
	}
	
	public boolean contains(Object obj) {
		boolean isAvailable = false;
		if(head == null) {
			System.out.println("Can'nt perform task - null list.");
			return false;
		}
		
		LinkedList currNode = head;
		do {
			if(currNode.getData().equals(obj)) {
				isAvailable = true;
			}
			currNode = currNode.getNext();
		} while(currNode != head);
		
		return isAvailable;
	}
	
	public int size() {
		int count = 0;
		
		if(head == null) {
			return count;
		}
		LinkedList currNode = head;
		do {
			count++;
			currNode = currNode.getNext();
		} while(currNode != head);
		
		return count;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		
		if(head != null) {
			LinkedList currNode = head; 
			do {
				if(currNode.getNext() != head)
					buffer.append(currNode.getData()+",");
				else
					buffer.append(currNode.getData());
				
				currNode = currNode.getNext();
			}while(currNode != head);
		}
		buffer.append("]");
		return buffer.toString();
	}
	
}
