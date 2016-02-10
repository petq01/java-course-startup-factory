package org.startupfactory.javacourse.designpatters.proxy;

public class RunLaptopProxy {

	public static void main(String[] args) {
		LaptopFactory factory = LaptopFactory.getInstance();
		LaptopInterface myLaptop = factory.createNewLaptop();
		myLaptop.setUpLaptop("LENOVO ", "yoga", 4, 2);
		System.out.println(myLaptop.getBrandAndModel());
	}

}
