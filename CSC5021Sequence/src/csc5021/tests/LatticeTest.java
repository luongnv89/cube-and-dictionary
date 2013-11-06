/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import csc5021.objects.Cube;

/**
 * @author luongnv89
 *
 */
public class LatticeTest {

	Cube lattice;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		lattice = new Cube(3);
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Lattice(int)}.
	 */
	@Test
	public void testLatticeInt() {
		Cube latticeInt = new Cube(4);
		latticeInt.showLatice();
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Lattice(char[][][])}.
	 */
	@Test
	public void testLatticeCharArrayArrayArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Lattice(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testLatticeString() throws Exception {
		Cube stringLattice = new Cube("ABCDEFGHKABCDEFGHKABCDEFGHK");
		stringLattice.showLatice();
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Lattice(csc5021.objects.Cube)}.
	 */
	@Test
	public void testLatticeLattice() {
		Cube latticeCoppy = new Cube(lattice);
		lattice.showLatice();
		System.out.println("Coppy:");
		latticeCoppy.showLatice();
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#getSize()}.
	 */
	@Test
	public void testGetSize() {
		assertTrue(lattice.getSize()==3);
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#getValues()}.
	 */
	@Test
	public void testGetValues() {
		assertTrue(lattice.getValues().length>0);
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#invariant()}.
	 */
	@Test
	public void testInvariant() {
		assertTrue(lattice.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#showLatice()}.
	 */
	@Test
	public void testShowLatice() {
		lattice.showLatice();
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#initRandomly()}.
	 */
	@Test
	public void testInitialRandomly() {
		Cube myLattice = new Cube(1000);
		myLattice.showLatice();
	}

}
