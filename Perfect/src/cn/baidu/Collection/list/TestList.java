package cn.baidu.Collection.list;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	public static void main(String[] args) {

	
	List<String> list = new ArrayList<String>();
	list.add(0, "陈广波");//指定位置添加    这是list特有的方法
	list.add("喜欢");    //直接添加元素     这是Collection的方法       
	list.add(2, "XX");
	
	String remove = list.remove(1);//这是List集合特有的方法删除指定位置的元素   并返回该元素
	System.out.println(remove);
	
	boolean remove2 = list.remove("你好");//这是Collection特有的方法   返回为boolean
	System.out.println(remove2);
	int indexOf = list.indexOf("陈广波");//判断这个元素在本集合中存不存在  如果存在返回该元素在集合中的索引   不存在返回-1
	System.out.println(indexOf);
	
	boolean contains = list.contains("陈广波");
	System.out.println("是否包含:"+contains);
	int size = list.size();//获取集合的长度
	list.clear();//清空集合
	System.out.println(list);

	
	
	
	
	}

}
