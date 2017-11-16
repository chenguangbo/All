package cn.baidu.genericity;

/**
 * 泛型接口
 * 在创建实现类对象是被确定
 * 
 * @author CGB
 * @param <T>
 */
public class GenericityInterfaceClass<T> implements GenericityInterface<T> {

	@Override
	public void method(T t) {
		System.out.println(t);
	}

}
