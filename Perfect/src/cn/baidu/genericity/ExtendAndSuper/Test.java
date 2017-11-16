package cn.baidu.genericity.ExtendAndSuper;

import java.util.ArrayList;

/**
 * 泛型限定
 * 
 * 有三个集合  存储了 动物     猫    狗 
 * 定义一个方法   遍历集合 依次的调用每个动物 吃的方法
 * 
 * 上限限定  ？ extends 父类  只能传入 父类 及子类的数据类型
 * 下限限定   ？ super 父类     只能传入父类 及其父类的数据类型
 * 
 * 当传入的不符合  泛型的上下限时   调用会报错
 */
public class Test {

	public static void main(String[] args) {
		ArrayList<Animal> list1 = new ArrayList<Animal>();
		
		ArrayList<Dog> list2 = new ArrayList<Dog>();
		
		ArrayList<Cat> list3 = new ArrayList<Cat>();
		
		ArrayList<String>  list4 = new ArrayList<String>();
		
		showList(list1);
		showList(list2);
		showList(list3);
//		showList(list4);
	}
	
	public static void showList(ArrayList<? extends Animal> list){
		for (int i = 0; i <list.size(); i++) {
			Animal a = (Animal) list.get(i);
			a.eat();
		}
	}
}
