package cn.baidu.map.Properties;

import java.io.FileReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Properties;

public class Properties_values {

	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		Reader reader = new FileReader("喜欢你.txt");
		properties.load(reader);
		
		Collection<Object> values = properties.values();
		for (Object object : values) {
			System.out.println(object);
		}
		
	}

}
