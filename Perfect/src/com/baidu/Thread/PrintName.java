package com.baidu.Thread;

public class PrintName {

	private String name;

	public PrintName(String name) {
		this.name = name;
	};

	public void printName() {
		for (int i = 0; i < 100; i++) {
			System.err.println(name + ":--->" + i);
			System.out.println(i + ":--->" + name);
		}
	}

}
