package cn.diyai.dp.thinkinginoo;


public class Test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String driverName = "老张";
		String vehicle = "车";
		String targetPlace = "东北";
		go(driverName, vehicle, targetPlace);
	}
	
	public static void go(String driverName, String vehicle, String targetPlace) {
		System.out.println(driverName + "开" + vehicle + "去" + targetPlace);
	}
}

