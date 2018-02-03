package cn.diyai.dp.factory;

import java.util.ArrayList;
import java.util.List;

public class Car implements Moveable{
	
	private static Car car = new Car();
	//private static List<Car> cars = new ArrayList<Car>();
	
	public Car(){}
	
	public static Car getInstance() {
		
		return car;
	}
	
	public void run() {
		System.out.println("冒着烟奔跑中car.......");
	}
}
