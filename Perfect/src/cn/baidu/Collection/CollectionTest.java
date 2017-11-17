package cn.baidu.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionTest {

	public static void main(String[] args) {

		Collection<String> c = new ArrayList<String>();
		c.add("意中人");//add(元素)  向集合中添加元素
		c.add("啊!");
		boolean remove = c.remove("啊!");//删除元素返回boolean类型
		System.err.println(remove);
		//c.clear();
		boolean contains = c.contains("意中人");//判断是否包含某个元素
		//contains(元素)  判断该元素  是否包含
		boolean empty = c.isEmpty();//判断是否为空
		Object[] array = c.toArray();//将当前这个集合转换为数组
		System.err.println(Arrays.toString(array));
		System.out.println(empty);//判断是否为空
		int size = c.size();//这个集合的长度
		System.out.println(size);//获取集合的长度
		System.out.println(contains);
		System.out.println(c);
		
	}

}
