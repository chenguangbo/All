package cn.baidu.File.FileCopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_Copy {

	public static void main(String[] args) throws IOException {

		FileOutputStream out = new FileOutputStream("D:/简历.doc");
		FileInputStream in = new FileInputStream("C:\\Users\\CGB\\Desktop\\陈广波-简历  2017年12月11日.doc");

		byte[] b = new byte[1024];
		int i = -1;
		while ((i = in.read(b)) != -1) {
			out.write(b, 0, i);
			out.flush();
		}
		in.close();
		out.close();
		System.out.println("复制完毕");

	}

}
