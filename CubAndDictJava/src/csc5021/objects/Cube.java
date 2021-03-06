/**
 * 
 */
package csc5021.objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import csc5021.interfaces.HasInvariant;
import csc5021.tests.CubeTest;
import csc5021.utilities.Utilities;

/**
 * The {@link Cube} present the common structure of alien genetic material <br>
 * The content of cube is present by the 3d array {@link Cube#values}. <br>
 * Tested by {@link CubeTest}
 * 
 * @author luongnv89
 * 
 */
public class Cube implements HasInvariant {

	/**
	 * Maximum size of cube
	 */
	public static final int MAX_SIZE = 1000;
	/**
	 * Minimum size of cube
	 */
	public static final int MIN_SIZE = 4;
	/**
	 * Maximum number of different letters on a lattice of cube
	 */
	private static final int MAX_DIFF_LETTERS = 100;

	/**
	 * Size of cube
	 */
	int size;
	/**
	 * content of cube
	 */
	char[][][] values;

	/**
	 * Construct randomly a cube with the size of cube is input
	 * 
	 * @param size
	 * @throws Exception
	 */
	public Cube(int size) throws Exception {
		if (size < MIN_SIZE || size > MAX_SIZE) {
			throw new Exception("The size of cube is invalid: " + size
					+ "\nIt must be bigger than 3 and smaller than 1001");
		} else {
			this.size = size;
		}
		values = new char[this.size][this.size][this.size];
		initRandomly();
	}

	/**
	 * Construct a cube from input file.
	 * 
	 * @param pathFile
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public Cube(String pathFile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(pathFile));
			String line = br.readLine();
			this.size = line.length();
			values = new char[this.size][this.size][this.size];
			// for each lattice
			for (int z = 0; z < this.size; z++) {
				// for each row of lattice
				for (int y = 0; y < this.size; y++) {
					char[] array = line.toCharArray();
					for (int x = 0; x < this.size; x++) {
						values[x][y][z] = array[x];
					}
					line = br.readLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see csc5021.interfaces.HasInvariant#invariant()
	 * 
	 * @return <br> false if the size of cube is invalid <br> false if there are
	 * some lattice has less than 2 different letters or more than 100 different
	 * letters
	 */
	@Override
	public boolean invariant() {
		if (this.size < MIN_SIZE || this.size > MAX_SIZE) {
			System.out.println("The size of cube is invalid");
			return false;
		}

		// Check the number of different letters in a lattice and check the
		// validation of each letter in cube
		if (!checkNumberOfLetters(1))
			return false;
		if (!checkNumberOfLetters(2))
			return false;
		if (!checkNumberOfLetters(3))
			return false;

		return true;
	}

	/**
	 * Check the number of different letters in a lattice.
	 * 
	 * @param direction
	 * <br>
	 *            1 - check for the lattices which parallel with OXY <br>
	 *            2 - check for the lattices which parallel with OYZ <br>
	 *            3 - check for the lattices which parallel with OXZ
	 * @return true if the lattice has the number of different letters which is
	 *         bigger than 2 and smaller than 101. <br>
	 *         false otherwise
	 */
	private boolean checkNumberOfLetters(int direction) {
		for (int a = 0; a < this.size; a++) {
			int nbLetters = 0;
			ArrayList<Character> listCharacter = new ArrayList<>();
			for (int b = 0; b < this.size; b++) {
				for (int c = 0; c < this.size; c++) {
					char ch = 0;
					switch (direction) {
					case 1:
						ch = values[c][b][a];
						break;
					case 2:
						ch = values[a][c][b];
						break;
					case 3:
						ch = values[b][a][c];
						break;

					default:
						System.out.println("Error input direction!");
						break;
					}
					if (!Utilities.validCharacter(ch)) {
						System.out.println("There is an invalid character in cube: " + ch);
						return false;
					}
					if (!listCharacter.contains(ch)) {
						nbLetters++;
						listCharacter.add(ch);
					}
				}
			}
			if (nbLetters < 2 || nbLetters > 100) {
				System.out
						.println("Invalid cube! There are " + nbLetters + " different letters in lattice of x : " + a);
				return false;
			}
		}
		return true;
	}

