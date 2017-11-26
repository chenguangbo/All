package cn.baidu.Collection.set.HashSet;

import java.util.HashSet;

/**
 * HashSet集合  底层哈希表
 *      无序  唯一  没有索引
 *      
 *      先判断hashCode是否相同 
 *      			不同    直接添加到集合
 *      			相同	
 *      				调用equals 比较内容 
 *      					内容相同 不添加 
 *      					内容不同  添加 	
 *      
 *      
 *      
 *      此类实现Set接口，由哈希表支持（实际上是一个 HashMap集合 (HashMap的kye)）。HashSet集合不能保证的迭代顺序与元素存储顺序相同
 *      HashSet集合，采用哈希表结构存储数据，保证元素唯一性的方式依赖于：hashCode()与equals()方法。
 *      
 */
public class TestHashSet {

	public static void main(String[] args) {

		HashSet<String>  set = new HashSet<String>();
		set.add("abc");
		set.add("bcd");
		set.add("abc");
		//set集合比較的是   hashcode()和equals()方法      
		System.out.println(set);
		
		
	}

}
