package org.startupfactory.exercise5.hogwarts;

import static org.junit.Assert.*;

import java.io.File;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class WizzardSerializerTest {
	private static final House HOUSE = new House("GRYFFINDOR","RAVENCLAW","SLYTHERIN ","HUFFLEPUF");
	private static final WizzardingStudent STUDENT = new WizzardingStudent("happy potter",24,HOUSE);
	private static final String FILE_PATH = STUDENT+" - " +UUID.randomUUID() +".ser";

	
	
	@Test
	public void testCreateSerialized() {
		
		WizzardSerializer.writeWizzard(STUDENT,FILE_PATH );
		// File file = new File(FILE_PATH);
		// Assert.assertTrue(file.exists());
		//System.out.println("Serialized file created");
	}
	@Test

	public void testDeseriliazable() {
		WizzardingStudent wizCopy = WizzardSerializer.loadWizzard(FILE_PATH);
		Assert.assertEquals(STUDENT.toString(), wizCopy.toString());

		System.out.println(STUDENT);
		System.out.println(wizCopy);
	}
	
}
