/**
 * 
 */
package csc5021.solutions;

import csc5021.interfaces.HasInvariant;
import csc5021.objects.Cube;
import csc5021.objects.Dictionary;
import csc5021.tests.SolutionAbstractsTest;
import csc5021.utilities.Utilities;

/**
 * {@link SolutionAbstracts} present an abstract of solution. <br>
 * Tested by {@link SolutionAbstractsTest}
 * 
 * @author luongnv89
 * 
 */
public abstract class SolutionAbstracts implements HasInvariant {

	/**
	 * Cube for checking associated
	 */
	protected Cube cube;
	/**
	 * Dictionary for checking associated
	 */
	protected Dictionary dic;

	/**
	 * Create new solution from input cube and dic
	 * 
	 * @param cube
	 * @param dic
	 */
	public SolutionAbstracts(Cube cube, Dictionary dic) {
		this.cube = cube;
		this.dic = dic;
	}

	/**
	 * Create new solution from input path of cube and input path of dictionary
	 * 
	 * @param cube
	 * @param dic
	 */
	public SolutionAbstracts(String cubePath, String dicPath) {
		this.cube = new Cube(cubePath);
		this.dic = new Dictionary(dicPath);
	}

	/**
	 * Checking the associated of the cube and the dictionary?
	 * 
	 * @param cube
	 * @param dic
	 * @return true if the cube associated with the dictionary <br>
	 *         false otherwise
	 */
	public abstract boolean checkAssociatedOfDictionary();

	/**
	 * Checking the associated of the cube with a word
	 * 
	 * @param cube
	 * @param word
	 * @return true if the cube is associated with the input word <br>
	 *         false otherwise
	 */
	public boolean checkAssociatedOfWord(String word) {

		boolean word_associated = false;

		if (!word_associated)
			word_associated = checkAssociatedOfWordOnOYZ(word);
		if (!word_associated)
			word_associated = checkAssociatedOfWordOnOXZ(word);
		if (!word_associated)
			word_associated = checkAssociatedOfWordOnOXY(word);
		// OCDK
		if (!word_associated)
			word_associated = checkAssociatedOfWordOnOCDK(word);
		// ABFE
		if (!word_associated)
			word_associated = checkAssociatedOfWordOnABFE(word);
		return word_associated;
	}

	/**
	 * The plane ABFE is created by 4 points: <li>A: (0,4,0) <li>B: (0,4,4) <li>
	 * F: (4,0,4) <li>E: (4,0,0) <br>
	 * Checking the associated of a word with the plane of cube which is
	 * parallel with the ABFE plane <br>
	 * 
	 * @param cube
	 * @param word
	 * @return true if there is existing a line of plane which content the word <br>
	 *         false otherwise
	 */
	public boolean checkAssociatedOfWordOnABFE(String word) {
		for (int deltaX = word.length() - 1; deltaX < cube.getSize(); deltaX++) {
			if (checkAssociatedOfWordOnABFE(0, deltaX, 0, deltaX, 0, 0, word))
				return true;
			if (deltaX < cube.getSize() - 1) {
				if (checkAssociatedOfWordOnABFE(cube.getSize() - 1 - deltaX, cube.getSize() - 1, 0, cube.getSize() - 1,
						cube.getSize() - 1 - deltaX, 0, word))
					return true;
			}
		}

		return false;
	}

