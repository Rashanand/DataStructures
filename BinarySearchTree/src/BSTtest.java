
public class BSTtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.add(5);
		bst.add(10);
		bst.add(3);
		bst.add(4);
		
		bst.traverseLevelWise();
		
		System.out.println(bst.add(4));
		
		
		
	}

}
