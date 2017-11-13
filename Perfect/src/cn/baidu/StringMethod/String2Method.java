package cn.baidu.StringMethod;

import java.util.Arrays;

public class String2Method {

	public static void main(String[] args) {

		String str = "abc+def+ghi";
		
		String[] split = str.split("\\+");
		
		String string = Arrays.toString(split);
		System.out.println(string);
		
		String replaceAll = str.replaceAll("\\+", "");
		System.out.println(replaceAll);
		
		System.err.println(String.class.getName()+"@"+str.hashCode());
		
	}

}
