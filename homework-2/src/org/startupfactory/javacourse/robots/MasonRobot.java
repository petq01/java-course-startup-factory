package org.startupfactory.javacourse.robots;

import kareltherobot.Directions;

/**
 * TODO: Document!
 */
public class MasonRobot extends RightTurner implements HouseBuilder {

	/**
	 * TODO: Document!
	 */
	public MasonRobot(int street, int avenue) {
		super(1, 1, Directions.East);
	}

	@Override
	public void build() {
		System.out.println("Building house base!");
		// TODO: implement
	}

}
