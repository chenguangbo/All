package cn.baidu.StringBuffer;

public class TestStringBuffer {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();
		sb.append("我是一个好孩子!");//天假一个字符串
		
		sb.insert(0, "我是乖宝宝,");//在指定位置添加字符串
		
		sb.delete(0,6);//指定位置删除指定长度
		
		sb.reverse();//将缓冲区内的内容翻转
		
		sb.replace(0, 2, "str");//在原有字符串缓冲区内容基础上，将指定范围内的多个字符 用给定的字符串替换
		
		String string = sb.substring(0, 3);
		
		System.out.println(string);
		System.out.println(sb.toString());
	}

}
