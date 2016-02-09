package org.startupfactory.javacourse.designpatters.builder;

/**
 * concrete class extending ColdDrink
 * 
 * @author Petq
 *
 */
public class Coke extends ColdDrink {

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Coke";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 2.5f;
	}

}
