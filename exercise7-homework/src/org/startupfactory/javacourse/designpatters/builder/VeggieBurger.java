package org.startupfactory.javacourse.designpatters.builder;

/**
 * concrete class extending Burger
 * 
 * @author Petq
 *
 */
public class VeggieBurger extends Burger {

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Veggie Burger";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 1.5f;
	}

}
