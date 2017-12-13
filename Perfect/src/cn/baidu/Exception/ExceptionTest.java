package cn.baidu.Exception;

/**
 * checked exception和runtime exception
 * 
 * @author CGB 2017年12月13日21:34:33
 *
 *         checked exception 直接继承Exception的异常就是编译时异常(检测异常) 出现这个异常必须要抛 runtime
 *         exception 继承runtimeException就是运行时异常 或try catch
 */
public class ExceptionTest {

	public static void main(String[] args) {

	}

	public static void method() {

		throw new NullPointerException();
	}

	public static void method2() {
		try {
			throw new Exception();
		} catch (Exception e) {
		
		}
	}
}
