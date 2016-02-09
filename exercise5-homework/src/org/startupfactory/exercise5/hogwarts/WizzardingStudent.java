/**
 * 
 */
package org.startupfactory.exercise5.hogwarts;

import java.io.Serializable;

/**
 * @author Petq
 *
 */
public class WizzardingStudent extends Human implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3302633438957250574L;
	private House house;
	Wand wand=new Wand("rosewood","oak","swamp ","ash","ebony");

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
	public WizzardingStudent(String names, int age,House house) {
		super(names,age);
		this.house=house;
	}

}