	/**
	 * The plane ABFE is created by 4 points: <li>A: (0,4,0) <li>B: (0,4,4) <li>
	 * F: (4,0,4) <li>E: (4,0,0) <br>
	 * Checking the associated of a word with the plane of cube which is
	 * parallel with the ABFE plane <br>
	 * Only check the lines below: <li>The lines are in the plane which is
	 * parallel with the ABFE plane and they parallel with AF <li>The lines are
	 * in the plane which is parallel with the ABFE plane and they parallel with
	 * BE
	 * 
	 * @param x0
	 * @param y0
	 * @param z0
	 * @param x1
	 * @param y1
	 * @param z1
	 * @param cube
	 * @param word
	 * @return true if there is existing a line of plane which content the word <br>
	 *         false otherwise
	 */
	private boolean checkAssociatedOfWordOnABFE(int x0, int y0, int z0, int x1, int y1, int z1, String word) {
		int deltaX = Math.abs(x1 - x0);

		for (int deltaZ = word.length() - 1; deltaZ < deltaX; deltaZ++) {
			// AF
			if (checkAssociatedOfWordInLine(x0, y0, cube.getSize() - 1 - deltaZ, x0 + deltaZ, y0 - deltaZ,
					cube.getSize() - 1, word))
				return true;
			if (deltaZ < deltaX - 1) {
				if (checkAssociatedOfWordInLine(x1 - deltaZ, y1 + deltaZ, 0, x1, y1, deltaZ, word))
					return true;
			}

			// BE
			if (checkAssociatedOfWordInLine(x0, y0, deltaZ, x0 + deltaZ, y0 - deltaZ, 0, word))
				return true;
			if (deltaZ < deltaX - 1) {
				if (checkAssociatedOfWordInLine(x1 - deltaZ, y1 + deltaZ, cube.getSize() - 1, x1, y1, cube.getSize()
						- 1 - deltaZ, word))
					return true;
			}
		}

		for (int z = deltaX; z < cube.getSize(); z++) {
			// AF
			if (checkAssociatedOfWordInLine(x0, y0, z - deltaX, x1, y1, z, word))
				return true;
			// BE
			if (checkAssociatedOfWordInLine(x0, y0, z, x1, y1, z - deltaX, word))
				return true;
		}
		return false;
	}

	/**
	 * The plane OCDK is created by 4 points: <li>O: (0,0,0) <li>C: (4,4,0) <li>
	 * D: (4,4,4) <li>K: (0,0,4) <br>
	 * Checking the associated of a word with the plane of cube which is
	 * parallel with the OCDK plane <br>
	 * 
	 * @param cube
	 * @param word
	 * @return true if there is existing a line of plane which content the word <br>
	 *         false otherwise
	 */
	public boolean checkAssociatedOfWordOnOCDK(String word) {
		for (int deltaXY = word.length() - 1; deltaXY < cube.getSize(); deltaXY++) {
			if (checkAssociatedOfWordOnOCDK(cube.getSize() - 1 - deltaXY, 0, cube.getSize() - 1, deltaXY, word))
				return true;
			if (deltaXY < cube.getSize() - 1) {
				if (checkAssociatedOfWordOnOCDK(0, cube.getSize() - 1 - deltaXY, deltaXY, cube.getSize() - 1, word))
					return true;
			}
		}
		return false;
	}

	/**
	 * The plane OCDK is created by 4 points: <li>O: (0,0,0) <li>C: (4,4,0) <li>
	 * D: (4,4,4) <li>K: (0,0,4) <br>
	 * Checking the associated of a word with the plane of cube which is
	 * parallel with the OCDK plane <br>
	 * Only check the lines below: <li>The lines are in the plane which is
	 * parallel with the OCDK plane and they parallel with OD <li>The lines are
	 * in the plane which is parallel with the OCDK plane and they parallel with
	 * CK
	 * 
	 * @param x0
	 * @param y0
	 * @param x1
	 * @param y1
	 * @param cube
	 * @param word
	 * @return true if there is existing a line of plane which content the word <br>
	 *         false otherwise
	 */
	private boolean checkAssociatedOfWordOnOCDK(int x0, int y0, int x1, int y1, String word) {
		int deltaX = Math.abs(x1 - x0);
		for (int deltaZ = word.length() - 1; deltaZ < deltaX; deltaZ++) {
			// OD
			if (checkAssociatedOfWordInLine(x1 - deltaZ, y1 - deltaZ, 0, x1, y1, deltaZ, word))
				return true;
			if (deltaZ < deltaX - 1) {
				if (checkAssociatedOfWordInLine(x0, y0, cube.getSize() - 1 - deltaZ, x0 + deltaZ, y0 + deltaZ,
						cube.getSize() - 1, word))
					return true;
			}

			// CK
			if (checkAssociatedOfWordInLine(x0, y0, deltaZ, x0 + deltaZ, y0 + deltaZ, 0, word))
				return true;
			if (deltaZ < deltaX - 1) {
				if (checkAssociatedOfWordInLine(x1 - deltaZ, y1 - deltaZ, cube.getSize() - 1, x1, y1, cube.getSize()
						- 1 - deltaZ, word))
					return true;
			}
		}

		for (int z1 = deltaX; z1 < cube.getSize(); z1++) {
			// OD
			if (checkAssociatedOfWordInLine(x0, y0, z1 - deltaX, x1, y1, z1, word))
				return true;
			// CK
			if (checkAssociatedOfWordInLine(x0, y0, z1, x1, y1, z1 - deltaX, word))
				return true;
		}

		return false;
	}

