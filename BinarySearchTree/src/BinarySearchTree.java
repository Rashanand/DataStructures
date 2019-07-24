import java.util.ArrayList;
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
	public void traverseLevelWise(Node root1) {
		if(root1 == null) {
			System.out.println("Empty tree");
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root1);
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
	
	public ArrayList<Node> getBSTPreOrder() {
		if(root == null) {
			return null;
		}
		ArrayList<Node> pre = new ArrayList<Node>();
		
		getBSTPreOrder(pre, root);
		
		if(pre.size() > 0) {
			for(int i = 0; i < pre.size(); i++) {
				System.out.print(pre.get(i).getData()+"  ");
			}
		}
		System.out.println();
		
		return pre;
	}
	
	//Pre-order traversal; Construct BST from its Pre-Order
	private void getBSTPreOrder(ArrayList<Node> pre, Node node) {
		if(node == null) {
			return ;
		}
		pre.add(node);
		getBSTPreOrder(pre, node.getLeft());
		getBSTPreOrder(pre, node.getRight());
	}
	
	public Node constructBSTfromPreOrder(ArrayList<Node> preOrder) {
		Node preRoot = null;
		
		int treeSize = preOrder.size();
		if(preOrder != null && treeSize > 0) {
			preRoot = preOrder.get(0);
			
			ArrayList<Node> leftTree = null;
			ArrayList<Node> rightTree = null;
			
			for(int i = 1; i < treeSize; i++) {
				if(preOrder.get(i).getData() > preRoot.getData()) {
					leftTree = new ArrayList<Node>(i);
					for(int j = 1; j < i; j++) {
						leftTree.add(preOrder.get(j));
					}
					rightTree = new ArrayList<Node>((treeSize - i) + 1);
					for(int k = i; k < treeSize; k++) {
						rightTree.add(preOrder.get(k));
					}
					System.out.println(leftTree + "\n" + rightTree);
					break;
				}
			}
		}
		
		return preRoot;
	}
	//Construct BST from its preorder
	//Expensive method O(n^2)
	public Node constructfromPreOrderApp1(ArrayList<Node> pre) {
		if(pre == null || pre.size() < 1) {
			return null;
		}
		
		Node preRoot = constructfromPreOrder(pre, pre.get(0));
		traverseLevelWise(preRoot);
		inOrderTraversal(preRoot);
		return preRoot;
	}
	private Node constructfromPreOrder(ArrayList<Node> preOrder, Node preRoot) {
		ArrayList<Node> leftTree = null;
		ArrayList<Node> rightTree = null;
		
		int treeSize = preOrder.size();
		for(int i = 1; i < treeSize; i++) {
			if(preOrder.get(i).getData() > preRoot.getData()) {
				leftTree = new ArrayList<Node>(i);
				for(int j = 1; j < i; j++) {
					leftTree.add(preOrder.get(j));
				}
				rightTree = new ArrayList<Node>((treeSize - i) + 1);
				for(int k = i; k < treeSize; k++) {
					rightTree.add(preOrder.get(k));
				}
				System.out.println(leftTree + "\n" + rightTree);
				break;
			}
			
		}
		
		if(treeSize > 0) {
			//All the nodes less than root
			if(leftTree == null && rightTree == null) {
				int rootData = preOrder.get(0).getData();
				if(rootData > preRoot.getData()) {
					rightTree = preOrder;
				}
				else if(rootData < preRoot.getData()){
					leftTree = preOrder;
				}
			}
			if(leftTree != null) {
				Node node = leftTree.remove(0);
				preRoot.setLeft(constructfromPreOrder(leftTree, node));
			}
			if(rightTree != null) {
				Node node = rightTree.remove(0);
				preRoot.setRight(constructfromPreOrder(rightTree, node));
			}
		}
		return preRoot;
	}
	//Construct BST from its preorder
	//2nd approach
	public Node constructfromPreOrderApp2(ArrayList<Node> preOrder) {
		return null;
	}
}
