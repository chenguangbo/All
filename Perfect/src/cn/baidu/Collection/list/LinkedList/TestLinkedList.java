package cn.baidu.Collection.list.LinkedList;

import java.util.LinkedList;

/**
 * LinkedList特点
 * 		底层数据为链表
 * 		查询慢  增删快  不安全的  效率高  大量的首尾操作的方法
 * public void addFirst(E e)将指定元素插入此列表的开头。
 * public void addLast(E e)将指定元素添加到此列表的结尾
 * public E getFirst()返回此列表的第一个元素
 * public E getLast()返回此列表的最后一个元素。
 * public E removeFirst()移除并返回此列表的第一个元素
 * public E removeLast()移除并返回此列表的最后一个元素
 * @author CGB
 *
 */
public class TestLinkedList {

	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("陈广波");
		list.add(1, "心上人");
		list.addLast("是");
		list.add(1, "的");
		String last = list.getLast();
		System.out.println(last);
		boolean empty = list.isEmpty();
		System.out.println(empty);
		int size = list.size();
		System.out.println(size);
		System.out.println(list);
	
	
	
	
	
	}
	
	
	
	
	
}
