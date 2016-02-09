package org.startupfactory.javacourse.designpatters.mvc;

/**
 * visualization of the data that model contains
 * 
 * @author Petq
 *
 */
public class StudentView {
	public void printStrudentDetails(String studentName, String studentRollNo) {
		System.out.println("Student");
		System.out.println("Name: " + studentName);
		System.out.println("Roll no" + studentRollNo);
	}
}
