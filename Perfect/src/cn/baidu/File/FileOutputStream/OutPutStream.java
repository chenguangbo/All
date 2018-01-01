package cn.baidu.File.FileOutputStream;

import java.io.FileOutputStream;

public class OutPutStream {

	public static void main(String[] args) throws Exception {

		FileOutputStream out = new FileOutputStream("新年快乐.txt");
		out.write("新年快乐".getBytes());
		out.flush();
		out.close();
		//在原有数据上追加
		FileOutputStream out2 = new FileOutputStream("新年快乐.txt",true);
		out2.write("\r\n".getBytes());
		out2.write("新年快乐兔".getBytes());
		out2.flush();
		out2.close();
	}

}
