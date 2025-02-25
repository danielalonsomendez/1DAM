package ej2;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccesoUsuarioTest {

	@Test
	public void testConstructor() {
		AccesoUsuario accesousuario = new AccesoUsuario();
		assertNotNull("Clase no creada correctamente", accesousuario);
	}

	@Test
	public void testID() {
		AccesoUsuario accesousuario = new AccesoUsuario();
		accesousuario.setId(5);
		assertEquals("El ID no se cambia o se muestra correctamente",5, accesousuario.getId());
	}

	@Test
	public void testNombre() {
		AccesoUsuario accesousuario = new AccesoUsuario();
		accesousuario.setNombre("AD");
		assertEquals("El nombre no se cambia o se muestra correctamente","AD", accesousuario.getNombre());
	}

	@Test
	public void testUsuarioExiste() {
		AccesoUsuario accesousuario1 = new AccesoUsuario();
		accesousuario1.setNombre("AD");
		AccesoUsuario accesousuario2 = new AccesoUsuario();
		accesousuario2.setNombre("AD");
		assertTrue("El usuario no existe",accesousuario2.equals(accesousuario1));
	}
	@Test
	public void testUsuarioNoExiste() {
		AccesoUsuario accesousuario1 = new AccesoUsuario();
		accesousuario1.setNombre("AD");
		AccesoUsuario accesousuario2 = new AccesoUsuario();
		accesousuario2.setNombre("ED");
		assertFalse("El usuario existe",accesousuario2.equals(accesousuario1));
	}
	@Test
	public void testHashCode() {
		AccesoUsuario accesousuario1 = new AccesoUsuario();
		accesousuario1.setNombre("AD");
		AccesoUsuario accesousuario2 = new AccesoUsuario();
		accesousuario2.setNombre("AD");
		assertEquals("El metodo hashCode no funciona correctamente",accesousuario2.hashCode() , accesousuario1.hashCode());
	}
}
