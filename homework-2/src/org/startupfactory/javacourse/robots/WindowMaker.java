package org.startupfactory.javacourse.robots;

import kareltherobot.Directions;

/**
 * TODO: Document!
 */
public class WindowMaker extends RightTurner implements HouseBuilder {

	/**
	 * TODO: Document!
	 */
	public WindowMaker(int street, int avenue) {
		super(street, avenue, Directions.East);
	}

	@Override
	public void build() {
		System.out.println("Adding house door and windows!");
		// TODO: implement
	}

}
