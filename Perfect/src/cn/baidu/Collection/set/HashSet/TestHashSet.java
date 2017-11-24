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
 */
public class TestHashSet {

	public static void main(String[] args) {

		HashSet<String>  set = new HashSet<String>();
		set.add("abc");
		set.add("bcd");
		set.add("abc");
		
		
		
		
	}

}
