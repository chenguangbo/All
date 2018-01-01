package cn.baidu.File;

import java.io.File;
import java.util.Arrays;

public class FileTest {

	public static void main(String[] args) throws Exception {
		
		//File既可以表示文件也可以表示文件夹
		File file = new File("C:/Users/CGB/Desktop/","/陈广波-简历 .doc");
		//获取本文件的绝对路径
		String path = file.getAbsolutePath();
		System.out.println("文件的绝对路径:"+path);
		//获取本文件的最后一级
		String name = file.getName();
		System.out.println(name);
		//获取相对路径                  File中封装的路径是什么获取到的就是什么。
		String path2 = file.getPath();
		System.out.println(path2);
		
		File file2 = new File("C:/Users/CGB/Desktop/陈广波-简历 .doc");
		//当且仅当文件不存在时  创建一个空文件
		boolean newFile = file2.createNewFile();
		boolean delete = file2.delete();
		
		String[] list = file2.list();
		System.err.println(Arrays.toString(list));
		File[] listFiles = file2.listFiles();
		System.out.println(Arrays.toString(listFiles));
		
		
		
		
	}

}
