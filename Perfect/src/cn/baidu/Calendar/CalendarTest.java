package cn.baidu.Calendar;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		//创建日历类对象  返回当前时间
		Calendar c = Calendar.getInstance();

		System.out.println(c);

		int i = c.get(Calendar.YEAR);
		System.out.println(i);
		System.out.println(c.get(Calendar.MONTH));
		System.out.println(c.get(Calendar.DATE));
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		
		System.out.println("--------------------------------");
		//public void add(int field,int amount)	//指定字段增加某值
		c.add(Calendar.YEAR, -2);
		System.out.println(c.get(Calendar.YEAR));//2014年
		c.add(Calendar.MONTH, 5);// 2014 8  + 5个月
		System.out.println(c.get(Calendar.YEAR)); //2015
		System.out.println(c.get(Calendar.MONTH));// 0 代表1月
		c.add(Calendar.DATE,4);// 2015年  1月 28 日   + 4天 
		System.out.println(c.get(Calendar.DATE));// 2015年 2 月 1日
		
		System.out.println("--------------------------");
		//public final void set(int field,int value)//设置指定字段的值
		c.set(Calendar.YEAR, 2016);
		System.out.println(c.get(Calendar.YEAR));
		//public final void set(int year,int month,int date) //直接设置某年某月某日
		c.set(2016, 7, 28);
		//public final Date getTime()	//获取该日历对象转成的日期对象
		//将日历对象转成日期对象
		Date d = c.getTime();
		//日期对象获取毫秒值的方法
		long time = d.getTime();
		System.out.println(time);
		//public long getTimeInMillis() //日历对象获取毫秒值的方法
		long timeInMillis = c.getTimeInMillis();
		System.out.println(timeInMillis);
		
		
		
	}
}