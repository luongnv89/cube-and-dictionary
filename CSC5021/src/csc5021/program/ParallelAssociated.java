/**
 * 
 */
package csc5021.program;

import csc5021.objects.Cube;
import csc5021.objects.Dictionary;

/**
 * Present the parallel program which is checking the associated of a cube and a
 * dictionary
 * 
 * @author luongnv89
 * 
 */
public class ParallelAssociated extends AssociatedAbstract {

	public boolean associated;

	@Override
	public boolean associated(final Cube cube, final Dictionary dic) {
		if (!dic.invariant() || !cube.invariant()) {
			// System.out.println("The input is not valid!");
			return false;
		} else if (dic.getLength() > cube.getSize()) {
			// System.out
			// .println("The cube is not associated with the dictionary!\nThe size of cube and the length of word of dictionary are not the same");
			return false;
		} else {
			// Parallel
			for (int i = 0; i < dic.getSize(); i++) {
				final int word_index = i;
				new Thread(new Runnable() {

					@Override
					public void run() {
						if (!associated_word(cube, dic.getWordByIndex(word_index))) {
							// System.out.println("There is a word not associated: "
							// + dic.getWordByIndex(word_index));
							associated = false;
						}

					}
				}).start();
				if (!associated) {
					System.out.println("The cube is not associated with the dictionary!");
					break;
				}
			}
			// if (associated)
			// System.out.println("The cube is associated with the dictionary!");
			return associated;
		}
	}
}