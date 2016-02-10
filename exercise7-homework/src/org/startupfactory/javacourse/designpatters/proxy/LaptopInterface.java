package org.startupfactory.javacourse.designpatters.proxy;

public interface LaptopInterface {
	/**
	 * 
	 * @param model
	 * @param brand
	 * @param powerRAM
	 * @param processorVolume
	 */
	public void setUpLaptop(String model, String brand, int powerRAM, int processorVolume);

	/**
	 * 
	 */
	public String getBrandAndModel();
}
