
public class BSTtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		
		System.out.println("Construction : ");
		
		bst.add(5);
		bst.add(13);
		bst.add(3);
		bst.add(4);
		bst.add(9);
		bst.add(12);
		bst.add(15);
		bst.add(2);
		bst.add(8);
		bst.add(14);
		bst.add(1);
		bst.add(18);
		/*
			        5  
				3      13  
			  2   4  9    15  
			1       8 12 14 18 
		*/
		//System.out.println("\nTraversal(Levelwise) : ");
		bst.traverseLevelWise();
		
		System.out.println("\nTraversal(In order) : ");
		bst.inOrderTraversal();
		
		System.out.println("\nSearch :");
		System.out.println(bst.contains(10));
		
		System.out.println("\nDelete (4 - leaf node) :");	
		bst.delete(4);
		System.out.println("Traversal(In order) : ");
		bst.inOrderTraversal();
		bst.traverseLevelWise();
		
		System.out.println("\nDelete (2 - single child) :");	
		bst.delete(2);
		System.out.println("Traversal(In order) : ");
		bst.inOrderTraversal();
		bst.traverseLevelWise();
		
		System.out.println("\nDelete (13 - two child) :");	
		bst.delete(13);
		System.out.println("Traversal(In order) : ");
		bst.inOrderTraversal();
		bst.traverseLevelWise();
		
	}

}
