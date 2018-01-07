package cn.baidu.File.FileWrite;

import java.io.FileWriter;
import java.io.IOException;

public class Test_FileWrite {

	public static void main(String[] args) throws IOException {

		FileWriter write = new FileWriter("新年快乐.txt",true);
		write.write("\r\n");
		write.write("2018年1月7日20:16:24");
		write.flush();
		write.close();
		System.out.println("写入完成");
	}

}
