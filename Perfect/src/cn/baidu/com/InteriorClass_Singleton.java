package cn.baidu.com;
/**
 * 内部类方式创建   单例懒汉木事 
 * @author CGB
 *
 */
public class InteriorClass_Singleton {

	private InteriorClass_Singleton() {

	}

	private static class InstanceClaas {
		private static InteriorClass_Singleton instance = new InteriorClass_Singleton();
	}

	public static InteriorClass_Singleton getInstance() {

		return InstanceClaas.instance;
	}

}
