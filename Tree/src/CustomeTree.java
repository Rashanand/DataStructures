import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CustomeTree {
	private TreeNode root;
	
	public boolean add(int data) {
		TreeNode node = null;
		boolean isAdded = false;
		
		node = new TreeNode(data);
		
		if(root == null) {
			root = node;
			return true;
		}	
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			
			if(currNode.getLeft() != null)
				queue.add(currNode.getLeft());
			else {
				currNode.setLeft(node);
				isAdded = true;
				break;
			}
			if(currNode.getRight() != null)
				queue.add(currNode.getRight());
			else {
				if(!isAdded) {
					currNode.setRight(node);
					isAdded = true;
					break;
				}
			}
		}
		
		return isAdded;
	} 
	
	public void inOrder() {
		inOrder(root);
		System.out.println();
	}
	
	private void inOrder(TreeNode root) {
		
		if(root == null)
			return;
		
		inOrder(root.getLeft());
		System.out.print(root.getData()+" - ");
		inOrder(root.getRight());
	}
	
	public void preOrder() {
		preOrder(root);
		System.out.println();
	}
	
	private void preOrder(TreeNode root) {
		if(root == null)
			return;
		
		System.out.print(root.getData()+" - ");
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}
	
	public void postOrder() {
		postOrder(root);
		System.out.println();
	}
	
	private void postOrder(TreeNode root) {
		if(root == null)
			return;
		
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getData()+" - ");
	}
	
	public void levelOrder() {
		if(root == null) 
			return;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			System.out.print(currNode.getData()+" - ");
			
			if(currNode.getLeft() != null) 
				queue.add(currNode.getLeft());
			
			if(currNode.getRight() != null)
				queue.add(currNode.getRight());
		}
		System.out.println();
	}
	
	public boolean delete(int data) {
		boolean isDeleted = false;
		
		if(root == null)
			return false;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		TreeNode dataNode = null;
		TreeNode lastNode = null;
		TreeNode parent = null;
		
		while(!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			
			if(currNode.getData() == data)
				dataNode = currNode;
			
			lastNode = currNode;
			if(currNode.getLeft() != null) {
				queue.add(currNode.getLeft());
				parent = currNode;
			}	
			if(currNode.getRight() != null) {
				queue.add(currNode.getRight());
				parent = currNode;
			}	
		}
		
		if(dataNode != null && lastNode != null) {
			dataNode.setData(lastNode.getData());
			
			if(parent.getRight().getData() == lastNode.getData())
				parent.setRight(null);
			else if(parent.getLeft().getData() == lastNode.getData())
				parent.setLeft(null);
			
			isDeleted = true;
		}
		
		return isDeleted;
	}
	
	
	public int getMax() {
		return getMax(root);
	}
	
	private int getMax(TreeNode root) {
		int left, right, max;
		
		if(root == null) {
			System.out.println("Tree not initialized");
			return -1;
		}	
		
		left = getMax(root.getLeft());
		right = getMax(root.getRight());
		
		System.out.println("Left   root   right:"+left+"   "+root.getData()+"   "+right);
		
		if(left > right)
			max = left;
		else
			max = right;
		
		if(max > root.getData())
			return max;
		else
			return root.getData();
	}
	
	public int getMin() {
		return getMin(root);
	}
	
	private int getMin(TreeNode root) {
		int left, right, min;
		
		if(root == null) {
			System.out.println("Tree not initialized");
			return -1;
		}	
		
		left = getMin(root.getLeft());
		right = getMin(root.getRight());
		
		System.out.println("Left   root   right:"+left+"   "+root.getData()+"   "+right);
		
		if(left < right)
			min = left;
		else
			min = right;
		
		if(root.getData() < min)
			return root.getData();
		else
			return min;
		
	}
	
	public int getMaxNoRec() {
		int max = Integer.MIN_VALUE;
		
		if(root == null) {
			System.out.println("Tree not initialized");
			return -1;
		}	
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while(!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			
			if(currNode.getData() > max)
				max = currNode.getData();
			
			if(currNode.getLeft() != null)
				queue.add(currNode.getLeft());
			if(currNode.getRight() != null)
				queue.add(currNode.getRight());
		}
		return max;
	}
	
	public int getMinNoRec() {
		int min = Integer.MAX_VALUE;
		
		if(root == null) {
			System.out.println("Tree not initialized");
			return -1;
		}	
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			
			if(currNode.getData() < min)
				min = currNode.getData();
			
			if(currNode.getLeft() != null)
				queue.add(currNode.getLeft());
			if(currNode.getRight() != null)
				queue.add(currNode.getRight());
		}
		
		return min;
	}
	
	public void levelOrderReverse() {
		if(root == null) {
			System.out.println("Tree not initialized");
			return ;
		}
		
		//Get from queue add to stack.
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			stack.push(currNode);
			
			if(currNode.getRight() != null)
				queue.add(currNode.getRight());
			if(currNode.getLeft() != null)
				queue.add(currNode.getLeft());
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().getData()+" ");
		}
	}
	//Do in recursion without queue & stack
	public void allLeaves() {
		if(root == null) {
			System.out.println("Tree not initialized");
			return ;
		}
		
		ArrayList<TreeNode> leaves = new ArrayList<TreeNode>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			
			boolean noLeft = false; 
			
			if(currNode.getLeft() != null) {
				queue.add(currNode.getLeft());
			}	
			else {
				noLeft = true;
			}
			
			if(currNode.getRight() != null) {
				queue.add(currNode.getRight());
			}
			else {
				if(noLeft)
					leaves.add(currNode);
			}
		}
		for (TreeNode treeNode : leaves) {
			System.out.print(treeNode.getData()+" ");
		}
		System.out.println();
	}
	//Do in recursion without queue & stack
	public void allFullNodes() {
		if(root == null) {
			System.out.println("Tree not initialized");
			return ;
		}
		
		ArrayList<TreeNode> allFullNodes = new ArrayList<TreeNode>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			
			boolean left = false;
			
			if(currNode.getLeft() != null) {
				queue.add(currNode.getLeft());
				left = true;
			}
			
			if(currNode.getRight() != null) {
				queue.add(currNode.getRight());
				if(left) {
					allFullNodes.add(currNode);
				}
			}
		}
		for (TreeNode treeNode : allFullNodes) {
			System.out.print(treeNode.getData()+" ");
		}
		System.out.println();
	}
	//Do in recursion without queue & stack
	public void deepestNode() {
		if(root == null) {
			System.out.println("Tree not initialized");
			return ;
		}
		
		TreeNode deepNode = null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			deepNode = queue.poll();
			if(deepNode.getLeft() != null)
				queue.add(deepNode.getLeft());
			if(deepNode.getRight() != null)
				queue.add(deepNode.getRight());
		}
		System.out.println(deepNode.getData());
	}
	
	public void printLevelWise() {
		if(root == null) {
			System.out.println("Tree not initialized");
			return ;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null); //One level complete.
		
		int count = 0; // Counting the no of nodes on a level 
		while(!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			
			if(currNode == null) { //level complete.
				System.out.println();
				count++;
				if(!queue.isEmpty())
					queue.add(null);
			}
			else {
				System.out.print(currNode.getData()+" ");
				if(currNode.getLeft() != null) {
					queue.add(currNode.getLeft());
				}	
				if(currNode.getRight() != null) {
					queue.add(currNode.getRight());
				}	
			}
		}
		
		System.out.println("Height : "+count);
		
	}
	
}
