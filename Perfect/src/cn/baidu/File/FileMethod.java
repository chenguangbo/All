package cn.baidu.File;

import java.io.File;

public class FileMethod {

	public static void main(String[] args) {

		File file = new File("C:/Users/CGB/Desktop/陈广波-简历 .doc");
		System.out.println(file);
		File file2 = new File("C:/Users/CGB/Desktop/","/陈广波-简历 .doc");
		System.out.println(file2);
		File file3 = new File("C:/Users/CGB/Desktop/","陈广波-简历 .doc");
		System.out.println(file3);
		
		
		
		
		
		
		
	}

}
