import java.util.LinkedList;
import java.util.Queue;

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
	
	public int delete() {
		return 0;
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
}
