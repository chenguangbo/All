package cn.baidu.Collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * set接口特点              不可重复      没有索引
 * @author CGB
 *
 */
public class TestSet {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		set.add("你好");
		set.add("啊");
		set.add("Siri");
		System.out.println(set);
		for (String string : set) {
			System.out.println(string);
		}
		
		
	}
	
	
	
}
