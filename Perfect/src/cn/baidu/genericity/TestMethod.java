package cn.baidu.genericity;

public class TestMethod {

	public static void main(String[] args) {

		GenericityMethod<String> gm = new GenericityMethod<>();
		gm.setT("CGB");

		String t = gm.getT();
		System.out.println(t);
	}

}
