package cn.baidu.map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestHashMap {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("陳廣波", "陈广波");
		map.put("愛", "爱");
		map.put("XX", "xx");
		map.put("....", "....");

		String key1 = map.get("愛");
		System.out.println(key1);

		String remove = map.remove("....");
		System.out.println("被刪除的數據是:  " + remove);

		System.out.println("map遍历部分------------------------------");
		
		// Map便利
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		
		
		
		

	}

}
