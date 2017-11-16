package cn.baidu.genericity;

public class TestGenericityInterface {

	public static void main(String[] args) {

		GenericityInterfaceClass<String> gi = new GenericityInterfaceClass<>();
		gi.method("你好!");
		GenericityInterfaceClass2 gic = new GenericityInterfaceClass2();
		gic.method("我好!");
	}

}
