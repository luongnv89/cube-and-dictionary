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
 * Generate the dataset for test
 * 
 * @author luongnv89
 * 
 */
public class DatasetGenerator {
	// List possible size of cube
	static int[] sizeOfCube = { 4, 10, 50, 200, 500 };
	// static int[] sizeOfCube = {800,1000};
	// List possible size of dic
	static int[] sizeOfDic = { 3, 20, 100, 500, 800, 1000 };
	// List possible length of word
	static int[] lengOfDic = { 2, 10, 50, 80, 100 };

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
		for (int cube_size = 0; cube_size < sizeOfCube.length; cube_size++) {
			Cube c = new Cube(sizeOfCube[cube_size]);
			c.saveToFile(CUBE_PATH + "/cube_" + sizeOfCube[cube_size]);
			System.out.println("Create new Dictionary: " + "cube_" + sizeOfCube[cube_size]);
			for (int dic_size = 0; dic_size < sizeOfDic.length; dic_size++) {
				for (int word_length = 0; word_length < lengOfDic.length; word_length++) {
					if (lengOfDic[word_length] <= sizeOfCube[cube_size]) {
						Dictionary associated = generateAssociatedDictionary(lengOfDic[word_length],
								sizeOfDic[dic_size], c);
						associated.saveToFile(DIC_ASSOCIATED_PATH + "/dic_associated_c_" + sizeOfCube[cube_size]
								+ "_l_" + lengOfDic[word_length] + "_s_" + sizeOfDic[dic_size]);
						System.out.println("Create new Dictionary: " + "dic_associated_c_" + sizeOfCube[cube_size]
								+ "_l_" + lengOfDic[word_length] + "_s_" + sizeOfDic[dic_size]);
						Dictionary noassociated = new Dictionary(lengOfDic[word_length], sizeOfDic[dic_size]);
						noassociated.saveToFile(DIC_NO_ASSOCIATED_PATH + "/dic_noassociated_c_" + sizeOfCube[cube_size]
								+ "_l_" + lengOfDic[word_length] + "_s_" + sizeOfDic[dic_size]);
						System.out.println("Create new Dictionary: " + "dic_noassociated_c_" + sizeOfCube[cube_size]
								+ "_l_" + lengOfDic[word_length] + "_s_" + sizeOfDic[dic_size]);
					}
				}
			}
		}
		System.out.println("FINISHED!");
	}

	/**
	 * Generate an associated dictionary of the input cube
	 * 
	 * @param wordL
	 * @param size
	 * @param cube
	 * @return
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
		System.out.println("Create new dictionary: Length: " + myDictionary.getLength()+"; Size: " + myDictionary.getSize());
		return myDictionary;
	}
}
