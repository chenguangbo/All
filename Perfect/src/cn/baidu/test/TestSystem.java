package cn.baidu.test;

public class TestSystem {

	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());//当前时间的时间戳
		System.out.println(System.getProperties());//本系统的一些基本配置文件
		System.err.println(System.currentTimeMillis());
		System.gc();//调用垃圾回收机制
		System.exit(0);//退出虚拟机
	}
	
}
