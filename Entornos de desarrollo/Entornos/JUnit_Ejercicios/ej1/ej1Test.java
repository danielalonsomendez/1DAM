package ej1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ej1Test {
	@Test
	public void testResta() {
		ej1 obj = new ej1(10, 20);
		int resultado = obj.resta();
		assertEquals("Resultado no válido", 10, resultado);
		}

	@Test
	public void testResta2() {
		ej1 obj = new ej1(10, 20);
		boolean resultado = obj.resta2();
		assertFalse("Resultado no válido",  resultado);
		}

	@Test
	public void testDivide2() {
		ej1 obj= new ej1(10, 0);
		Integer resultado = obj.divide2();
		assertNull("Resultado no válido",  resultado);
		}
}
