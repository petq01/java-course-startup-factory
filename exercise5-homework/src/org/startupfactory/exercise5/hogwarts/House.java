/**
 * 
 */
package org.startupfactory.exercise5.hogwarts;

/**
 * @author Petq
 *
 */
public class House {
	private String HOUSE1 = "GRYFFINDOR";
	private String HOUSE2 = "RAVENCLAW";
	private String HOUSE3 = "SLYTHERIN ";
	private String HOUSE4 = "HUFFLEPUF";

	public String getHouse1() {
		return HOUSE1;
	}

	public String getHouse2() {
		return HOUSE2;
	}

	public String getHouse3() {
		return HOUSE3;
	}

	public String getHouse4() {
		return HOUSE4;
	}

	public House(final String HOUSE1, final String HOUSE2, final String HOUSE3, final String HOUSE4) {
		super();
		this.HOUSE1 = HOUSE1;
		this.HOUSE2 = HOUSE2;
		this.HOUSE3 = HOUSE3;
		this.HOUSE4 = HOUSE4;
	}

}
