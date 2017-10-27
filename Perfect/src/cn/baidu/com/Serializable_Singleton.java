package cn.baidu.com;

import java.io.Serializable;

/**
 * 序列化到磁盘上的单例
 * 
 * @author CGB
 *
 */
public class Serializable_Singleton implements Serializable {

	private static final long serialVersionUID = 1L;

	static String name;

	private Serializable_Singleton() {
		System.out.println("create");
		name = "Serializable_Singleton";
	}

	private static Serializable_Singleton instance = new Serializable_Singleton();

	public static Serializable_Singleton getInstance() {
		System.out.println(name);
		return instance;
	}
	//这个方法去掉    就会抛出junit.framework.AssertionFailedError:excepted:javauning......
	//but was javatuning......
	//这个方法会阻止创建对象直接返回反序列化出来的对象
	private Object readResolve(){
		return instance ;
	}

}
