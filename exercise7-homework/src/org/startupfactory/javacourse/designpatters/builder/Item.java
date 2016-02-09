package org.startupfactory.javacourse.designpatters.builder;

/**
 * an interface Item representing food item and packing
 * 
 * @author Petq
 *
 */
public interface Item {
	public String name();

	public Packing packing();

	public float price();
}
