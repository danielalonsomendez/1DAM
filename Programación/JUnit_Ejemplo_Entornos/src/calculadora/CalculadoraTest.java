package calculadora;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculadoraTest {

	@Test
	public void testSuma() {
		Calculadora calculadora = new Calculadora(10, 20);
		int result = calculadora.suma();
		assertEquals("Resultado no válido",30,result);

	}

	@Test
	public void testResta() {
		Calculadora calculadora = new Calculadora(10, 20);
		int result = calculadora.resta();
		assertEquals("Resultado no válido",-10,result);
	}

	@Test
	public void testMultiplica() {
		Calculadora calculadora = new Calculadora(10, 20);
		int result = calculadora.multiplica();
		assertEquals("Resultado no válido",200,result);

	}

	@Test
	public void testDivide() {
		Calculadora calculadora = new Calculadora(10, 20);
		int result = calculadora.divide();
		assertEquals("Resultado no válido",0,result);

	}

}
