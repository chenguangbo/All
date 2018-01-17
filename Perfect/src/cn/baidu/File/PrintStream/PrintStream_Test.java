package cn.baidu.File.PrintStream;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_Test {

	public static void main(String[] args) throws IOException {

		PrintStream out = new PrintStream("字节打印流.txt");
		out.print(false);
		out.print(false);
		out.flush();
		out.close();

	}

}
