/**
 * 
 */
package csc5021.programs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import csc5021.objects.Cube;
import csc5021.objects.Dictionary;
import csc5021.solutions.SolutionAbstracts;
import csc5021.utilities.Utilities;

/**
 * Generate the dataset for test <br>
 * For each size of cube in {@link DatasetGenerator#cubeSizes} generate a cube
 * with the input size and generate dictionaries by follow: <br>
 * for each size of dictionary in {@link DatasetGenerator#dictionarySizes} <br>
 * for each length of word in {@link DatasetGenerator#wordLengths} <br>
 * if(size of cube isnt smaller than the length of word) generate two new
 * dictionary: <br>
 * a dictionary associated with cube (by using the method
 * {@link DatasetGenerator#generateAssociatedDictionary(int, int, Cube)}) <br>
 * and a random dictionary. <br>
 * NOTES: As the result of tests, the random dictionary often is not associated
 * with cube, and the first word which cannot found in cube often has index 0 in
 * dictionary. This reason explain that why the executed time of sequential
 * solution often faster than the executed time of parallel solution in case the
 * dictionary is not associated with cube.
 * 
 * @author luongnv89
 * 
 */
public class DatasetGenerator {
	/**
	 * List possible size of cube. The size of cube is in range from 4 to 1000.
	 */
//	static int[] cubeSizes = { 4, 10, 50, 200, 500 };
	 static int[] cubeSizes = {800,1000};
	/**
	 * List possible size of dictionary. The size of dictionary is in range from
	 * 3 to 1000.
	 */
	static int[] dictionarySizes = { 3, 20, 100, 500, 800, 1000 };
	/**
	 * List possible length of word. The length of word is in range from 2 to
	 * 100.
	 */
	static int[] wordLengths = { 2, 10, 50, 80, 100 };

	// Path to save generated cube
	public static String CUBE_PATH = "data/cube";
	// Path to save generated dictionary which is associated with cube
	public static String DIC_ASSOCIATED_PATH = "data/dic_associated";
	// Path to save generated dictionary which is not associated with cube
	public static String DIC_NO_ASSOCIATED_PATH = "data/dic_noassociated";

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Generate dataset for test perfomance:\n");
		for (int cube_size = 0; cube_size < cubeSizes.length; cube_size++) {
			Cube c = new Cube(cubeSizes[cube_size]);
			c.saveToFile(CUBE_PATH + "/cube_" + cubeSizes[cube_size]);
			System.out.println("Create new cube: " + "cube_" + cubeSizes[cube_size]);
			for (int dic_size = 0; dic_size < dictionarySizes.length; dic_size++) {
				for (int word_length = 0; word_length < wordLengths.length; word_length++) {
					if (wordLengths[word_length] <= cubeSizes[cube_size]) {
						Dictionary associated = generateAssociatedDictionary(wordLengths[word_length],
								dictionarySizes[dic_size], c);
						associated.saveToFile(DIC_ASSOCIATED_PATH + "/dic_associated_c_" + cubeSizes[cube_size] + "_l_"
								+ wordLengths[word_length] + "_s_" + dictionarySizes[dic_size]);
						System.out.println("Create new Dictionary: " + "dic_associated_c_" + cubeSizes[cube_size]
								+ "_l_" + wordLengths[word_length] + "_s_" + dictionarySizes[dic_size]);
						Dictionary noassociated = new Dictionary(wordLengths[word_length], dictionarySizes[dic_size]);
						noassociated.saveToFile(DIC_NO_ASSOCIATED_PATH + "/dic_noassociated_c_" + cubeSizes[cube_size]
								+ "_l_" + wordLengths[word_length] + "_s_" + dictionarySizes[dic_size]);
						System.out.println("Create new Dictionary: " + "dic_noassociated_c_" + cubeSizes[cube_size]
								+ "_l_" + wordLengths[word_length] + "_s_" + dictionarySizes[dic_size]);
					}
				}
			} 
		}
		System.out.println("FINISHED!");
	}

	/**
	 * Generate an associated dictionary of the input cube. <br>
	 * The word of dictionary can be in any plane of cube <br>
	 * HOW TO GENERATE: <br>
	 * Each word is created by a string which composed from two positions in
	 * cube, and the distance between two positions equal the length of word. <br>
	 * Generate each word of dictionary by following steps: <br>
	 * <li>Randomly the changed coordinates. There are at least one coordinate
	 * must change (ox, oy or oz). <li>Generate randomly the first position. <br>
	 * Each changed coordinate value is generated with the range from 0 to (the
	 * size of cube - length of word). <br>
	 * Each unchanged coordinate value is generate with the range from 0 to the
	 * size of cube. <li>The second position will get from the first position
	 * and move (follow by the changed coordinates) a distance equal the length
	 * of word. <li>Get the string between two positions we have an associated
	 * word of cube.
	 * 
	 * @param wordL
	 *            the word length of dictionary
	 * @param size
	 *            the maximum size of dictionary. The size of generated
	 *            dictionary can be smaller than input size
	 * @param cube
	 *            the cube which the associated dictionary will be generated
	 *            from
	 * @return an associated dictionary of cube
	 * @throws Exception
	 */
	public static Dictionary generateAssociatedDictionary(int wordL, int size, Cube cube) throws Exception {
		if (!cube.invariant()) {
			throw new Exception("The input cube is not valid!");
		}
		if (wordL < Dictionary.MIN_LENGTH || wordL > Dictionary.MAX_LENGTH) {
			throw new Exception("The input word length of dictionary is not valid! " + wordL);
		}
		if (size < Dictionary.MIN_SIZE || size > Dictionary.MAX_SIZE) {
			throw new Exception("The input size of dictionary is not valid! " + size);
		}

		int wordLength = wordL - 1;
		ArrayList<String> listWords = new ArrayList<>();
		int count = 0;
		while (listWords.size() < size && count < 10) {
			count++;
			Random ran = new Random();

			int dx = ran.nextInt(2);
			int dy = ran.nextInt(2);
			int dz = ran.nextInt(2);

			// At least one coordinate is change
			while (dx + dy + dz == 0) {
				dx = ran.nextInt(2);
				dy = ran.nextInt(2);
				dz = ran.nextInt(2);
			}

			// Get first position randomly
			int y = ran.nextInt(cube.getSize() - dy * wordLength);
			int z = ran.nextInt(cube.getSize() - dz * wordLength);
			int x = ran.nextInt(cube.getSize() - dx * wordLength);

			// Get the string from first position and move a length equal
			// wordLength
			String word = cube.getString(x, y, z, x + dx * wordLength, y + dy * wordLength, z + dz * wordLength);
			if (!listWords.contains(word)) {
				listWords.add(word);
				count = 0;
			}
		}
		Dictionary myDictionary = new Dictionary(listWords);
		System.out.println("Create new dictionary: Length: " + myDictionary.getLength() + "; Size: "
				+ myDictionary.getSize());
		return myDictionary;
	}
}