	/**
	 * Save the value of cube to a file
	 * 
	 * @param pathFile
	 * 
	 */
	public void saveToFile(String pathFile) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(pathFile));
			for (int i = 0; i < this.size; i++) {
				for (int j = 0; j < this.size; j++) {
					for (int k = 0; k < this.size; k++) {
						out.write(values[i][j][k]);
					}
					out.write("\n");
				}
			}
			out.close();
		} catch (IOException e) {
		}
	}

	/**
	 * Create randomly values for cube with check the number of different
	 * letters in the lattices which is parallel with OYZ
	 */
	private void initRandomly() {
		for (int i = 0; i < this.size; i++) {
			ArrayList<Character> listLetters = new ArrayList<>();
			for (int j = 0; j < this.size; j++) {
				for (int k = 0; k < this.size; k++) {
					boolean char_ok = false;
					while (!char_ok) {
						char newChar = Utilities.getRandomCharater();
						if (!listLetters.contains(newChar)) {
							if (listLetters.size() < MAX_DIFF_LETTERS) {
								listLetters.add(newChar);
								char_ok = true;
								values[i][j][k] = newChar;
							}
						} else {
							char_ok = true;
							values[i][j][k] = newChar;
						}
					}

				}
			}
		}
	}

	/**
	 * 
	 * Get string is composed by the characters from the point (x0,y0,z0) to the
	 * point (x1,y1,z1) of cube <br>
	 * In this case, we assume that two points are always in a line of cube
	 * 
	 * @param x0
	 * @param y0
	 * @param z0
	 * @param x1
	 * @param y1
	 * @param z1
	 * @param wordLength
	 * @return
	 */
	public String getString(int x0, int y0, int z0, int x1, int y1, int z1) {
		int delta = Math.max(Math.abs(x1 - x0), Math.abs(y1 - y0));
		delta = Math.max(Math.abs(z1 - z0), delta);
		if (delta == 0)
			return String.valueOf(values[x0][y0][z0]);
		int dx = (x1 - x0) / delta;
		int dy = (y1 - y0) / delta;
		int dz = (z1 - z0) / delta;
 
		StringBuffer stringbf = new StringBuffer();
		for (int i = 0; i <= delta; i++) {
			stringbf.append(values[x0 + dx * i][y0 + dy * i][z0 + dz * i]);
		}
		return stringbf.toString();

		// if (x0 == x1 && y0 == y1 && z0 == z1)
		// return String.valueOf(values[x0][y0][z0]);
		// StringBuffer stringbf = new StringBuffer();
		// if (x0 == x1) {
		// if (y0 == y1) {
		// int max = z1 > z0 ? z1 : z0;
		// int min = max == z1 ? z0 : z1;
		//
		// for (int i = 0; i <= max - min; i++) {
		// stringbf.append(values[x0][y0][min + i]);
		// }
		// } else if (z0 == z1) {
		// int max = y1 > y0 ? y1 : y0;
		// int min = y1 == max ? y0 : y1;
		//
		// for (int i = 0; i <= max - min; i++) {
		// stringbf.append(values[x0][min + i][z0]);
		// }
		// } else {
		// int max = y1 > y0 ? y1 : y0;
		// int min = y1 == max ? y0 : y1;
		// for (int i = 0; i <= max - min; i++) {
		// stringbf.append(values[x0][min + i][z0 + (z1 - z0) * (min + i - y0) /
		// (y1 - y0)]);
		// }
		// }
		// } else {
		// int max = x1 > x0 ? x1 : x0;
		// int min = x1 == max ? x0 : x1;
		// if (y0 == y1) {
		// if (z0 == z1) {
		// for (int i = 0; i <= max - min; i++) {
		// stringbf.append(values[min + i][y0][z0]);
		//
		// }
		// } else {
		// for (int i = 0; i <= max - min; i++) {
		// stringbf.append(values[min + i][y0][z0 + (z1 - z0) * (min + i - x0) /
		// (x1 - x0)]);
		//
		// }
		// }
		// } else {
		// if (z0 == z1) {
		// for (int i = 0; i <= max - min; i++) {
		// stringbf.append(values[min + i][y0 + (y1 - y0) * (min + i - x0) / (x1
		// - x0)][z0]);
		//
		// }
		// } else {
		// for (int i = 0; i <= max - min; i++) {
		// stringbf.append(values[min + i][y0 + (y1 - y0) * (min + i - x0) / (x1
		// - x0)][z0 + (z1 - z0)
		// * (min + i - x0) / (x1 - x0)]);
		// }
		// }
		// }
		// }
		// return stringbf.toString();
	}

	/**
	 * @return the size of cube
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return the values of cube
	 */
	public char[][][] getValues() {
		return values;
	}

}
