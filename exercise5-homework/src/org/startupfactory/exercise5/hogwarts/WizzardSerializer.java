/**
 * 
 */
package org.startupfactory.exercise5.hogwarts;

import java.io.File;
import java.io.*;
import java.io.ObjectOutputStream;

/**
 * @author Petq
 *
 */
public class WizzardSerializer {
	 public static void writeWizzard(WizzardingStudent student,String filepath) {
		 ObjectOutputStream out = null;

		 try {
				File file = new File(filepath);
				out = new ObjectOutputStream(new FileOutputStream(file));
				out.writeObject(student);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	 
	 public static WizzardingStudent loadWizzard(String filePath) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
				Object student = ois.readObject();
				return (WizzardingStudent) student;

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	 
}
