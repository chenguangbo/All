package cn.baidu.com;

public class MyCar implements Car {

	@Override
	public void run() {
		System.out.println("我的汽车奔跑");
	}

	@Override
	public void stop() {
		System.out.println("我的汽车刹车");
	}

}
