
public class CLLTest {

	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		
		cll.add(1);
		System.out.println(cll);
		cll.add(2);
		cll.add(3);
		cll.add(4);
		cll.add(5);
		cll.add(6);
		System.out.println(cll);
		cll.addFirst(7);
		System.out.println(cll);
		System.out.println("Count :"+cll.size());
		cll.addToIndex(8, 0);
		System.out.println(cll);
		System.out.println("Get :"+cll.get(0));
		cll.addToIndex(9, -1);
		cll.addToIndex(10, 8);
		System.out.println(cll);
		cll.replace(8, 100);
		System.out.println(cll);
		System.out.println(cll.contains(100));
		cll.remove(7);
		System.out.println(cll);
		cll.removeFirst();
		System.out.println(cll);
		cll.remove(1);
		System.out.println(cll);
		cll.removeLast();
		System.out.println(cll);
		cll.remove(5);
		System.out.println(cll);
		cll.removeIndex(2);
		System.out.println(cll);
		cll.add(2);
		cll.add(3);
		cll.add(4);
		cll.add(5);
		cll.add(6);
		System.out.println(cll);
		cll.removeIndex(0);
		System.out.println(cll);
		cll.removeIndex(5);
		System.out.println(cll);
	}

}
