package cn.baidu.File.PrintStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class PrintStream_Test3 {

	public static void main(String[] args) throws IOException {
		OutputStream writer = new FileOutputStream("字节打印流.txt");
		PrintStream out = new PrintStream(writer,true);
		out.println("我爱我的祖国");
		out.println("我爱我的祖国");
		out.println("我爱我的祖国");
		out.println("我爱我的祖国");
		out.close();
		System.out.println("輸出完畢");
	}

}
