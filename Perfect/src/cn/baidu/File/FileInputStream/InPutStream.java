package cn.baidu.File.FileInputStream;

import java.io.FileInputStream;

public class InPutStream {

	public static void main(String[] args) throws Exception {

		FileInputStream in = new FileInputStream("新年快乐.txt");

		byte[] b = new byte[1024];
		int i = 0;
		while ((i = in.read(b)) != -1) {
			System.out.println(new String(b, 0, i));
		}
		in.close();
	}

}
