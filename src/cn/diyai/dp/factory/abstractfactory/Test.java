package cn.diyai.dp.factory.abstractfactory;

public class Test {
	public static void main(String[] args) {
		//DefaultFactory f = new DefaultFactory();
		AbstractFactory f = new DefaultFactory();
		Vehicle v = f.createVehicle();
		v.run();
		Weapon w = f.createWeapon();
		w.shoot();
		Food a = f.createFood();
		a.printName();
	}
}
