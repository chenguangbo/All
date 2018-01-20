package com.baidu.Thread.more;

public class First_More_Thread extends Thread {

	private String name;

	public First_More_Thread(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(name + " >  " + i);
		}
		
	}

}
