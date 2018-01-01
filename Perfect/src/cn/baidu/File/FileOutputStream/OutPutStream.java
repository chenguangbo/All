package cn.baidu.File.FileOutputStream;

import java.io.FileOutputStream;

public class OutPutStream {

	public static void main(String[] args) throws Exception {

		FileOutputStream out = new FileOutputStream("新年快乐.txt");
		out.write("新年快乐".getBytes());
		out.flush();
		out.close();
		
	}

}
