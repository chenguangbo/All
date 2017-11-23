package cn.baidu.Collection.list.vector;

import java.util.Enumeration;
import java.util.Vector;
/**
 * vector是线程安全的
 * 		效率低
 *      底层是数组(查找快增删慢)
 * @author CGB
 *
 */

public class TestVector {

	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();
		vector.addElement("cgb");//vector特有的添加方法     和 add()方法一样
		String at = vector.elementAt(0);   //vector特有的取值方法       和get一样
		String string = vector.get(0);
		System.out.println(string);
		System.out.println(at);
	
		Enumeration<String> elements = vector.elements(); //返回枚举
		String nextElement = elements.nextElement();//取出下一个元素
		boolean hasMoreElements = elements.hasMoreElements();//判断是否有下一个元素
		
	
	}
	/**
	 * Vector集合数据存储的结构是数组结构，为JDK中最早提供的集合。Vector中提供了一个独特的取出方式，就是枚举Enumeration，它其实就是早期的迭代器。此接口Enumeration的功能与 Iterator 接口的功能是类似的。Vector集合已被ArrayList替代。枚举Enumeration已被迭代器Iterator替代。
	 */
}
