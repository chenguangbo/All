package cn.baidu.map.Properties;

import java.util.Properties;

public class Test_Properties {

	public static void main(String[] args) {
		//不保证properties的存取顺序一致
		Properties properties = new Properties();
		properties.setProperty("陈广波","XX");
		properties.setProperty("喜欢","XX");
		properties.setProperty("XX","XX");
		
		System.out.println(properties);
	}

}
