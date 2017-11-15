package cn.baidu.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionTest {

	public static void main(String[] args) {

		Collection<String> c = new ArrayList<String>();
		c.add("意中人");
		c.add("啊!");
		
		
		boolean remove = c.remove("啊!");
		System.err.println(remove);
		//c.clear();
		boolean contains = c.contains("意中人");//判断是否包含某个元素
		boolean empty = c.isEmpty();
		Object[] array = c.toArray();
		System.err.println(Arrays.toString(array));
		System.out.println(empty);//判断是否为空
		int size = c.size();
		System.out.println(size);//获取集合的长度
		System.out.println(contains);
		System.out.println(c);
		
	}

}