	/**
	 * Checking the associated of a word with the plane of cube which is
	 * parallel with the OYZ plane <br>
	 * Only check the lines below: <li>The lines are in the plane which is
	 * parallel with the OYZ plane and they present by y = constant <li>The
	 * lines are in the plane which is parallel with the OYZ plane and they
	 * present by y-z=constant <li>The lines are in the plane which is parallel
	 * with the OYZ plane and they present by y+z=constant
	 * 
	 * @param cube
	 * @param word
	 * @return true if there is existing a line of plane which content the word <br>
	 *         false otherwise
	 */
	public boolean checkAssociatedOfWordOnOYZ(String word) {
		for (int x = 0; x < cube.getSize(); x++) {

			for (int y = 0; y < cube.getSize(); y++) {
				// The line in plane which is presented by y = constant
				if (checkAssociatedOfWordInLine(x, y, 0, x, y, cube.getSize() - 1, word))
					return true;
			}

			for (int deltaYZ = word.length() - 1; deltaYZ < cube.getSize(); deltaYZ++) {

				// The line in plane which is presented by y-z = constant;
				if (checkAssociatedOfWordInLine(x, cube.getSize() - 1 - deltaYZ, 0, x, cube.getSize() - 1, deltaYZ,
						word))
					return true;
				if (checkAssociatedOfWordInLine(x, 0, cube.getSize() - 1 - deltaYZ, x, deltaYZ, cube.getSize() - 1,
						word))
					return true;
				// The line in plane which is presented by x+z = constant;
				if (checkAssociatedOfWordInLine(x, 0, deltaYZ, x, deltaYZ, 0, word))
					return true;
				if (checkAssociatedOfWordInLine(x, cube.getSize() - 1 - deltaYZ, cube.getSize() - 1, x,
						cube.getSize() - 1, cube.getSize() - 1 - deltaYZ, word))
					return true;
			}

		}
		return false;
	}

	/**
	 * Checking the associated of a word with the plane of cube which is
	 * parallel with the OXZ plane <br>
	 * Only check the lines below: <li>The lines are in the plane which is
	 * parallel with the OXZ plane and they present by z = constant <li>The
	 * lines are in the plane which is parallel with the OXZ plane and they
	 * present by x-z=constant <li>The lines are in the plane which is parallel
	 * with the OXZ plane and they present by x+z=constant
	 * 
	 * @param cube
	 * @param word
	 * @return true if there is existing a line of plane which content the word <br>
	 *         false otherwise
	 */
	public boolean checkAssociatedOfWordOnOXZ(String word) {

		for (int y = 0; y < cube.getSize(); y++) {

			for (int z = 0; z < cube.getSize(); z++) {
				// The line in plane which is presented by z = constant;
				if (checkAssociatedOfWordInLine(0, y, z, cube.getSize() - 1, y, z, word))
					return true;
			}

			for (int deltaXZ = word.length() - 1; deltaXZ < cube.getSize(); deltaXZ++) {

				// The line in plane which is presented by x-z = constant;
				if (checkAssociatedOfWordInLine(cube.getSize() - 1 - deltaXZ, y, 0, cube.getSize() - 1, y, deltaXZ,
						word))
					return true;
				if (checkAssociatedOfWordInLine(0, y, cube.getSize() - 1 - deltaXZ, deltaXZ, y, cube.getSize() - 1,
						word))
					return true;
				// The line in plane which is presented by x+z = constant;
				if (checkAssociatedOfWordInLine(0, y, deltaXZ, deltaXZ, y, 0, word))
					return true;
				if (checkAssociatedOfWordInLine(cube.getSize() - 1 - deltaXZ, y, cube.getSize() - 1,
						cube.getSize() - 1, y, cube.getSize() - 1 - deltaXZ, word))
					return true;
			}

		}
		return false;
	}

