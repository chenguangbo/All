package cn.baidu.detail;

public class Test_Integer {

	public static void main(String[] args) {

		int a = 10;
		int b = 10;

		System.out.println(a == b);
		Integer c = 101231;

		Integer d = 112;
		Integer e = 112;
		System.out.println(d == e);
		System.out.println(d.equals(e)); // 在int自动装箱的过程中   如果类型在127 ~ -128 范围内equals比较是true  超过为false

		System.out.println("-----------------------");
		System.out.println(d.getClass().getName() + "@" + Integer.toHexString(d.hashCode()));
		System.out.println(e.getClass().getName() + "@" + Integer.toHexString(e.hashCode()));

		Integer f = 1122;
		Integer g = 1122;
		System.out.println(f == g);
		System.out.println(f.equals(g));
		g.hashCode();// 内容 来产生hash值的
		System.identityHashCode(g);// 内存地址 来产生hash值的
		System.out.println("-----------------------");
		System.out.println(f.toString());
		System.out.println(g.toString());

		System.out.println("g" + System.identityHashCode(g));

		
		
		System.out.println(g.toString().hashCode());
		
	}

}
