
public class BSTtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		
		System.out.println("Construction : ");
		
		bst.add(5);
		bst.add(10);
		bst.add(3);
		bst.add(4);
		bst.add(9);
		bst.add(11);
		
		System.out.println("\nTraversal(Levelwise) : ");
		bst.traverseLevelWise();
		
		System.out.println("\nSearch :");
		System.out.println(bst.contains(10));
		
	}

}
