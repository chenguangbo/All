package cn.baidu.com;

public class Singleton {

	private Singleton() {
		System.out.println("create");
	}

	// 缺点无法延迟加载
	//定义成static的类jvm加载该类是就创建类该对象
	private static Singleton singleton = new Singleton();

	public static Singleton getSingleton() {
		return singleton;
	}

	public void test() {
		System.out.println("test");
	}

	public static void main(String[] args) {

		Singleton singleton = Singleton.getSingleton();
		System.out.println(singleton);
		Singleton.getSingleton().test();
		System.out.println(Singleton.getSingleton());
	}
}
