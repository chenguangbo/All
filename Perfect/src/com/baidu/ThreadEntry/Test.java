package com.baidu.ThreadEntry;

public class Test {

	public static void main(String[] args) {
		
		ThreadEntry ThreadEntry = new ThreadEntry();
		Thread thread = new Thread(ThreadEntry,"adas");
		thread.start();
	}
	
	
	
}
