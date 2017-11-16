package cn.baidu.genericity;

public class TestGenericityInterface {

	public static void main(String[] args) {

		GenericityInterfaceClass<String> gi = new GenericityInterfaceClass<>();
		gi.method("你好!");

	}

}
