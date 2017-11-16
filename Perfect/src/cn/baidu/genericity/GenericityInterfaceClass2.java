package cn.baidu.genericity;

/**
 * 定义实现类时 指定泛型
 * @author CGB
 * 2017年11月16日21:37:15
 */
public class GenericityInterfaceClass2 implements GenericityInterface<String> {

	@Override
	public void method(String t) {
		System.out.println(t);
	}

}
