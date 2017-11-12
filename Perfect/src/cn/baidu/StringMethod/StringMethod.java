package cn.baidu.StringMethod;

public class StringMethod {

	public static void main(String[] args) {

		String str = "abcd";
		char charAt = str.charAt(1);//返回指定索引处的char值
		System.out.println(charAt);
		
		boolean b = str.startsWith("abc");//判读字符串是否以abc开头
		System.out.println(b);
		
		boolean c = str.equals("abcd");//判断两个字符串是否相等
		boolean d = str.equals("abc");
		System.out.println(c);
		System.out.println(d);
		
		boolean e = str.equalsIgnoreCase("ABCD");//忽略大小写比较两个字符串
		System.out.println(e);
		
		String concat = str.concat(str);//将括号中的字符串拼接到    原字符串的结尾
		System.out.println(concat);
		
		boolean f = str.endsWith("d");//是否一字符串d结尾
		System.out.println(f);
		
		boolean empty = str.isEmpty();//评判字符串是否为空""
		System.out.println(empty);
		
		
		
	}

}
