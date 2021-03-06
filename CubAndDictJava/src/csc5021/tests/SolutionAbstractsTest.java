/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.*;

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
public abstract class SolutionAbstractsTest {
	protected String cubePath;
	protected String cubeInvalid;
	protected String dicAssociatedPath;
	protected String dicNoAssociatedPath;
	protected String dicInvalid;
	protected String dicTooLong;

	protected Cube cube;
	protected Cube cube_invalid;
	protected Dictionary dic_associated;
	protected Dictionary dic_no_associated;
	protected Dictionary dic_invalid;
	protected Dictionary dic_too_long;

	protected SolutionAbstracts solution_associated;
	protected SolutionAbstracts solution_no_associated;
	protected SolutionAbstracts solution_dic_invalid;
	protected SolutionAbstracts solution_cube_invalid;
	protected SolutionAbstracts solution_dic_too_long;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cubePath = "cube_4_test_solution";
		cube = new Cube(cubePath);

		cubeInvalid = "cube_3_too_small";
		cube_invalid = new Cube(cubeInvalid);

		dicAssociatedPath = "dic_3_13_test_solution";
		dic_associated = new Dictionary(dicAssociatedPath);

		dicNoAssociatedPath = "dic_3_15_test_solution_no_associated";
		dic_no_associated = new Dictionary(dicNoAssociatedPath);

		dicInvalid = "dic_10_2";
		dic_invalid = new Dictionary(dicInvalid);

		dicTooLong = "dic_10_100";
		dic_too_long = new Dictionary(dicTooLong);

	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#SolutionAbstracts(csc5021.objects.Cube, csc5021.objects.Dictionary)}
	 * .
	 */
	@Test
	public void testSolutionAbstractsCubeDictionary() {
		assertTrue(solution_associated.invariant());
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#SolutionAbstracts(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testSolutionAbstractsStringString() {
		assertTrue(solution_no_associated.invariant());
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfDictionary()}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfDictionary() {
		assertTrue(solution_associated.checkAssociatedOfDictionary());
		assertFalse(solution_no_associated.checkAssociatedOfDictionary());
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfDictionary()}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfDictionaryDicInvariant() {
		assertFalse(solution_dic_invalid.checkAssociatedOfDictionary());
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfDictionary()}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfDictionaryCubeInvariant() {
		assertFalse(solution_cube_invalid.checkAssociatedOfDictionary());
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfDictionary()}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfDictionaryDicTooLongInvariant() {
		assertFalse(solution_dic_too_long.checkAssociatedOfDictionary());
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWord(java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWord() {
		assertTrue(solution_associated.checkAssociatedOfWord("THUE"));
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWordOnABFE(java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWordOnABFEString() {
		assertTrue(solution_associated.checkAssociatedOfWordOnABFE("KDC"));
		assertTrue(solution_associated.checkAssociatedOfWordOnABFE("JUE"));
		assertFalse(solution_associated.checkAssociatedOfWordOnABFE("JJJ"));
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWordOnOCDK(java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWordOnOCDKString() {
		assertTrue(solution_associated.checkAssociatedOfWordOnOCDK("CMJ"));
		assertTrue(solution_associated.checkAssociatedOfWordOnOCDK("TPU"));
		assertFalse(solution_associated.checkAssociatedOfWordOnOCDK("JJJ"));
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWordOnOYZ(java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWordOnOYZ() {
		assertTrue(solution_associated.checkAssociatedOfWordOnOYZ("TJM"));
		assertTrue(solution_associated.checkAssociatedOfWordOnOYZ("TER"));
		assertTrue(solution_associated.checkAssociatedOfWordOnOYZ("LCA"));
		assertFalse(solution_associated.checkAssociatedOfWordOnOYZ("AAA"));
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWordOnOXZ(java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWordOnOXZ() {
		assertTrue(solution_associated.checkAssociatedOfWordOnOXZ("THU"));
		assertTrue(solution_associated.checkAssociatedOfWordOnOXZ("TRP"));
		assertTrue(solution_associated.checkAssociatedOfWordOnOXZ("ESX"));
		assertFalse(solution_associated.checkAssociatedOfWordOnOXZ("AAA"));
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWordOnOXY(java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWordOnOXY() {
		assertTrue(solution_associated.checkAssociatedOfWordOnOXY("TFP"));
		assertTrue(solution_associated.checkAssociatedOfWordOnOXY("TBI"));
		assertTrue(solution_associated.checkAssociatedOfWordOnOXY("EJW"));
		assertFalse(solution_associated.checkAssociatedOfWordOnOXY("AAA")); 
	}

	/**
	 * Test method for
	 * {@link csc5021.solutions.SolutionAbstracts#checkAssociatedOfWordInLine(int, int, int, int, int, int, java.lang.String)}
	 * .
	 */
	@Test
	public void testCheckAssociatedOfWordInLine() {
		assertFalse(solution_associated.checkAssociatedOfWordInLine(0, 0, 0, 0, 0, 0, "THU"));
		assertTrue(solution_associated.checkAssociatedOfWordInLine(0, 0, 0, 3, 0, 0, "THU"));
	}

	/**
	 * Test method for {@link csc5021.solutions.SolutionAbstracts#invariant()}.
	 */
	@Test
	public void testInvariant() {
		assertTrue(solution_associated.invariant());
		assertTrue(solution_no_associated.invariant());
	}

	/**
	 * Test method for {@link csc5021.solutions.SolutionAbstracts#invariant()}.
	 */
	@Test
	public void testInvariantDicInvalid() {
		assertFalse(solution_dic_invalid.invariant());
	}

	/**
	 * Test method for {@link csc5021.solutions.SolutionAbstracts#invariant()}.
	 */
	@Test
	public void testInvariantCubeInvalid() {
		assertFalse(solution_cube_invalid.invariant());
	}

	/**
	 * Test method for {@link csc5021.solutions.SolutionAbstracts#invariant()}.
	 */
	@Test
	public void testInvariantDicTooLong() {
		assertFalse(solution_dic_too_long.invariant());
	}

	/**
	 * Test method for {@link csc5021.solutions.SolutionAbstracts#getCube()}.
	 */
	@Test
	public void testGetCube() {
		Cube cube = solution_associated.getCube();
		assertTrue(cube.invariant());
		assertTrue(cube.getSize() == 4);
	}

	/**
	 * Test method for {@link csc5021.solutions.SolutionAbstracts#getDic()}.
	 */
	@Test
	public void testGetDic() {
		Dictionary dic = solution_associated.getDic();
		assertTrue(dic.invariant());
		assertTrue(dic.getSize() == 13);
		assertTrue(dic.getLength() == 3);

	}

}
