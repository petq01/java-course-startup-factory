package org.startupfactory.javacourse.designpatters.builder;

/**
 * abstract classes implementing the item interface providing default
 * functionalities
 * 
 * @author Petq
 *
 */
public abstract class Burger implements Item {

	@Override
	public Packing packing() {
		// TODO Auto-generated method stub
		return new Wrapper();
	}

	@Override
	public abstract float price();

}
