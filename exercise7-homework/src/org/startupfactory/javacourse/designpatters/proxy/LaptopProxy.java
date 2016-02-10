/**
 * 
 */
package org.startupfactory.javacourse.designpatters.proxy;

/**
 * @author Petq
 *
 */
public class LaptopProxy implements LaptopInterface {
	private Laptop laptop;

	@Override
	public void setUpLaptop(String model, String brand, int horsePower, int fuelUsage) {
		laptop = new Laptop();
		laptop.setUpLaptop(model, brand, horsePower, fuelUsage);
	}

	@Override
	public String getBrandAndModel() {
		// TODO Auto-generated method stub
		return laptop.getBrandAndModel();
	}

}
