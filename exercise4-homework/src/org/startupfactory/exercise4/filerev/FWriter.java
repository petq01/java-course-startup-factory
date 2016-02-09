package org.startupfactory.exercise4.filerev;


import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FWriter {
	private FWriter() {
	}

	

	/**
	 * Writes the given input to a file. If the file doesn't exist it's first created.
	 * 
	 * @throws IOException
	 *             if there is an I/O exception
	 * @param path
	 *            the path to the file
	 * @param input
	 *            the user input
	 */
	public static void writeFile(String input, Path path) throws IOException {
		try (BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(path,
				StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
			out.write(input.getBytes());
		}
	}
}
