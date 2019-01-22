import java.util.Arrays;

public class FixedStack {
	private Object [] stack;
	private int top;
	private int size;
	
	private final String ANSI_RED = "\033[0;31m";
	private final String ANSI_GREEN = "\033[0;32m";
	public FixedStack() {
		super();
		this.top = 0;
		this.size = -1;
		stack = new Object[5];
	}
	
	public FixedStack(int size) {
		super();
		this.top = 0;
		stack = new Object[size];
	}
	
	public void push(Object obj) {
		if((size == -1 && top == 5) || top == size) {
			System.out.println(ANSI_RED + "Stack overflown." + ANSI_RED);
			return;
		}
		
		stack[top] = obj;
		top++;
		System.out.println(ANSI_GREEN + "Push successfull" + ANSI_GREEN);
	}
	
	public void print() {
		StringBuffer buffer = new StringBuffer("[");
		
		for(int i = 0; i < stack.length; i++) {
			buffer.append(stack[i]);
			if(i != stack.length -1)
				buffer.append(", ");
		}
		
		buffer.append("]");
		System.out.println(ANSI_GREEN + "Stack :"+buffer.toString() + ANSI_GREEN);
	}
	
	public Object pop() {
		Object object = null;
		
		if(top == 0) {
			System.out.println(ANSI_RED + "Stack underflown." + ANSI_RED);
			return object;
		}
		
		object = stack[top - 1]; 
		stack[top - 1] = null;
		top--;
		System.out.println(ANSI_GREEN + "Pop successful" + ANSI_GREEN);
		return object;
	}
	public int getTop() {
		return top;
	}
	
	public int capacity() {
		return size;
	}
}
