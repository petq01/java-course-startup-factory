package org.startupfactory.javacourse.designpatters.proxy;

public class Laptop implements LaptopInterface {
	private String model;
	private String brand;
	private int powerRAM;
	private int processorVolume;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPowerRAM() {
		return powerRAM;
	}

	public void setPowerRAM(int powerRAM) {
		this.powerRAM = powerRAM;
	}

	public int getProcessorVolume() {
		return processorVolume;
	}

	public void setProcessorVolume(int processorVolume) {
		this.processorVolume = processorVolume;
	}

	@Override
	public void setUpLaptop(String model, String brand, int powerRAM, int processorVolume) {
		setBrand(brand);
		setProcessorVolume(powerRAM);
		setPowerRAM(processorVolume);
		setModel(model);
	}

	@Override
	public String getBrandAndModel() {

		return "Model:- " + getModel() + " -brand:- " + getBrand() + " -processor vol GB- " + getProcessorVolume()
				+ " --power of RAM-- " + getPowerRAM();
	}

}
