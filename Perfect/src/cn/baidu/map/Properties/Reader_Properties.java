package cn.baidu.map.Properties;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class Reader_Properties {

	public static void main(String[] args) throws IOException {
		
		Properties properties = new Properties();
		Reader reader = new FileReader("喜欢你.txt");
		properties.load(reader);
		String name = properties.getProperty("你好");
		System.out.println(name);
		System.out.println(properties);
			
	}

}
