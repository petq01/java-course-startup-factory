package org.startupfactory.exercise4.filerev;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class, containing a method for reading a file and a method for reversing the
 * file.
 * 
 */
public class FileReverser {

	public static String reverseFile(Path path) throws FileNotFoundException {
		StringBuffer toBeReversed = new StringBuffer();
		if (Files.notExists(path, LinkOption.NOFOLLOW_LINKS)) {
			throw new FileNotFoundException("File was not found");
		}
		try (BufferedReader reader = new BufferedReader(Files.newBufferedReader(path, Charset.defaultCharset()))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				toBeReversed.append(line);
				toBeReversed.append("\n");
			}
			Files.delete(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String reversed = toBeReversed.reverse().toString();
		try {
			FWriter.writeFile(reversed, path);
		} catch (IOException e) {
			throw new RuntimeException("Failed to save the file", e);
		}
		return reversed;
	}

	public static void main(String[] args) {
		
		Path absolutePath1 = Paths.get("D:/Documents/Desktop/homework-startup-factory/exercise4-homework/src/org/startupfactory/exercise4/filerev", "test.txt");
		try {
			FileReverser.reverseFile(absolutePath1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}