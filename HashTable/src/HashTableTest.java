
public class HashTableTest {
	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		
		System.out.println(hashTable.put(5, "Val-5"));
		System.out.println(hashTable.put(10, "Val-5"));
		System.out.println(hashTable.put(15, "Val-5"));
		System.out.println(hashTable.put(10, "Val-5"));
		System.out.println(hashTable.put(25, "Val-5"));
		System.out.println(hashTable.put(30, "Val-5"));
		System.out.println(hashTable.put(35, "Val-5"));
		System.out.println(hashTable.put(40, "Val-5"));
		System.out.println(hashTable.put(41, "Val-5"));
		System.out.println(hashTable.put(46, "Val-5"));
		System.out.println(hashTable.put(52, "Val-5"));
		System.out.println(hashTable.put(57, "Val-5"));
		System.out.println(hashTable.put(63, "Val-5"));
		System.out.println(hashTable.put(68, "Val-5"));
		System.out.println(hashTable.put(74, "Val-5"));
		System.out.println(hashTable.put(79, "Val-5"));
		System.out.println(hashTable.put(1, "Val-5"));
		System.out.println(hashTable.put(2, "Val-5"));
		System.out.println(hashTable.put(3, "Val-5"));
		System.out.println(hashTable.put(4, "Val-5"));
		System.out.println(hashTable.put(59, "Val-5"));
		System.out.println(hashTable.put(12, "Val-5"));
		System.out.println(hashTable.put(9, "Val-5"));
		System.out.println(hashTable.put(13, "Val-5"));
		
		System.out.println(hashTable);
		System.out.println(hashTable.size());
	}
}
