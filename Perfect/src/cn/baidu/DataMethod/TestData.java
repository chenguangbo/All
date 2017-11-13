package cn.baidu.DataMethod;

import java.util.Date;

public class TestData {

	public static void main(String[] arg){
		
		Date data = new Date();   //现在的时间
		System.out.println(data);
		
		long time = data.getTime(); //1970-01-01 00:00:00  距离程序执行时的时间毫秒值
		System.out.println(time);
		
		data.setTime(0);
		
		System.out.println(data);
		
		Date date = new Date(1510579649251L);
		System.out.println(date);
		
		
	}
	
	
	
	
}
