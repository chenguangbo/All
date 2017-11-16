package cn.baidu.genericity;

public class GenericityInterfaceClass<T> implements GenericityInterface<T> {

	@Override
	public void method(T t) {
		System.out.println(t);
	}

}
