package com.baidu.Thread.more;

public class Test_Thread {

	public static void main(String[] args) {
		
		First_More_Thread thread = new First_More_Thread("陈广波");
		First_More_Thread thread2 = new First_More_Thread("WF");
		thread.start();
		thread2.start();
		System.out.println("执行完毕");
		System.err.println("执行完毕");
		Long news =  System.currentTimeMillis();
		Long old = System.currentTimeMillis();
		System.out.println(news-old);
	}

}
