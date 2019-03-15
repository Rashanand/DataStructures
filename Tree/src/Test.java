public class Test {
	//TraverseTree
	/*public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		
		root.getLeft().getRight().setLeft(new TreeNode(-7));
		root.getLeft().getRight().setRight(new TreeNode(-6));
		//TraverseTree.inOrder(root);
		//TraverseTree.preOrder(root);
		//TraverseTree.postOrder(root);
		//TraverseTree.levelOrder(root);
		//System.out.println(TraverseTree.getMax(root));
		//System.out.println(TraverseTree.getMax(root));
		//System.out.println(TraverseTree.getMin(root));
		
		System.out.println(TraverseTree.getMaxNoRec(root));
		System.out.println(TraverseTree.getMinNoRec(root));
	}*/
	
	//CustomeTree
	public static void main(String[] args) {
		CustomeTree tree = new CustomeTree();
		
		//System.out.println(tree.add(10));
		//System.out.println(tree.add(11));
		//System.out.println(tree.add(9));
		
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(5);
		tree.add(6);
		tree.add(7);
		tree.add(8);
		tree.add(9);
		tree.add(10);
		//tree.levelOrder();
		//tree.inOrder();
		//tree.preOrder();
		//tree.postOrder();
		
		//tree.delete(11);
		//tree.levelOrder();
		//tree.levelOrderReverse();
		//tree.allLeaves();
		//tree.allFullNodes();
		//tree.deepestNode();
		//tree.printLevelWise();
		//tree.getDiameter();
		//tree.printPathRootToLeaf();
		//System.out.println("---------------");
		//tree.sumExistInPath(15);
		//tree.sumExistInPath(8);
		//tree.sumExistInPath(16);
		//tree.sumExistInPath(100);
		//tree.sumExistInPath(-10);
		//tree.sumExistInPath(15);
		//tree.printLevelWise();
		//tree.getMirror();
		
		//Test mirror
		//CustomeTree tree2 = tree.getMirror();
		//tree2.add(11);
		
		//System.out.println(tree.checkMirror(tree.getRoot(), tree2.getRoot()));
		
		//Test is foldable
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(8));
		root.setRight(new TreeNode(7));
		root.getLeft().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(9));
		root.getLeft().getLeft().setRight(new TreeNode(5));
		root.getRight().getRight().setLeft(new TreeNode(4));
		
		CustomeTree foldedTree = new CustomeTree(root);
		
		foldedTree.printLevelWise();
		
		System.out.println(foldedTree.isFoldable());
	}
}
