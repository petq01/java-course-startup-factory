package org.startupfactory.exercise3.arrayelem;
import java.util.ArrayList;

public class ArrayElements {
	private Object[] arrList;
private int currentObject;

/**
 * Method to add an element to the list.
 * 
 * @param obj
 *            the element to add.
 * @return true if the element was added.
 */
public boolean addElement(Object obj) {
	try {
		arrList[currentObject] = obj;
		currentObject++;
	} catch (Exception e) {
		throw new IndexOutOfBoundsException("Index was out of bounds");
	}
	return true;
}

/**
 * Remove the last element in the list.
 * 
 * @return true if an element was removed
 * @throws EmptyListException 
 */
public boolean remove() throws EmptyListException {
	if (currentObject == 0) {
		throw new EmptyListException("There were no elements to remove.");
	}
	arrList[currentObject] = null;
	currentObject--;
	return true;
}

/**
 * Print all the elements of the list.
 */
public void printAllElements() {
	for (int i = 0; i < currentObject; i++) {
		System.out.println(arrList[i]);
	}
}
}
