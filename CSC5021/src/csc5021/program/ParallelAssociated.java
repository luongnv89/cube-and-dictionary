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

	private static volatile boolean associated = true;

	@SuppressWarnings("unused")
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
			final Thread[] listThread = new Thread[dic.getSize()];
			for (int i = 0; i < dic.getSize(); i++) {
				final int word_index = i;
				// System.out.println("Word number: " + word_index);
				listThread[word_index] = new Thread(new Runnable() {
					@Override
					public void run() {
						System.out.println("Thread " + word_index + " started...");
						if (!associated_word(cube, dic.getWordByIndex(word_index))) {
							System.out.println("There is a word not associated: " + dic.getWordByIndex(word_index)
									+ "\nStop at thread: " + word_index + " at time: " + System.currentTimeMillis());
							associated = false;
						}

					}
				});
				listThread[word_index].start();
			}
			boolean stop = false;
			while (!stop) {
				if (!associated) {
					System.out.println("Found associated changed");
					stop = true;
					for (int i = 0; i < listThread.length; i++) {
						if (listThread[i].isAlive()) {
							System.out.println("Interupt thread: " + i);
							listThread[i].suspend();
						}
						else{
							System.out.println("Thread number: " + i + " already dead");
						}
					}
				} else {
					boolean atLeastOneThreadIsRunning = false;
					for (int i = 0; i < listThread.length; i++) {
						if (listThread[i].isAlive()) {
							atLeastOneThreadIsRunning = true;
							break;
						}
					}
					if (!atLeastOneThreadIsRunning) {
						System.out.println("All the threads were dead");
						stop = true;
					}
				}
			}

		}
		// if (associated)
		// System.out.println("The cube is associated with the dictionary!");
		return associated;
	}
}
