package cn.baidu.genericity;


/**
 * 定義汎型方法
 *    泛型方法在  方法被调用时确定了   泛型的数据类型
 * @author CGB
 * @param <T>
 */

public class GenericityMethod<T> {

	public <E> void method(E e, T t) {

		System.out.println(e);
		System.out.println(t);

	}

}
