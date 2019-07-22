import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	private Node root = null;

	public BinarySearchTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Add node
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
			else if(data < currentNode.getData()) {
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
	//Level order traversal
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
	public void inOrderTraversal() {
		if(root == null) {
			return ;
		}
		inOrderTraversal(root);
		System.out.println();
	}
	
	private void inOrderTraversal(Node node) {
		if(node == null) {
			return ;
		}
		inOrderTraversal(node.getLeft());
		System.out.print(node.getData()+"  ");
		inOrderTraversal(node.getRight());
	}
	//Search
	public boolean contains(int data) {
		return contains(root, data);
	}
	
	private boolean contains(Node node, int data) {
		if(node == null) {
			return false;
		}
		
		if(node.getData() == data) {
			return true;
		}
		else if(node.getData() > data) {
			return contains(node.getLeft(), data);
		}
		else {
			return contains(node.getRight(), data);
		}
	}
	
	public Node delete(int data) {
		return delete(root, data);
	}
	//Delete
	private Node delete(Node node, int data) {
		if(node == null) {
			return null;
		}
		
		if(data < node.getData()) {
			node.setLeft(delete(node.getLeft(), data));
		}
		else if(data > node.getData()) {
			node.setRight(delete(node.getRight(), data));
		}
		else {
			if(node.getRight() == null) {
				return node.getLeft();
			}
			if(node.getLeft() == null) {
				return node.getRight();
			}
			
			node.setData(minValue(node.getRight()));
			
			node.setRight(delete(node.getRight(), node.getData()));
		}
		
		return node;
	}
	//To get the min value/ inorder successor for delete operation
	private int minValue(Node node) {
		if(node.getLeft() == null) {
			return node.getData();
		}
		return minValue(node.getLeft());
	}
}
