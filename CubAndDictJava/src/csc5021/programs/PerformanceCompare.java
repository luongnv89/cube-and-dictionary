/**
 * 
 */
package csc5021.programs;

import csc5021.objects.Cube;
import csc5021.objects.Dictionary;
import csc5021.solutions.Parallel;
import csc5021.solutions.Sequential;
import csc5021.solutions.SolutionAbstracts;
import csc5021.utilities.Utilities;

/**
 * @author luongnv89
 * 
 */
public class PerformanceCompare {
	// List possible size of cube
//	static int[] cube = { 4, 10, 50, 200, 500 };
	static int[] cube = {800,1000};
	// List possible size of dic
	static int[] dic = { 3, 20, 100, 500};
	// List possible length of word
	static int[] word = { 2, 10, 50, 80, 100 };
	
//	// List possible size of cube
//		static int[] cube = { 4, 10, 50, 200, 500 };
//		// static int[] sizeOfCube = {800,1000};
//		// List possible size of dic
//		static int[] dic = { 3, 20, 100, 500, 800, 1000 };
//		// List possible length of word
//		static int[] word = { 2, 10, 50, 80, 100 };

	// Path to save generated cube
	public static String CUBE_PATH = "data/cube";
	// Path to save generated dictionary which is associated with cube
	public static String DIC_ASSOCIATED_PATH = "data/dic_associated";
	// Path to save generated dictionary which is not associated with cube
	public static String DIC_NO_ASSOCIATED_PATH = "data/dic_noassociated";

	private static final String resultFile = "result.txt";

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Start testing......");
		for (int c = 0; c < cube.length; c++) {
			final String cubePath = CUBE_PATH + "/cube_" + cube[c];
			for (int d = 0; d < dic.length; d++) {
				for (int w = 0; w < word.length; w++) {
					if (cube[c] >= word[w]) {
						final String dicAssociatedPath = DIC_ASSOCIATED_PATH + "/dic_associated_c_" + cube[c] + "_l_"
								+ word[w] + "_s_" + dic[d];
						final String dicNoAssociatedPath = DIC_NO_ASSOCIATED_PATH + "/dic_noassociated_c_" + cube[c]
								+ "_l_" + word[w] + "_s_" + dic[d];

						runtest(cubePath, dicAssociatedPath); 
						runtest(cubePath, dicNoAssociatedPath);
					}
				}

			}
		}

		System.out.println("FINISHED!!");
		System.exit(0);

	}

	private static void runtest(final String cubePath, final String dicPath) throws Exception {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Seting up the testing environment....");
				long start = System.currentTimeMillis();
				Cube cube = null;
				try {
					cube = new Cube(cubePath);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Dictionary dic = null;
				try {
					dic = new Dictionary(dicPath);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long setupTime = System.currentTimeMillis() - start;
				System.out.println("The setup time: " + String.valueOf(setupTime) + " ms");

				Sequential seq = new Sequential(cube, dic);
				runtest(seq);
				Parallel par = new Parallel(cube, dic);
				runtest(par);
			}
		});
		thread.start();
		thread.join();
	}

	private static void runtest(SolutionAbstracts program) {
		boolean associated;
		long startTime = System.currentTimeMillis();
		String solutionName = "UNKNOWN SOLUTION!";
		if (program instanceof Sequential)
			solutionName = "SEQ";
		else if (program instanceof Parallel)
			solutionName = "PAR";
		System.out.println("\n***** " + solutionName + " *****\n");
		associated = program.checkAssociatedOfDictionary();
		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println(solutionName + ": \n- Total time: " + String.valueOf(totalTime) + " ms\nResult: "
				+ String.valueOf(associated));
		Utilities.recordTest(solutionName, program.getCube().getSize(), program.getDic().getLength(), program.getDic()
				.getSize(), associated, String.valueOf(totalTime), resultFile);
	}
}
