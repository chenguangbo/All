package cn.baidu.DataMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DataFormate测试类
 * @author CGB
 *
 */
public class DataFormateMethod {

	public static void main(String[] args) {

		Date date = new Date();
		long time = date.getTime();
		System.out.println(time);
		System.out.println(date);
		
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
		String format = df.format(date);
		System.out.println(format);
		
		
		
		
		
		
	}

}
