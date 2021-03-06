/**
 * 
 */
package csc5021.solutions;

import java.util.ArrayList;

import csc5021.objects.Cube;
import csc5021.objects.Dictionary;
import csc5021.tests.ParallelTest;

/**
 * Present the parallel program which is checking the associated of a cube and a
 * dictionary <br>
 * Tested by {@link ParallelTest}
 * <br>The program is going to check the associated for each word of dictionary. For each word, the program will created a child thread to check for that word.
 * <br>At one moment, there is maximum {@link Parallel#MAX_THREADS} number of threads are running.
 * <br>If any thread found some word which is not associated with the cube, the variable {@link Parallel#associated} will be changed, and won't have any new thread created.
 * 
 * 
 * @author luongnv89
 * 
 */
public class Parallel extends SolutionAbstracts {
	/**
	 * Maximum number of threads which are running parallel
	 */
	private static final int MAX_THREADS = 50;
	/**
	 * The value of associated of cube and dictionary
	 */
	private boolean associated = true;
	/**
	 * Starting time
	 */
	private long startTime = System.currentTimeMillis();
	/**
	 * List all currently running threads
	 */
	private ArrayList<Thread> listThreads;

	public Parallel(Cube cube, Dictionary dic) {
		super(cube, dic);
		listThreads = new ArrayList<Thread>();
	}

	/**
	 * @param cubePath
	 * @param dicPath
	 * @throws Exception
	 */
	public Parallel(String cubePath, String dicPath) throws Exception {
		super(cubePath, dicPath);
		listThreads = new ArrayList<Thread>();
	}

	@Override
	public boolean checkAssociatedOfDictionary() {

		if (!invariant()) {
			return false;
		} else {
			// Parallel
			for (int i = 0; i < dic.getSize(); i++) {
				// Check if the associated variable hasn't changed yet.
				if (associated) {

					final int word_index = i;
					// Create new thread to checking the associated for current
					// word of dictionary
					Thread word_thread = new Thread(new Runnable() {
						@Override
						public void run() {

							System.out.println("Thread " + word_index + " started...");

							if (!checkAssociatedOfWord(dic.getWordByIndex(word_index))) {
								// Found a word which is not associated with the
								// dictionary.
								System.out.println("There is a word not associated: " + dic.getWordByIndex(word_index)
										+ "\nStop at thread: " + word_index + " at time: "
										+ String.valueOf(System.currentTimeMillis() - startTime));
								// Change the value of associated variable
								associated = false;
								System.out.println("Interupt all alive threds....");
								// Interupt all other threads
								for (int t = 0; t < listThreads.size(); t++) {
									if (listThreads.get(t).isAlive())
										listThreads.get(t).interrupt();
								}
							}
							System.out.println("Thread " + word_index + " stoped!!!");

						}
					});
					listThreads.add(word_thread);
					listThreads.get(listThreads.size() - 1).start();

					// Waiting until there is some free slot for new thread in
					// list threads
					while (!moveToNextWord() && associated) {
						System.out.println("Waiting for other thread finished!");
					}

				}
			}

			// Waiting until all threads finished
			while (isThereAliveThreads()) {
				System.out.println("Waiting for all thread finished!");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
		return associated;
	}

	/**
	 * Check if all the child threads are dead!
	 * 
	 * @return false if there is any thread still alive <br>
	 *         true otherwise
	 */
	private boolean isThereAliveThreads() {
		removeFinishThread();
		System.out.println("Number of alive threads: " + listThreads.size());
		if (listThreads.size() > 0)
			return true;
		return false;
	}

	/**
	 * Check if can create new thread
	 * 
	 * @return true if there are some slot for new thread <br>
	 *         false if there are {@link Parallel#MAX_THREADS} threads still
	 *         running.
	 */
	private boolean moveToNextWord() {
		removeFinishThread();
		if (listThreads.size() < MAX_THREADS)
			return true;
		return false;
	}

	/**
	 * Remove all finished thread from list threads to free some slot for other
	 * threads
	 */
	private void removeFinishThread() {
		for (int i = 0; i < listThreads.size(); i++) {
			if (!listThreads.get(i).isAlive())
				listThreads.remove(i);
		}
	}
}
