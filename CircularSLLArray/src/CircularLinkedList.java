
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
				break;
			}
			currNode = currNode.getNext();
		} while(currNode != head);
		
		return oldObj;
	}
	
	public boolean removeFirst() {
		boolean isRemoved = false;
		
		if(head == null) {
			System.out.println("Can'nt perform task - null list.");
			return false;
		}
		
		if(head.getNext() == head) {
			head = null;
			isRemoved = true;
		}
		else {
			LinkedList currNode = head;
			while(currNode.getNext() != head) {
				currNode = currNode.getNext();
			}
			currNode.setNext(head.getNext());
			head = head.getNext();
			isRemoved = true;
		}
			
		return isRemoved;
	}
	
	public boolean removeLast() {
		boolean isRemoved = false;
		
		if(head == null) {
			System.out.println("Can'nt perform task - null list.");
			return false;
		}
		
		if(head.getNext() == head) {
			head = null;
			isRemoved = true;
		}
		else {
			LinkedList currNode = head;
			while(currNode.getNext().getNext() != head) {
				currNode = currNode.getNext();
			}
			currNode.setNext(head);
		}
		return isRemoved;
	}
	
	public boolean removeIndex(int index) {
		boolean isRemoved = false;
		
		if(head == null) {
			System.out.println("Can'nt perform task - null list.");
			return false;
		}
		
		if(index == 0) {
			isRemoved = removeFirst();
		}
		else if(index == size()-1) {
			isRemoved = removeLast();
		}
		else {
			isRemoved = remove(get(index));
		}
		
		return isRemoved;
	}
	
	public boolean remove(Object obj) {
		boolean isRemoved = false;
		
		if(head == null) {
			System.out.println("Can'nt perform task - null list.");
			return false;
		}
		
		LinkedList currNode = head;
		LinkedList prevNode = null;
		
		do {
			if(currNode.getData().equals(obj)) {
				if(currNode == head) {
					removeFirst();
				}
				else if(currNode.getNext() == head) {
					removeLast();
				}
				else{
					prevNode.setNext(currNode.getNext());
					currNode.setNext(null);
				}
				isRemoved = true;
				break;
			}
				prevNode = currNode;
				currNode = currNode.getNext();
		} while(currNode != head);
		
		return isRemoved;
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
