package cn.baidu.File;

import java.io.File;

/*
 * 遍历文件夹
 */

public class TestDir {

	
	public static void main(String[] args) {
		
		File file = new File("C:/Users/CGB/Desktop");
		String[] list = file.list();
		//得到相对路径
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println("-----------------------------------");
		//得到全路径
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			System.out.println(file2);
		}
		
	}
}
