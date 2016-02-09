package org.startupfactory.javacourse.designpatters.builder;

/**
 * concrete class extending Burger
 * 
 * @author Petq
 *
 */
public class ChickenBurger extends Burger {

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Chicken burger";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 3.6f;
	}

}
