package org.startupfactory.javacourse.robots;

import kareltherobot.Directions;

/**
 * TODO: Document!
 */
public class RoofBuilder extends RightTurner implements HouseBuilder {

	/**
	 * TODO: Document!
	 */
	public RoofBuilder(int street, int avenue) {
		super(street, avenue, Directions.East);
	}

	/**
	 * TODO: Document!
	 */
	@Override
	public void build() {
		buildLeftSideOfRoof();
		buildRightSideOfRoof();
	}

	/**
	 * TODO: Document!
	 */
	private void buildRightSideOfRoof() {
		// TODO: implement
	}

	/**
	 * TODO: Document!
	 */
	private void buildLeftSideOfRoof() {
		System.out.println("Building house roof!");
		// TODO: implement
	}

}
