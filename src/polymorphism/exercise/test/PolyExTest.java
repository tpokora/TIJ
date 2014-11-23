package polymorphism.exercise.test;

import static org.junit.Assert.*;

import org.junit.Test;

import polymorphism.exercise.A;
import polymorphism.exercise.B;

public class PolyExTest {

	@Test
	public void ABTest() {
		A a = new A(3);
		assertEquals("", a.a, 3);
		assertEquals(a.msg("siema"), "Msg: siema");
	}
	
	@Test
	public void ABTest2() {
		B b = new B(5);
		A a = b;
		assertEquals("", a.a, 5);
		assertEquals(b.msg("siema"), "Msg: siema");
	}

}
