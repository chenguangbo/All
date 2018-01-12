package cn.baidu.map.Properties;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class Properties_Entry {

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		Reader reader = new FileReader("喜欢你.txt");
		properties.load(reader);
		Set<Entry<Object,Object>> entrySet = properties.entrySet();
		for(Entry<Object,Object> entry : entrySet){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		System.out.println(entrySet);
	}

}
