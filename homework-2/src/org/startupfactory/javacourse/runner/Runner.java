package org.startupfactory.javacourse.runner;

import java.util.ArrayList;
import java.util.List;

import org.startupfactory.javacourse.robots.HouseBuilder;
import org.startupfactory.javacourse.robots.MasonRobot;
import org.startupfactory.javacourse.robots.RoofBuilder;
import org.startupfactory.javacourse.robots.WindowMaker;

import kareltherobot.World;

/**
 * Runner class that gathers the robots in a List and draws the house.
 * 
 * @author Ivo Rusev
 *
 */
public class Runner {

	public static void main(String[] args) {
		// 1.Initialize the world.
		World.setSize(30, 30);
		World.setVisible(true);

		// If you need your robots to go slower insert bigger number in set
		// delay.
		World.setDelay(5);

		// Define a list that'll hold the robots.
		List<HouseBuilder> robots = new ArrayList<>();

		// TODO: insert concrete values for your robots.
		HouseBuilder roofBuilder = new RoofBuilder(0, 0);
		HouseBuilder windowMaker = new WindowMaker(0, 0);
		HouseBuilder mason = new MasonRobot(0, 0);
		robots.add(roofBuilder);
		robots.add(windowMaker);
		robots.add(mason);

		for (HouseBuilder robot : robots) {
			robot.build();
		}
	}
}
