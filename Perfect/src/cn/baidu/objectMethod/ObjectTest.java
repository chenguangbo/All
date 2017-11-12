package cn.baidu.objectMethod;

public class ObjectTest {

	public static void main(String[] args) {

		
		Object obj = new Object();
		
		int hashCode = obj.hashCode();//hashCode()返回该对象的哈希码值。
		System.out.println(hashCode);
		
		String string = obj.toString();//toString()返回该对象的字符串表示。
		System.out.println(string);
		
		Class clazz = obj.getClass();//返回对象数据类型       返回此对象运行时的类
		System.out.println(clazz);
	
		//finalize()当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。
		/*finalize()由垃圾回收器调用            不是程序员调用的 */
		
		int arr[]={};
	}

}
