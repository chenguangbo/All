package cn.baidu.map.Properties;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.Set;

public class Properties_keySet {

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		Reader reader = new FileReader("喜欢你.txt");
		properties.load(reader);
		
		Set<Object> keySet = properties.keySet();
		for (Object key : keySet) {
			System.out.println(key+":"+properties.get(key));
		}
		
		
	}
	
}
