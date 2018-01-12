package cn.baidu.map.Properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Writer_Properties {
	/*
	 * Properties中的数据存储到文件中
	 */
	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		properties.setProperty("你好", "陈广波");
		properties.setProperty("喜欢", "你");
		properties.setProperty("WW", "FF");
		FileOutputStream out =new FileOutputStream("喜欢你.txt");
		properties.store(out, null);
		out.close();
		System.out.println("写入文件完毕");
	}

}
