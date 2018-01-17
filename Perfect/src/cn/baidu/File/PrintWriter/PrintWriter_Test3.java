package cn.baidu.File.PrintWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_Test3 {

	public static void main(String[] args) throws IOException {
		FileWriter out1 = new FileWriter("字符打印流.txt");
		//OutputStreamWriter out3 = new OutputStreamWriter(out1, "你好!");
		BufferedWriter out2 = new BufferedWriter(out1);
		PrintWriter out = new PrintWriter(out2,true);
		out.println("字符打印劉");
		out.println("字符打印劉");
		out.println("字符打印劉");
		out.close();
		System.out.println("写入数据完成");
	}

}
