
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
	
	public Object put(Object key, Object value) {
		Object oldValue = null;
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
				Node prevNode = start;
				boolean areUnique = false;
				while(currNode != null) {
					areUnique = this.compareKeys(key, prevNode.getData().getKey());
					if(! areUnique) {
						break;
					}
					
					prevNode = currNode;
					currNode = currNode.getNext();
				}
				//the previous value associated with key; else null
				if(areUnique) {
					Node node = new Node(entry);
					prevNode.setNext(node);
					addEntry = true;
				}
				else {
					oldValue = prevNode.getData().getValue();
					prevNode.setData(entry);
				}
			}
		}
		this.increaseSize(addEntry);
		return oldValue;
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
	
	public boolean containsKey(Object key) {
		boolean keyFound = false;
		int bucket = -1;
		
		bucket = doHash(key);
		
		if(bucket != -1) {
			Node start = hashTable[bucket];
			
			if(start != null) {
				while(start != null) {
					Object nodeKey = start.getData().getKey();
					if(compareKeys(key, nodeKey)) {
						keyFound = true;
						break;
					}
					start = start.getNext();
				}
			}
		}
		
		return keyFound;
	}
	
	public Object get(Object key) {
		Object value = null;
		int bucket = -1;
		
		bucket = doHash(key);
		
		if(bucket != -1) {
			Node start = hashTable[bucket];
			while(start != null) {
				Object nodeKey = start.getData().getKey();
				if(compareKeys(key, nodeKey)) {
					value = start.getData().getValue();
				}
				start = start.getNext();
			}
		}
		
		return value;
	}
	
	//Replace
	/*Object put(Object key, Object newVal)
	 
	  Parameters: key - key with which the specified value is to be associated
				  value - value to be associated with the specified key
	  Returns: the previous value associated with key, or null if there was no mapping for key.*/
	public Object replace(Object key, Object newVal) {
		Object oldVal = null;
		int bucket = -1;
		
		bucket = doHash(key);
		if(bucket != -1) {
			Node start = hashTable[bucket];
			Node prevNode = start;
			
			while(start != null) {
				
			}
		}
		
		return oldVal;
	}
	
	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		
		for(int i = 0; i < capacity; i++) {
			Node node = hashTable[i];
			if(node != null) {
				while(node != null) {
					sb.append(node.toString());
					sb.append("; ");
					node = node.getNext();
				}
			}
		}
		
		int length = sb.length();
		if(sb.lastIndexOf(";") == length - 2) {
			sb.delete(length - 2, length);
		}
		
		sb.append("]");
		return sb.toString();
	}
	
	
}