	/**
	 * Checking the associated of a word with the plane of cube which is
	 * parallel with the OXY plane <br>
	 * Only check the lines below: <li>The lines are in the plane which is
	 * parallel with the OXY plane and they present by x = constant <li>The
	 * lines are in the plane which is parallel with the OXY plane and they
	 * present by x-y=constant <li>The lines are in the plane which is parallel
	 * with the OXY plane and they present by x+y=constant
	 * 
	 * @param cube
	 * @param word
	 * @return true if there is existing a line of plane which content the word <br>
	 *         false otherwise
	 */
	public boolean checkAssociatedOfWordOnOXY(String word) {
		for (int z = 0; z < cube.getSize(); z++) {
			for (int x = 0; x < cube.getSize(); x++) {
				// The line in plane which is presented by x=constant
				if (checkAssociatedOfWordInLine(x, 0, z, x, cube.getSize() - 1, z, word))
					return true;
			}

			for (int deltaX = word.length() - 1; deltaX < cube.getSize(); deltaX++) {
				// The line in plane which is presented by x-y = constant;
				if (checkAssociatedOfWordInLine(cube.getSize() - 1 - deltaX, 0, z, cube.getSize() - 1, deltaX, z, word))
					return true;
				if (checkAssociatedOfWordInLine(0, cube.getSize() - 1 - deltaX, z, deltaX, cube.getSize() - 1, z, word))
					return true;

				// The line in plane which is presented by x+y = constant;
				if (checkAssociatedOfWordInLine(0, deltaX, z, deltaX, 0, z, word))
					return true;
				if (checkAssociatedOfWordInLine(cube.getSize() - 1 - deltaX, cube.getSize() - 1, z, cube.getSize() - 1,
						cube.getSize() - 1 - deltaX, z, word))
					return true;
			}

		}
		return false;
	}

	/**
	 * Checking the associated of a word with a line from the point (x0,y0,z0)
	 * to the point (x1,y1,z1) of cube
	 * 
	 * @param x0
	 * @param y0
	 * @param z0
	 * @param x1
	 * @param y1
	 * @param z1
	 * @param cube
	 * @param word
	 * @return true if the string composed by the line (or its revert string )of
	 *         cube content the word <br>
	 *         false otherwise
	 */
	public boolean checkAssociatedOfWordInLine(int x0, int y0, int z0, int x1, int y1, int z1, String word) {
		if (x0 == x1 && y0 == y1 && z0 == z1)
			return false;
		String string1 = cube.getString(x0, y0, z0, x1, y1, z1);
		return string1.contains(word) || ((String) Utilities.revert(string1)).contains(word);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see csc5021.interfaces.HasInvariant#invariant()
	 */
	@Override
	public boolean invariant() {
		return dic.invariant() && cube.invariant() && (cube.getSize() >= dic.getLength());
	}

	/**
	 * @return the cube
	 */
	public Cube getCube() {
		return cube;
	}

	/**
	 * @return the dic
	 */
	public Dictionary getDic() {
		return dic;
	}

}
