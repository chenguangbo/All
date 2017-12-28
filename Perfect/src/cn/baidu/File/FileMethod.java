package cn.baidu.File;

import java.io.File;
import java.net.URI;
import java.util.Date;

public class FileMethod {

	public static void main(String[] args) throws Exception {

		File file = new File("C:/Users/CGB/Desktop/");
		System.out.println(file);
		File file2 = new File("C:/Users/CGB/Desktop/","/陈广波-简历 .doc");
		System.out.println(file2);
		File file3 = new File("C:/Users/CGB/Desktop/","陈广波-简历 .doc");
		System.out.println(file3);
		
		URI uri = new URI("C:/Users/CGB/Desktop/");
		System.out.println(uri);
//		URI创建只能是文件夹不能是文件
//		URI uri2 = new URI("C:/Users/CGB/Desktop/陈广波-简历 .doc");
//		System.out.println(uri2);
		
		File file4 = new File("https://www.hao123.com/");
		System.out.println(file4);
		//测试文件是否可以被执行         文件可以      文件夹也可以      链接文件为false
		boolean canExecute = file4.canExecute();// 测试应用程序是否可以执行此抽象路径名表示的文件。
		System.out.println(canExecute);
		
		boolean read = file3.canRead();
		System.out.println(read);
		
		//当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。
		File file5 = new File("C:/Users/CGB/Desktop/","/陈广波-简历 1.doc");
		boolean bol = file5.createNewFile();
		System.err.println(bol);
		boolean delete = file5.delete();
		System.out.println(delete);
		//判断此文件是否存在
		boolean exists = file5.exists();
		System.out.println(exists);
		//返回此文件的绝对路径名           此文件被删除也能获取到
		String absolutePath = file5.getAbsolutePath();
		System.out.println(absolutePath);
		
		File absoluteFile = file.getAbsoluteFile();
		System.out.println(absoluteFile);
		//获取当前文件的父路径    
		File parentFile = file5.getParentFile();
		System.out.println(parentFile);

		//获取当前文件的名字
		System.out.println(file5.getName());
		
		//判断是否为绝对路径
		boolean absolute = file5.isAbsolute();
		System.out.println(absolute);
		
		//判断是否为文件
		boolean directory = file5.isDirectory();
		System.out.println(directory);
		
 		boolean file6 = file5.isFile();
		System.out.println(file6);
		
		File[] listFiles = file.listFiles();
	    System.out.println(listFiles.length);
		for (File file7 : listFiles) {
			System.out.println(file7);
		}
	    
		File file8 = new File("D:\\学习视频\\新建文件夹\\第2节 1.3.1.什么是分布式系统中的协调服务");
		File[] listFiles2 = file8.listFiles();
		System.out.println(listFiles2.length);
		for (File file7 : listFiles2) {
			System.out.println(file7);
		}
		
		long lastModified = file5.lastModified();
		System.out.println(new Date(lastModified));
		
		
	    
		//在虚拟机终止时删除此文件或目录
		file5.deleteOnExit(); 
	}

}
