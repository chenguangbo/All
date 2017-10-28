package cn.baidu.decorator;

public class DecoratorCar implements Car {

	private Car t;

	public DecoratorCar(Car t){
		this.t=t;
	}
	
	@Override
	public void run() {
		add();
		System.out.println("MyCar起飞");
	}

	@Override
	public void stop() {
		t.stop();
	}
	
	public void add(){
		System.out.println("添加氮气,镶钻     改装");
	}

}
