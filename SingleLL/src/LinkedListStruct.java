
public class LinkedListStruct {
	private Object data;
	private LinkedListStruct next;
	public LinkedListStruct(Object data) {
		super();
		this.data = data;
	}
	public void setNext(LinkedListStruct next) {
		this.next = next;
	}
	public Object getData() {
		return data;
	}
	public LinkedListStruct getNext() {
		return next;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinkedListStruct other = (LinkedListStruct) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LinkedListStruct [data=" + data + ", next=" + next + "]";
	}
	
}
