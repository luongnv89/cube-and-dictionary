/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import csc5021.objects.Cube;
import csc5021.objects.Dictionary;
import csc5021.solutions.SolutionAbstracts;

/**
 * Test for class {@link SolutionAbstracts}
 * 
 * @author luongnv89
 * 
 */
public class SolutionAbstractsTest {
	protected Cube cube;
	protected Dictionary dic_associated;
	protected Dictionary dic_no_associated;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cube = new Cube("cube_4_test_solution");
		dic_associated = new Dictionary("dic_4_test_solution_associated");
		dic_no_associated = new Dictionary("dic_4_test_solution_no_associated");
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#SolutionAbstracts(csc5021.objects.Cube, csc5021.objects.Dictionary)}
	 * .
	 */
	@Test
	public void testSolutionAbstractsCubeDictionary() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#SolutionAbstracts(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testSolutionAbstractsStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfDictionary()}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfDictionary() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWord(java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWord() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWordOnABFE(java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWordOnABFEString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWordOnABFE(int, int, int, int, int, int, java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWordOnABFEIntIntIntIntIntIntString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWordOnOCDK(java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWordOnOCDKString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWordOnOCDK(int, int, int, int, java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWordOnOCDKIntIntIntIntString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWordOnOYZ(java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWordOnOYZ() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWordOnOXZ(java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWordOnOXZ() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWordOnOXY(java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWordOnOXY() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWordInLine(int, int, int, int, int, int, java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWordInLine() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.solutions.SolutionAbstracts#invariant()}.
	 */
	@Test
	public void testInvariant() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.solutions.SolutionAbstracts#getCube()}.
	 */
	@Test
	public void testGetCube() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.solutions.SolutionAbstracts#getDic()}.
	 */
	@Test
	public void testGetDic() {
		fail("Not yet implemented");
	}

}