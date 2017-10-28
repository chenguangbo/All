package cn.baidu.decorator;

public class TestDomain {

	/**
	 * 增强方法的方式
	 *	1.继承
	 *	2.装饰者模式
	 *		1).装饰者和被装饰者需要实现同一个接口或者继承同一个类
	 *		2).装饰者里面需要有被装饰者的引用
	 *		3).增强需要增强的方法
	 *		4).不需要增强的方法调用原本的方法
	 *
	 *	3.动态代理 
	 */
	
	public static void main(String[] args) {

		MyCar car = new MyCar();
		car.run();
		car.stop();
		DecoratorCar decoratorCar = new DecoratorCar(car);
		decoratorCar.run();
		decoratorCar.stop();

	}

}
