package cn.baidu.Collection.list.ArrayList;

import java.util.ArrayList;

/**
 * ArrayList的contains方法测试
 * 
 * contains方法底层使用equals方法进行比较的
 * 
 * @author CGB
 *
 */
public class TestArrayList {

	public static void main(String[] args) {

		
		ArrayList<String> list = new ArrayList<String>();
		list.add("陈广波");
		list.add("XX");
		boolean contains = list.contains("XX"); //String重写了equals方法
		System.out.println(contains);
		
		ArrayList<Person> list2 = new ArrayList<Person>();
		Person p = new Person("习近平",13);
		Person p2 = new Person("彭丽媛",12);
		list2.add(p);
		list2.add(p2);
		
		boolean b = list2.contains(p);
		System.out.println(b);
		
		boolean c = list2.contains(new Person("习近平",13)); //如果重写equals方法Contains方法比较的是地址值为false
		System.err.println(c);   
		
		
		
	
		
		
		
		
	}

}
