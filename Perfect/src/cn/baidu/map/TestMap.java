package cn.baidu.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * HashMap 双列集合 集合不能包含重复的键，值可以重复 存储数据采用的哈希表结构，元素的存取顺序不能保证一致
 * 由于要保证键的唯一、不重复，需要重写键的hashCode()方法、equals()方法。
 * 
 * 
 * LinkedHashMap 存储数据采用的哈希表结构+链表结构 通过链表结构可以保证元素的存取顺序一致
 * 通过哈希表结构可以保证的键的唯一、不重复，需要重写键的hashCode()方法、equals()方法
 * 
 * 注意：Map接口中的集合都有两个泛型变量<K,V>,在使用时，要为两个泛型变量赋予数据类型。
 * 两个泛型变量<K,V>的数据类型可以相同，也可以不同。
 * 
 */
public class TestMap {

	public static void main(String[] args) {

		Map<String,String> map = new HashMap<String,String>();
		
		
		
	}

}
