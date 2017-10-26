package cn.baidu.com;

public class Multithreading_Lazy_Singleton {

	private Multithreading_Lazy_Singleton(){
		
	}
	
	private static Multithreading_Lazy_Singleton multLazySingleton = null;
	
	public static synchronized Multithreading_Lazy_Singleton getMultLazySingleton(){
		if(multLazySingleton==null){
			multLazySingleton = new Multithreading_Lazy_Singleton(); 
		}
		return multLazySingleton;
	}
	
	
}
