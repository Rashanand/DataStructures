
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
}
