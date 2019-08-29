
public class HashTableTest {
	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		
		/*System.out.println(hashTable.put(5, "Val-5"));
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
		System.out.println(hashTable.put(13, "Val-5"));*/
		hashTable.put(5, "Val-5");
		hashTable.put(10, "Val-10");
		hashTable.put(15, "Val-15");
		System.out.println(hashTable.put(10, "Val-101"));
		hashTable.put(25, "Val-25");
		hashTable.put(30, "Val-30");
		hashTable.put(35, "Val-35");
		hashTable.put(40, "Val-40");
		hashTable.put(41, "Val-41");
		hashTable.put(46, "Val-46");
		hashTable.put(52, "Val-52");
		hashTable.put(57, "Val-57");
		hashTable.put(63, "Val-63");
		hashTable.put(68, "Val-68");
		hashTable.put(74, "Val-74");
		hashTable.put(79, "Val-79");
		hashTable.put(1, "Val-1");
		hashTable.put(2, "Val-2");
		hashTable.put(3, "Val-3");
		hashTable.put(4, "Val-4");
		hashTable.put(59, "Val-59");
		hashTable.put(12, "Val-12");
		hashTable.put(9, "Val-9");
		hashTable.put(13, "Val-13");
		
		System.out.println(hashTable);
		System.out.println(hashTable.size());
		
		System.out.println(hashTable.containsKey(40));
		System.out.println(hashTable.get(40));
	}
}
