/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import csc5021.objects.Dictionary;
import csc5021.utilities.Utilities;

/**
 * Test for class {@link Dictionary}
 * @author luongnv89
 * 
 */
public class DictionaryTest {

	Dictionary myDic;
	Dictionary dic_2;
	Dictionary dic_too_short;
	Dictionary dic_too_long;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myDic = new Dictionary("dic_10_100");
		dic_2 = new Dictionary("dic_10_2");
		ArrayList<String> listwordsTooShort = new ArrayList<String>();
		while (listwordsTooShort.size() < 10) {
			String w = Utilities.createNewWord(1);
			if (!listwordsTooShort.contains(w)) {
				listwordsTooShort.add(w);
			}
		}
		dic_too_short = new Dictionary(listwordsTooShort);
		ArrayList<String> listwordsTooLong = new ArrayList<String>();
		while (listwordsTooLong.size() < 10) {
			String w = Utilities.createNewWord(110);
			if (!listwordsTooLong.contains(w)) {
				listwordsTooLong.add(w);
			}
		}
		dic_too_long = new Dictionary(listwordsTooLong);

	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#Dictionary(int, int)}.
	 */
	@Test
	public void testDictionaryIntInt() {
		Dictionary dic10_100 = new Dictionary(10, 10);
		assertTrue(dic10_100.invariant());
		assertTrue(dic10_100.getLength() == 10);
		assertTrue(dic10_100.getSize() <= 100);
	}

	/**
	 * Test method for
	 * {@link csc5021.objects.Dictionary#Dictionary(java.util.ArrayList)}.
	 */
	@Test
	public void testDictionaryArrayListOfString() {
		ArrayList<String> listwords = new ArrayList<String>();
		while (listwords.size() < 10) {
			String w = Utilities.createNewWord(15);
			if (!listwords.contains(w)) {
				listwords.add(w);
			}
		}
		Dictionary dic_15_10 = new Dictionary(listwords);
		assertTrue(dic_15_10.invariant());
		assertTrue(dic_15_10.getLength() == 15);
		assertTrue(dic_15_10.getSize() <= 10);
	}

	/**
	 * Test method for
	 * {@link csc5021.objects.Dictionary#Dictionary(java.lang.String)}.
	 */
	@Test
	public void testDictionaryString() {
		Dictionary dic_10_100 = new Dictionary("dic_10_100");
		assertTrue(dic_10_100.invariant());
		assertTrue(dic_10_100.getLength() == 10);
		assertTrue(dic_10_100.getSize() <= 100);
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#getLength()}.
	 */
	@Test
	public void testGetLength() {
		assertTrue(myDic.getLength() == 10);
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#getSize()}.
	 */
	@Test
	public void testGetSize() {
		assertTrue(myDic.getSize() <= 100);
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#getWordByIndex(int)}.
	 */
	@Test
	public void testGetWordByIndex() {
		for (int i = 0; i < myDic.getSize(); i++) {
			System.out.println(myDic.getWordByIndex(i));
		}
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#invariant()}.
	 */
	@Test
	public void testInvariant() {
		assertTrue(myDic.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#invariant()}.
	 */
	@Test
	public void testInvariantInvalidSize() {
		assertFalse(dic_2.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#invariant()}.
	 */
	@Test
	public void testInvariantInvalidLengthOfWord() {
		assertFalse(dic_too_short.invariant());
		assertFalse(dic_too_long.invariant());
	}

	/**
	 * Test method for
	 * {@link csc5021.objects.Dictionary#saveToFile(java.lang.String)}.
	 */
	@Test
	public void testSaveToFile() {
		myDic.saveToFile("dic_10_100_copy");
	}

}
