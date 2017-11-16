package cn.baidu.genericity;

public class TestClass {

	public static void main(String[] args) {

		//泛型类的测试
		GenericityClass<String> gc = new GenericityClass<>();
		gc.setName("CGB");
		String name = gc.getName();
		System.out.println(name);

	}

}
