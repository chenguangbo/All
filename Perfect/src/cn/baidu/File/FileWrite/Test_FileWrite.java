package cn.baidu.File.FileWrite;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Test_FileWrite {

	public static void main(String[] args) throws IOException {

		FileWriter write = new FileWriter("新年快乐.txt",true);
		write.write("\r\n");
		write.write(new Date(System.currentTimeMillis()).toString());
		write.flush();
		write.close();
		System.out.println("写入完成");
	}

}
