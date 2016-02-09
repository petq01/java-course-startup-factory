package org.startupfactory.javacourse.designpatters.mvc;

/**
 * Model *update controller if its data changes
 * 
 * @author Petq
 *
 */
public class Student {
	private String rollNo;
	private String name;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
