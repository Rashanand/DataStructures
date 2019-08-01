
//Hashtable ADT
/*
1. CreateHashTable 
2. HashSearch
3. HashInsert
4. HashDelete
5. HashReplace
6. DeleteHashTable*/
// Arrays - Direct addressing
// 
public class HashTable {
	private Node [] hashTable = null;
	private int size = 0;
	private int capacity = 0;
	
	public HashTable() {
		super();
		this.capacity = 5;
		this.hashTable = new Node[capacity];
	}
	
	public HashTable(int capacity) {
		super();
		this.capacity = capacity;
	}
	
	private int doHash(Object key) {
		int hashValue = -1;
		
		if(key instanceof Integer) {
			hashValue = (Integer) key % capacity;
		}
		else if(key instanceof String) {
			hashValue = key.toString().hashCode() % capacity;
		}
		
		return hashValue;
	}
	
	public boolean put(Object key, Object value) {
		if(this.hashTable == null) {
			return false;
		}
		
		boolean addEntry = false;
		
		int bucket = this.doHash(key);
		
		if(bucket > -1 && bucket < this.capacity) {
			HashEntry entry = new HashEntry(key, value);
			
			Node start = this.hashTable[bucket];
			if(start == null) {
				start = new Node(entry);
				hashTable[bucket] = start;
				addEntry = true;
			}
			else {
				Node currNode = start;
				boolean areUnique = false;
				while(currNode != null) {
					areUnique = this.compareKeys(key, currNode.getData().getKey());
					if(! areUnique) {
						break;
					}
					
					currNode = currNode.getNext();
				}
				if(areUnique) {
					Node node = new Node(entry);
					currNode.setNext(node);
					addEntry = true;
				}
			}
		}
		this.increaseSize(addEntry);
		return addEntry;
	}
	private boolean compareKeys(Object key1, Object key2) {
		boolean areUnique = false;
		
		if(key1 != null) {
			if(! key1.equals(key2)) {
				areUnique = true;
			}
		}
		
		return areUnique;
	}
	private void increaseSize(boolean addEntry) {
		if(addEntry) {
			this.size++;
		}
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		
		for(int i = 0; i < capacity; i++) {
			Node node = hashTable[i];
			if(node != null) {
				while(node != null) {
					sb.append(node.toString());
					sb.append(", ");
					node = node.getNext();
				}
			}
		}
		
		int length = sb.length();
		if(sb.lastIndexOf(",") == length - 2) {
			sb.delete(length - 2, length);
		}
		
		sb.append("]");
		return sb.toString();
	}
	
	
}
