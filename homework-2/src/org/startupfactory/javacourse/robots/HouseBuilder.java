package org.startupfactory.javacourse.robots;

/**
 * Defines the build method for a family of robots that participate in the
 * process of building a house. Each concrete builder should implement this
 * interface and use the build() method to draw the respective element of the
 * house.
 * 
 * @author Ivo Rusev
 *
 */
public interface HouseBuilder {

	/**
	 * Builds a part of the house.
	 */
	public void build();

}
