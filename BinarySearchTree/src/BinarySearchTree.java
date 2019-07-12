import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	private Node root = null;

	public BinarySearchTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean add(int data) {
		boolean isAdded = false;
		
		if(this.root == null) {
			root = new Node(data);
			return true; 
		}
		
		Node newNode = new Node(data);
		
		Node currentNode = root;
		while(true) {
			if(data > currentNode.getData()) {
				if(currentNode.getRight() != null) {
					currentNode = currentNode.getRight();
				}
				else {
					currentNode.setRight(newNode);
					isAdded = true;
					break;
				}
			}
			if(data < currentNode.getData()) {
				if(currentNode.getLeft() != null) {
					currentNode = currentNode.getLeft();
				}
				else {
					currentNode.setLeft(newNode);
					isAdded = true;
					break;
				}
			}
			else {
				//If node is duplicate;
				break;
			}
		}
		
		return isAdded;
	}
	
	public void traverseLevelWise() {
		if(root == null) {
			System.out.println("Empty tree");
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		queue.add(null); // One level complete;
		
		while(!queue.isEmpty()) {
			Node currNode = queue.poll();
			
			if(currNode == null) {
				System.out.println();
				if(!queue.isEmpty()) {
					queue.add(null);
				}	
			}
			else {
				System.out.print(currNode.getData() + "  ");
				
				if(currNode.getLeft() != null) {
					queue.add(currNode.getLeft());
				}
				if(currNode.getRight() != null) {
					queue.add(currNode.getRight());
				}
			}
		}
	}
}
