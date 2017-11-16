package cn.baidu.genericity;

/**
 * 泛型类在创建对象时定义了数据类型
 * @author CGB
 * @param <T>
 */
public class GenericityClass<T> {

	private T name;

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	public void method() {

	}

}
