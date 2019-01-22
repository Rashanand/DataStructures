
public class StackDemo {

	public static void main(String[] args) {
		FixedStack fs = new FixedStack();
		fs.pop();
		fs.push("str1");
		fs.push("str2");
		fs.push("str3");
		fs.push("str4");
		fs.push("str5");
		fs.push("str6");
		fs.print();
		fs.pop();
		fs.print();
		fs.push("str6");
		fs.print();
	}

}
