package cn.baidu.map.Properties;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class Properties_Iterator {

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		Reader reader = new FileReader("喜欢你.txt");
		properties.load(reader);

		Set<Entry<Object, Object>> entrySet = properties.entrySet();
		Iterator<Entry<Object, Object>> iterator = entrySet.iterator();
		while(iterator.hasNext()){
			Entry<Object, Object> entry = iterator.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
