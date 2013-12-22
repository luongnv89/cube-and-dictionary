/**
 * 
 */
package csc5021.solutions;

import csc5021.objects.Cube;
import csc5021.objects.Dictionary;
import csc5021.tests.SequentialTest;

/**
 * Present a sequences program which can check the associated of a cube and a
 * dictionary <br>
 * Tested by {@link SequentialTest}
 * 
 * @author luongnv89
 * 
 */
public class Sequential extends SolutionAbstracts {

	public Sequential(Cube cube, Dictionary dic) {
		super(cube, dic);
	}

	/**
	 * @param cubePath
	 * @param dicPath
	 * @throws Exception
	 */
	public Sequential(String cubePath, String dicPath) throws Exception {
		super(cubePath, dicPath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see csc5021.solutions.SolutionAbstracts#checkAssociatedOfDictionary()
	 */
	@Override
	public boolean checkAssociatedOfDictionary() {
		if (!invariant()) {
			return false;
		} else {
			for (int i = 0; i < dic.getSize(); i++) {
				if (!checkAssociatedOfWord(dic.getWordByIndex(i))) {
					System.out.println("The cube is not associated with the dictionary!\nThe word index: " + i
							+ "\nThere is a word not associated: " + dic.getWordByIndex(i));
					return false;
				}
			}
		}
		return true;
	}

}
