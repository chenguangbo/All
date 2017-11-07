package cn.baidu.System;

import java.util.Properties;

public class System{


	public static void main(String[] args) {
		
		java.lang.System.gc();//调用垃圾回收器   回收不用的对象             但是虚拟机不一定有空回收
		Runtime.getRuntime().gc();//System.gc();相当于Runtime
		//垃圾回收器调用finalize方法回收垃圾

		
		
		
		java.lang.System.currentTimeMillis(); //返回以毫秒为单位的当前时间
		
		
		
		Properties properties = java.lang.System.getProperties();//获取JVM的一些信息     和本操作系统的信息
		
		java.lang.System.out.println(properties.toString());
		
		
		java.lang.System.exit(0); //退出虚拟机   
	}
	
}
