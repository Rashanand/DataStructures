import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LinkedListHandler {
	
	private static LinkedListStruct base = null; 
	
	public static void main(String[] args) throws IOException {
		boolean terminate = false;
		Scanner reader = new Scanner(System.in);
		do{
			int option = 0;
			System.out.println("1. Print");
			System.out.println("2. Count");
			System.out.println("3. Add Item");
			System.out.println("4. Delete Item");
			System.out.println("5. Delete First");
			System.out.println("6. Delete Last");
			System.out.println("7. Delete List");
			System.out.println("0. Exit");
			System.out.print("Enter :");
			try {
				option = reader.nextInt();
				switch(option) {
				 case 0: terminate = true;
				 		System.out.println("Terminated.");
				 		break;
				 case 1: print();
				 		break;
				 case 2: count();
				 		break;
				 case 3: addItem();
				 		break;
				 case 4: deleteItem();
				 		break;
				 case 5: deleteFirst();
				 		break;
				 case 6: deleteLast();
				 		break;
				 case 7: deleteList();
				 		break;
				}
			}
			catch(Exception e) {
				System.out.println("Invalid input\n");
			}
			
		}while(!terminate);
	}
	private static void print() {
		if(base == null) {
			System.out.println("Empty list.");
			return;
		}
		StringBuffer sb = new StringBuffer("[ ");
		if(base != null) {
			LinkedListStruct item = base;
			while(item != null) {
				if(item.getNext() != null)
					sb.append(item.getData()+", ");
				else
					sb.append(item.getData());
				item = item.getNext();
			}
		}
		sb.append(" ]");
		
		System.out.println(sb.toString());
	}
	private static int count() {
		int count = 0;
		if (base == null) {
			System.out.println("Empty list.");
			return count;
		}
		
		LinkedListStruct item = base;
		
		while(item != null) {
			count++;
			item = item.getNext();
		}
		System.out.println("Size :"+count);
		return count;
	}
	private static void addItem() {
		LinkedListStruct item = null;
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Enter data : ");
		String data = reader.nextLine();
		
		item = new LinkedListStruct(data);
		if(base == null) {
			base = item;
		}
		else {
			LinkedListStruct curNode = base;
			while(curNode.getNext() != null) {
				curNode = curNode.getNext();
			}
			curNode.setNext(item);
		}
		//reader.close();
	}
	private static void deleteItem() {
		if(base == null) {
			System.out.println("Empty list.");
			return;
		}
		int index = 0;
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Enter index :");
		index = reader.nextInt();
		deleteIndex(index);
	}
	
	private static void deleteIndex(int index) {
		int count = count();
		if(count < index) {
			System.out.println("Index out of bounds :"+index+" List size :"+count);
			return;
		}
		LinkedListStruct item = base;
		if(index == 1) {
			if(count == 1) {
				base = null;
			}else {
				base = base.getNext();
			}
			System.out.println("Item deleted : " + item.getData());
		} else {
			for (int i = 1; i < index - 1; i++) {
				item = item.getNext();
			}
			LinkedListStruct deleted = item.getNext();

			item.setNext(item.getNext().getNext());

			System.out.println("Item deleted : " + deleted.getData());
		}
	}
	private static void deleteFirst() {
		if(base == null) {
			System.out.println("Empty list.");
			return;
		}
		deleteIndex(1); 	
	}
	private static void deleteLast() {
		if(base == null) {
			System.out.println("Empty list.");
			return;
		}
		deleteIndex(count());
	}
	private static void deleteList() {
		if (base != null)
			base = null;
		System.out.println("List deleted.");
	}
}
