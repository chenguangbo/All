package cn.baidu.DataMethod;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DataFormate测试类
 * @author CGB
 *
 */
public class DataFormateMethod {

	public static void main(String[] args) throws ParseException {

		Date date = new Date();
		long time = date.getTime();
		System.out.println(time);
		System.out.println(date);
		//将日期类型转换成字符串
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
		String format = df.format(date);
		System.out.println(format);
		//将日期类型转换成Date类型
		Date parse = df.parse(format);
		System.out.println(parse);
		
		
		
	}

}
