/**
 * 
 */
package csc5021.utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import csc5021.tests.UtilitiesTest;

/**
 * {@link Utilities} contain some method useful for program
 * <br>The test for {@link Utilities} is {@link UtilitiesTest}
 * @author luongnv89
 * 
 */
public class Utilities {

	/**
	 * Get randomly a char value from A-Z
	 * 
	 * @return
	 */
	public static char getRandomCharater() {
		int index = (new Random()).nextInt(25) + 65;
		return Character.toChars(index)[0];
	}

	/**
	 * Check a word is composed by the character from A-Z
	 * 
	 * @param word
	 * @return true if all the character of word is in A-Z <br>
	 *         false otherwise
	 */
	public static boolean validWord(String word) {
		char[] array = word.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (!validCharacter(array[i]))
				return false;
		}
		return true;
	}

	/**
	 * Check validation of a letter
	 * 
	 * @param c
	 * @return true if the letter is in alpha beta table <br>
	 *         false if otherwise
	 */
	public static boolean validCharacter(char c) {
		if ((int) c < 65 || (int) c > 90) {
			return false;
		}
		return true;
	}

	/**
	 * Create new word with the input length and the values is randomly
	 * 
	 * @param lengthOfWord
	 * @return
	 */
	public static String createNewWord(int lengthOfWord) {
		String str = "";
		for (int i = 0; i < lengthOfWord; i++) {
			str += getRandomCharater();
		}
		return str;
	}

	/**
	 * Revert a string
	 * 
	 * @param string1
	 * @return the revert of input string
	 */
	public static String revert(String string1) {
		StringBuffer str = new StringBuffer();
		char[] array = string1.toCharArray();
		for (int i = 0; i < array.length; i++) {
			str.append(array[array.length - i - 1]);
		}
		return str.toString();
	}

	/**
	 * Record the result test to output file
	 * 
	 * @param solutionName
	 * @param cubeSize
	 * @param wordLength
	 * @param dicSize
	 * @param result
	 * @param totalTime
	 * @param resultfile
	 */
	public static void recordTest(String solutionName, int cubeSize, int wordLength, int dicSize, boolean result,
			String totalTime, String resultfile) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(resultfile, true));
			out.write("[" + solutionName + ";" + cubeSize + ";" + wordLength + ";" + dicSize + ";"
					+ String.valueOf(result) + ";" + totalTime + "]\n");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Generate a cube file with all the value is A
	 * 
	 * @param size
	 * @param pathFile
	 */
	public static void invalidLattices(int size, String pathFile) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(pathFile, false));

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					for (int k = 0; k < size; k++) {
						out.write('A');
					}
					out.write("\n");
				}
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
