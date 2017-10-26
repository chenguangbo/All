package cn.baidu.com;

public class Singleton {

	private Singleton(){
		
	}
	//缺点无法延迟加载
	private static Singleton singleton = new Singleton();
	public static Singleton getSingleton(){
		return singleton;
	}
	
	
}
