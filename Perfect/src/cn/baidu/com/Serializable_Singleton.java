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

	String name;

	private Serializable_Singleton() {
		System.out.println("create");
		name = "Serializable_Singleton";
	}

	private static Serializable_Singleton instance = new Serializable_Singleton();

	public static Serializable_Singleton getInstance() {

		return instance;
	}

}
