import java.util.LinkedList;
import java.util.Queue;

public class TraverseTree {
	
	public static void inOrder(TreeNode root) {
		
		if(root == null)
			return;
		
		inOrder(root.getLeft());
		System.out.println(root.getData());
		inOrder(root.getRight());
	}
	
	public static void preOrder(TreeNode root) {
		if(root == null)
			return;
		
		System.out.println(root.getData());
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}
	
	public static void postOrder(TreeNode root) {
		if(root == null)
			return;
		
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.println(root.getData());
	}
	
	public static void levelOrder(TreeNode root) {
		if(root == null) 
			return;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			System.out.println(currNode.getData());
			
			if(currNode.getLeft() != null) 
				queue.add(currNode.getLeft());
			
			if(currNode.getRight() != null)
				queue.add(currNode.getRight());
		}
	} 
	
	public static int getMax(TreeNode root) {
		int left, right, max;
		
		if(root == null) {
			return 0;
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
}