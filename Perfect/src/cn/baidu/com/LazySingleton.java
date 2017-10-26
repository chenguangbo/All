package cn.baidu.com;

/**
 * 懒汉式
 * 
 * @author CGB
 *
 */
public class LazySingleton {

	private LazySingleton() {
		System.out.println("创建了本实力的对象");
	}

	private static LazySingleton lazySingleton = null;

	public static LazySingleton getlazySingleton() {
		if (lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}

}
