package org.startupfactory.javacourse.designpatters.proxy;

public class LaptopFactory {
	private static LaptopFactory instance;

	/**
	 * private constructor
	 */
	private LaptopFactory() {
	}

	public static LaptopFactory getInstance() {
		if (instance == null) {
			instance = new LaptopFactory();
		}
		return instance;
	}

	public LaptopInterface createNewLaptop() {
		return new LaptopProxy();
	}
}
