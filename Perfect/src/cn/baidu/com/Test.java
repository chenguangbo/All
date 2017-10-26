package cn.baidu.com;

public class Test {

	public static void main(String[] args) {
		
//		Singleton singleton = Singleton.getSingleton();
//		System.out.println(singleton);
		
		System.out.println(InteriorClass_Singleton.getInstance());
		System.out.println(InteriorClass_Singleton.getInstance());
		
	}
}
