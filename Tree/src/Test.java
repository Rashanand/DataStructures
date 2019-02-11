public class Test {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		
		root.getLeft().getRight().setLeft(new TreeNode(7));
		root.getLeft().getRight().setRight(new TreeNode(6));
		//TraverseTree.inOrder(root);
		//TraverseTree.preOrder(root);
		//TraverseTree.postOrder(root);
		//TraverseTree.levelOrder(root);
		//System.out.println(TraverseTree.getMax(root));
	
		System.out.println(TraverseTree.getMax(root));
		
		
	}
}
