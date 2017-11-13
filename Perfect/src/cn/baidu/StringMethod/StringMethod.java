package cn.baidu.StringMethod;

import java.util.Arrays;

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
		
		int length = str.length();//获取字符串的长度
		System.out.println(length);
		
		String substring = str.substring(1,2);//从指定位开始   到指定位置结束截取该字符串    返回新的字符串     (索引从0开始,包左不包右)
		System.out.println(substring);
		
		int indexOf = str.indexOf("d");//返回该字符产在本字符串中第一次出现的位置
		System.out.println(indexOf);
		
		byte[] bytes = str.getBytes();//把字符串转换成字节数组
		System.out.println(Arrays.toString(bytes));
		
		char[] charArray = str.toCharArray();//将当前字符穿转换成字符数组
		System.out.println(Arrays.toString(charArray));
		
		String replace = str.replace("abc", "ABC");//将给定的旧字符串，用新字符串替换
		System.out.println(replace);
		
		String a = "        abc      ";
		String trim = a.trim();   //去除字符串两端的空格
		System.out.println(trim); 
		
		String lowerCase = a.toLowerCase();//将整个字符串转换为小写
		System.out.println(lowerCase);
		
		String upperCase = a.toUpperCase();//将整个字符串转换为大写
		System.out.println(upperCase);
		
	
		
	}

}
