package elorrietaVending;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Maquina de vending que contiene todas las funciones para su funcionamiento
 * para cliente y administrador.
 * 
 * @author Grupo 2: Daniel Alonso, Igoin Cisneros, Unatx Chicano y Gabriel
 *         Hilari
 */
public class elorrietaVending {
	/**
	 * Lector de teclado
	 */
	static Scanner teclado = new Scanner(System.in);
	/**
	 * Matriz que contiene todos los productos, 100 elementos con 4 columnas
	 * (CÓDIGO,NOMBRE,PRECIO y TIPO)
	 */
	static String[][] productos = new String[100][4];
	/**
	 * Matriz que contiene todos los productos que el usuario quiere comprar, 100
	 * elementos con 5 columnas (CÓDIGO,NOMBRE,PRECIO,TIPO y CANTIDAD)
	 */
	static String[][] carrito = new String[100][5];

	/**
	 * RETO 1: Maquina de vending Constructor
	 */
	public elorrietaVending() {

	}

	/**
	 * Función principal que rellena nuestros productos predeterminados con
	 * rellenarProductos() y despues llama a inicio()
	 * 
	 * @param args Argumentos necesarios para Java
	 */
	public static void main(String[] args) {
		rellenarProductos();
		inicio();
		// Cerrar teclado
		teclado.close();
	}

	/**
	 * Función para rellenar con algunos elementos la matriz productos.
	 */
	public static void rellenarProductos() {
		productos[0][0] = "101";
		productos[0][1] = "COCA COLA";
		productos[0][2] = "1.80";
		productos[0][3] = "1";

		productos[1][0] = "102";
		productos[1][1] = "AGUA";
		productos[1][2] = "1.00";
		productos[1][3] = "1";

		productos[2][0] = "103";
		productos[2][1] = "FANTA";
		productos[2][2] = "1.50";
		productos[2][3] = "1";

		productos[3][0] = "104";
		productos[3][1] = "RED BULL";
		productos[3][2] = "2.20";
		productos[3][3] = "1";

		productos[4][0] = "105";
		productos[4][1] = "CAFE";
		productos[4][2] = "2.30";
		productos[4][3] = "1";

		productos[5][0] = "201";
		productos[5][1] = "LAYS";
		productos[5][2] = "1.60";
		productos[5][3] = "2";

		productos[6][0] = "202";
		productos[6][1] = "TAKIS";
		productos[6][2] = "1.80";
		productos[6][3] = "2";

		productos[7][0] = "203";
		productos[7][1] = "RUFLES JAMON";
		productos[7][2] = "1.70";
		productos[7][3] = "2";

		productos[8][0] = "204";
		productos[8][1] = "PRINGLES";
		productos[8][2] = "2.50";
		productos[8][3] = "2";

		productos[9][0] = "205";
		productos[9][1] = "RISQUETOS";
		productos[9][2] = "1.60";
		productos[9][3] = "2";

		productos[10][0] = "206";
		productos[10][1] = "CHETOS";
		productos[10][2] = "1.80";
		productos[10][3] = "2";

		productos[11][0] = "301";
		productos[11][1] = "SANDWICH MIXTO";
		productos[11][2] = "3.70";
		productos[11][3] = "3";

		productos[12][0] = "302";
		productos[12][1] = "SANDWICH POLLO-CHICKEN";
		productos[12][2] = "3.90";
		productos[12][3] = "3";

		productos[13][0] = "303";
		productos[13][1] = "SANDWICH VEGETAL";
		productos[13][2] = "3.50";
		productos[13][3] = "3";

		productos[14][0] = "401";
		productos[14][1] = "KINDER";
		productos[14][2] = "1.80";
		productos[14][3] = "4";

		productos[15][0] = "402";
		productos[15][1] = "KIT KAT";
		productos[15][2] = "1.50";
		productos[15][3] = "4";

		productos[16][0] = "403";
		productos[16][1] = "LACASITOS";
		productos[16][2] = "1.30";
		productos[16][3] = "4";

		productos[17][0] = "404";
		productos[17][1] = "MIKADOS";
		productos[17][2] = "2.20";
		productos[17][3] = "4";

		productos[18][0] = "405";
		productos[18][1] = "SNICKERS";
		productos[18][2] = "1.70";
		productos[18][3] = "4";

		productos[19][0] = "406";
		productos[19][1] = "CONGUITOS";
		productos[19][2] = "1.30";
		productos[19][3] = "4";

	}

	/**
	 * Función para mostrar un menu con un texto introductorio y pedir un numero al
	 * usuario. Si el usuario no introduce un numero, la función se repite.
	 * 
	 * @param texto El texto a mostrar antes de pedir al usuario introducir un
	 *              numero
	 * @return Devuelve el número de la opción elegido por el usuario
	 */
	public static int menuConOpcion(String texto) {
		int opcion;
		// Mostrar texto del menu
		System.out.printf(texto);
		// Pedir al teclado un numero y repetir en caso de no escribir un numero
		try {
			opcion = teclado.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Opción no válida.\n");
			teclado.nextLine();
			return menuConOpcion(texto);
		}
		return opcion;
	}

	/**
	 * Funcion que muestra un menu para dar a elegir al usuario quien es, si es un
	 * cliente llama a menuCliente() o si es un administrador, llama a
	 * inicioSesion(). Se repite en bucle.
	 */
	public static void inicio() {
		int operacion;
		do {
			operacion = menuConOpcion(
					"BIENVENIDO a ELORRIETA-VENDING\nElige quien eres:\n 1.Cliente\n 2.Administrador\n>");
			if (operacion == 1) {
				menuCliente();
			} else if (operacion == 2) {
				inicioSesion();
			}

		} while (true);

	}

	/*
	 * --------------------------------------- FUNCIONES ADMINISTRACIÓN
	 * ---------------------------------------
	 */

	/**
	 * Función para que el usuario entre al apartado de administrador tras
	 * introducir un usuario y contraseña correctos. En caso de no introducir el
	 * usuario y la contraseña correctos, se repite o da la opción de volver al menu
	 * principal.
	 */
	public static void inicioSesion() {
		String usuario = "A";
		String contraseña = "1";
		int salir = 0;

		do {
			System.out.printf("Introduce el USUARIO: ");
			teclado.nextLine();
			String usuarioInicio = teclado.next();
			System.out.printf("Introduce la CONTRASEÑA: ");
			String contraseñaInicio = teclado.next();
			// Verifica que el nombre y la contraseña coincidan
			if (usuarioInicio.equals(usuario) && contraseñaInicio.equals(contraseña)) {
				salir = -1;
				menuAdministracion();

			} else {
				salir = menuConOpcion(
						"Usuario o contraseña incorrecto. Escribe cualquier número para intentarlo de nuevo o -1 para salir\n");
				if (salir == -1) {
					inicio();
				} else {
					inicioSesion();
				}

			}

		} while (salir != -1);

	}

	/**
	 * Función para desplegar un menu para que el administrador eliga que quiere
	 * hacer con los elementos. Tiene varias opciones segun el numero que escriba el
	 * usuario. En caso de no introducir una opción valida, el menu se repite.
	 * 1.Añadir producto, llama a anadirProducto() 2.Modificar producto, llama a
	 * modificarProducto() 3.Eliminar producto, llama a eliminarProducto()
	 */
	public static void menuAdministracion() {
		int operacion;
		do {
			operacion = menuConOpcion(
					"\nMENÚ de ADMINISTRACIÓN:\nElige una OPCIÓN: \n 1.Añadir producto\n 2.Modificar producto\n 3.Eliminar producto\n 4.Volver al menu principal\n>");
			switch (operacion) {
			case 1:
				anadirProducto();
				break;
			case 2:
				modificarProducto();
				break;
			case 3:
				eliminarProducto();
				break;
			case 4:
				System.out.println("Saliendo del menu de administración...");
				break;
			}
			teclado.nextLine();
		} while (operacion !=4);
	}

	/**
	 * Función para que (en modo administrador) añadir un producto a la matriz
	 * "productos". Pide a la función numeroProductos(), cuantos productos ya estan
	 * rellenados. Si ese numero ha alcanzado el limite de la matriz, no deja añadir
	 * más productos. Pasada esa verificación,pide al usuario el codigo,el nombre,
	 * el precio y el tipo del nuevo producto con las funciones
	 * pedirString(),pedirPrecio() y pedirTipo() Y guarda toda la información del
	 * nuevo producto en la siguiente posición disponible de la matriz productos.
	 */

	public static void anadirProducto() {
		String nombre;
		String codigo;
		float precio;
		int tipo;
		int posicion = numeroProductos();
		if (posicion > productos.length) {
			System.out.println("NO se pueden AÑADIR MÁS PRODUCTOS. Elimina uno para continuar.");
		} else {
			teclado.nextLine();
			codigo = pedirString("codigo");
			nombre = pedirString("nombre");
			precio = pedirPrecio();
			tipo = pedirTipo();
			productos[posicion][0] = codigo;
			productos[posicion][1] = nombre;
			productos[posicion][2] = precio + "";
			productos[posicion][3] = tipo + "";

			System.out.println("Producto AÑADIDO correctamente!");

		}
	}

	/**
	 * Función para (en modo administrador) modifiques una o varias caracteristicas
	 * del producto que eliga el administrador. Primero, con la función
	 * elegirProducto(), seleccionas el producto que quieres modificar. Segundo,
	 * seleccionas que atributo del producto quieres modificar. Si selecciona
	 * codigo, llama a pedirString y el valor que devuelve lo guarda en el producto
	 * seleccionado. Si selecciona nombre, llama a pedirString y el valor que
	 * devuelve lo guarda en el producto seleccionado. Si selecciona precio, llama a
	 * pedirPrecio y el valor que devuelve lo guarda en el producto seleccionado. Si
	 * selecciona tipo, llama a pedirTipo y el valor que devuelve lo guarda en el
	 * producto seleccionado. Puede seguir modificando atributos, hasta que
	 * introduce 5, en cuyo caso vuelve a elegir otro producto. Para salir del menu,
	 * el usuario tiene que introducir -1.
	 */

	public static void modificarProducto() {
		int operacion = 0;
		int posicionproducto = 0;
		do {

			posicionproducto = elegirProducto();
			if (posicionproducto != -1) {
				do {
					operacion = menuConOpcion(
							"\nElige la MODIFICACIÓN que deseas realizar: \n 1.Modificar CÓDIGO \n 2.Modificar NOMBRE \n 3.Modificar PRECIO \n 4.Modificar TIPO \n 5.Volver a elegir producto\n>");
					teclado.nextLine();

					switch (operacion) {
					case 1:
						productos[posicionproducto][0] = pedirString("codigo");
						System.out.println("Código MODIFICADO correctamente!");
						break;
					case 2:
						productos[posicionproducto][1] = pedirString("nombre");
						System.out.println("Nombre MODIFICADO correctamente!");
						break;
					case 3:
						float precio = pedirPrecio();
						productos[posicionproducto][2] = precio + "";
						System.out.println("Precio MODIFICADO correctamente!");
						break;
					case 4:
						int tipo = pedirTipo();
						productos[posicionproducto][3] = tipo + "";
						System.out.println("Tipo MODIFICADO correctamente!");
						break;

					}

				} while ((operacion == 1 || operacion == 2 || operacion == 3 || operacion == 4) || operacion != 5);
			}
		} while (operacion == 5 && posicionproducto != -1);

	}

	/**
	 * Funcion para (en modo administrador) eliminar el producto que eliga el
	 * administrador. Con la función elegirProducto(), seleccionas el producto que
	 * quieres eliminar. Depues elimina el producto, convirtiendo todos sus valores
	 * en null. Para salir del menu, el usuario tiene que introducir -1.
	 */
	public static void eliminarProducto() {
		int posicionproducto = elegirProducto();
		if (posicionproducto != -1) {
			productos[posicionproducto][0] = null;
			productos[posicionproducto][1] = null;
			productos[posicionproducto][2] = null;
			productos[posicionproducto][3] = null;
			System.out.println("Producto ELIMINADO correctamente!");
		}

	}

	/**
	 * Funcion para saber el numero de elementos rellenados (no null) que tenemos en
	 * la matriz principal "productos".
	 * 
	 * @return Devuelve el numero de elementos rellenados
	 */
	public static int numeroProductos() {
		int cantidadProductos = 0;
		for (int i = 0; i < productos.length; i++) {
			if (productos[i][0] != null) {
				cantidadProductos++;
			}
		}
		return cantidadProductos;
	}

	/**
	 * Función para pedir el precio del producto, en el modo administrador. En caso
	 * de no escribir un numero con decimales, la función se repite.
	 * 
	 * @return Devuelve el precio introducido.
	 */
	public static float pedirPrecio() {
		float precio;
		System.out.printf("Introduce el PRECIO del PRODUCTO: ");
		try {
			precio = teclado.nextFloat();
		} catch (InputMismatchException e) {
			teclado.nextLine();
			return pedirPrecio();
		}
		return precio;
	}

	/**
	 * Función para pedir el tipo de producto,en modo administrador. En caso de no
	 * escribir un numero, la función se repite. En caso de no estar entre 1 y 4, la
	 * funcion se repite.
	 * 
	 * @return Devuelve un numero entre 1 y 4 con el tipo introducido por el
	 *         cliente.
	 */

	public static int pedirTipo() {
		int tipo;
		try {
			do {
				System.out.printf(
						"Introduce el TIPO del PRODUCTO (1-4)\n1. Bebidas | 2.Snacks | 3.Sandwiches | 4.Chocolatinas :\n");
				tipo = teclado.nextInt();
			} while (tipo < 1 || tipo > 4);

		} catch (InputMismatchException e) {
			teclado.nextLine();
			return pedirTipo();
		}
		return tipo;
	}

	/**
	 * Función para pedir al usuario el codigo de producto o el nombre del producto.
	 * Si el parametro atrb es "codigo", pide el codigo del producto al cliente. Si
	 * el codigo ya existe en la matriz productos, le pide otro hasta que no exista.
	 * Si el parametro atrb es "nombre",pide el nombre del producto y lo devuelve
	 * 
	 * @param devolver Parametro para decidir que pide al usuario la función
	 * @return Devuelve una cadena, que puede ser el codigo del producto o el nombre
	 *         del producto.
	 */

	public static String pedirString(String devolver) {

		if (devolver == "codigo") {
			int existe;
			String codigoArticulo;
			do {
				System.out.printf("Introduce el CÓDIGO del PRODUCTO: ");
				codigoArticulo = teclado.nextLine();

				existe = buscarProductoPorCodigo(codigoArticulo);

				if (existe != -1) {
					System.out.println("El CÓDIGO ya EXISTE. Vuelve a intentarlo\n");
				}
				if (codigoArticulo == "") {
					existe = -1;
					System.out.println("El CÓDIGO no puede ESTAR VACIO. Vuelve a intentarlo\n");
				}
			} while (existe != -1);

			return codigoArticulo;
		} else {
			System.out.printf("Introducir el NOMBRE del PRODUCTO: ");
			return teclado.nextLine();
		}

	}

	/**
	 * Función que busca un articulo en la matriz principal "Productos" por el
	 * codigo del producto y devuelve la posición.
	 * 
	 * @param codigo El codigo a buscar en la matriz productos.
	 * @return Devuelve la posicion del producto.Si no lo encuentra,devuelve -1.
	 */
	public static int buscarProductoPorCodigo(String codigo) {
		int indexProductos = -1;
		int numeroProductos = numeroProductos();
		for (int i = 0; i < numeroProductos; i++) {
			if (codigo.equals(productos[i][0]) && indexProductos == -1) {
				indexProductos = i;
			}
		}
		return indexProductos;
	}

	/**
	 * Función que muestra un menu con todos los articulos que hay en la matriz
	 * productos y el usuario puede elegir el articulo deseado. Para salir del menu,
	 * el usuario tiene que introducir -1.
	 * 
	 * @return Devuelve la posicion en la matriz productos del producto que ha
	 *         elegido
	 */
	public static int elegirProducto() {
		int posicionProductoElegido = -1;
		int listaNumeroElegido = 0;
		int numeroProductos = numeroProductos();
		if (numeroProductos != 0) {
			do {
				int numproducto = 0;
				int[] posicionesDeLosProductos = new int[productos.length];
				// Mostrar todos los productos rellenados de la matriz productos
				for (int i = 0; i < productos.length; i++) {
					// Verifica que el producto existe
					if (productos[i][0] != null) {
						// Guarda la posicion de la matriz productos
						posicionesDeLosProductos[numproducto] = i;
						System.out.println((numproducto + 1) + "> CÓDIGO:" + productos[i][0] + " NOMBRE:"
								+ productos[i][1] + " PRECIO:" + productos[i][2] + "€ TIPO:" + productos[i][3]);
						numproducto++;

					}
				}
				listaNumeroElegido = menuConOpcion(
						"Elige un PRODUCTO (" + "1-" + numeroProductos + ") Escribe -1 para volver al menú\n>");
				if (listaNumeroElegido == -1) {
					break;
				} else if (listaNumeroElegido >= 1
						&& listaNumeroElegido <= numeroProductos) /* Esta entre 1 y numeroProductos */ {
					posicionProductoElegido = posicionesDeLosProductos[listaNumeroElegido - 1];
				} else {
					System.out
							.println("Opción no válida. Por favor, elige un número entre 1 y " + numeroProductos + ".");
				}

			} while (listaNumeroElegido < 1 || listaNumeroElegido > numeroProductos);
		}
		return posicionProductoElegido;
	}

	/*
	 * --------------------------------------- FUNCIONES CLIENTE
	 * ---------------------------------------
	 */

	/**
	 * Función que muestra un menu en el que te da a elegir si añadir un producto,
	 * ver el carrito de compra, terminar la compra o volver al inicio. En caso que
	 * elija añadir articulo llama a la funcion menuTipos(). En caso que elija ver
	 * carrito llama a la funcion resumenCompra(). En caso que elija terminar compra
	 * llama a la funcion pagarPedido(). Y en caso de que elija volver vuelve al
	 * inicio de sesion.
	 */
	public static void menuCliente() {
		boolean repetir = true;
		int operacion;
		do {
			int cantidadcarrito = productosEnCarrito(true);
			if (cantidadcarrito != 0) {
				System.out.printf("\nTienes %s PRODUCTO(S) en el CARRITO\n", cantidadcarrito);
			}
			operacion = menuConOpcion(
					"\nElige un opción:\n 1.Añadir un producto al carrito\n 2.Ver carrito\n 3.Terminar compra\n 4.Volver al inicio\n>");
			switch (operacion) {
			case 1:
				menuTipos();
				break;
			case 2:
				resumenCompra();
				repetir = false;
				break;
			case 3:
				pagarPedido();
				repetir = false;
				break;
			case 4:
				System.out.println("Saliendo del menu de compras...");
				repetir = false;
				break;
			}
		} while (repetir == true);

	}

	/**
	 * Función que muestra los tipos de productos que tenemos y el cliente eliga el
	 * tipo de producto que quiere. Una vez seleccionado el tipo,llama a
	 * productosPorTipo() para mostrar todos los productos del mismo.
	 */
	public static void menuTipos() {
		int opcion;
		do {
			opcion = menuConOpcion(
					"\nElige un tipo:\n 1.Bebidas\n 2.Snacks\n 3.Sandwiches\n 4.Chocolatinas\n 5.Volver al menu de compras\n>");
			if (opcion >= 1 && opcion <= 4) {
				opcion = listaProductosPorTipo(opcion);
			}
		} while (opcion >= 1 && opcion <= 4 || opcion != 5);

	}

	/**
	 * Funcion para imprimir por pantalla los productos de un tipo. Despues muestra
	 * un menu, en el que da a elegir un producto al usuario para añadirlo a la
	 * matriz carrito. Si introduce -1, vuelve a menuTipos() para elegir otro tipo
	 * Si introduce 2, llama a resumenCompra() Si introduce un numero que este en el
	 * intervalo de productos con ese tipo, llama a anadirProductoPorTipo(), para
	 * añadirlo al carrito.
	 * 
	 * @param tipo Tipo de los que tiene que mostrar productos.
	 * @return te devuelve el tipo seleccionado por el usuario.
	 */

	public static int listaProductosPorTipo(int tipo) {
		// Verifica que en la matriz productos hay algún producto
		if (numeroProductos() != 0) {
			int numeroProductos = 0;
			int listaNumeroElegido = 0;
			do {
				// Mostrar lista de productos de este tipo
				int[] posicionesDeLosProductos = new int[productos.length];
				numeroProductos = 0;
				for (int i = 0; i < productos.length; i++) {
					// Verifica que el producto exista y pertenezca al tipo buscado
					if (productos[i][0] != null && productos[i][3].equals(tipo + "")) {
						// Guarda la posicion de la matriz productos
						posicionesDeLosProductos[numeroProductos] = i;
						float precio = Float.parseFloat(productos[i][2]);
						String precioFormateado = formatearPrecio(precio);

						System.out.println((numeroProductos + 1) + "> " + productos[i][0] + " " + productos[i][1]
								+ " Precio: " + precioFormateado);
						numeroProductos++;

					}
				}
				// Verifica que haya algun producto de ese tipo
				if (numeroProductos > 0) {
					listaNumeroElegido = menuConOpcion(
							"\nELIGE un producto para AÑADIRLO al carrito (" + "1-" + numeroProductos + ")"
									+ " Escribe -1 para elegir otro tipo o Escribe -2 para ver el carrito \n>");

					if (listaNumeroElegido == -1) {
						break;
					} else if (listaNumeroElegido == -2) {
						resumenCompra();
						tipo = 5;
						break;
					} else if (listaNumeroElegido >= 1
							&& listaNumeroElegido <= numeroProductos) /* Esta entre 1 y numeroProductos */ {
						anadirProductoCarrito(posicionesDeLosProductos[listaNumeroElegido - 1]);
					} else {
						System.out.println(
								"Opción no válida. Por favor, elige un número entre 1 y " + numeroProductos + ".");
					}
				}
			} while (listaNumeroElegido < 1 || listaNumeroElegido > numeroProductos);
		}
		return tipo;
	}

	/**
	 * Funcion para que el cliente pueda añadir un producto a la matriz carrito. En
	 * caso de que ya este en ella, actualiza la cantidad sumandole uno.
	 * 
	 * @param posicion Posicion del producto en la matriz productos
	 */
	public static void anadirProductoCarrito(int posicion) {
		int cantidadCarrito = productosEnCarrito(false);
		// Verifica que el producto en esa posicion existe y verifica que se puedan
		// añadir todavia productos al carrito
		if (productos[posicion][0] != null && cantidadCarrito != carrito.length) {
			// Busca la posicion de este producto en el carrito
			int posicioncarrito = posicionProductoEnCarritoPorCodigo(productos[posicion][0]);
			// En caso de no existir en el carrito, la posicion sera la última disponible
			if (posicioncarrito == -1) {
				posicioncarrito = cantidadCarrito;
			}
			// Guarda la cantidad actual de este producto en el carrito (en caso de no
			// existir,seria 0) y le añade 1.
			int cantidad = cantidadProductoEnCarritoPorCodigo(productos[posicion][0]) + 1;

			carrito[posicioncarrito][0] = productos[posicion][0];
			carrito[posicioncarrito][1] = productos[posicion][1];
			carrito[posicioncarrito][2] = productos[posicion][2];
			carrito[posicioncarrito][3] = productos[posicion][3];
			carrito[posicioncarrito][4] = cantidad + "";

			System.out.printf("%s PRODUCTO AÑADIDO\n", productos[posicion][1]);
		}
	}

	/**
	 * Función para mostrar todos los productos que ha añadido a la matriz carrito y
	 * la factura que tiene que pagar con IVA. Le da la opción de tramitar el pedido
	 * o no En caso de tramitarlo, llama a {@link pagarPedido()}. En caso contrario,
	 * vacia el carrito y vuelve al menu principal.
	 */
	public static void resumenCompra() {
		int numeroProductosCarrito = productosEnCarrito(false);
		String opcion;
		if (numeroProductosCarrito == 0) {
			System.out.printf("No hay NINGÚN producto AÑADIDO en el carrito.\n");
		} else {
			// Mostrar lista de productos en el carrito
			System.out.printf("\nLISTA DE PRODUCTOS:\n%-20s %-20s %-20s %-20s %-20s \n", "CANTIDAD", "CÓDIGO", "NOMBRE",
					"PRECIO UNIDAD", "PRECIO TOTAL");
			for (int i = 0; i < numeroProductosCarrito; i++) {
				float precioUnidad = Float.parseFloat(carrito[i][2]);
				float precioProducto = (precioUnidad * Integer.parseInt(carrito[i][4]));
				System.out.printf("%-20s %-20s %-20s %-20s %-20s \n", carrito[i][4], carrito[i][0], carrito[i][1],
						formatearPrecio(precioUnidad), formatearPrecio(precioProducto));
			}
			// Mostrar precio SIN IVA, precio SOLO IVA Y precio CON IVA
			System.out.printf("\nPRECIO SIN IVA: %.2f€\nIVA: %.2f€\nPRECIO TOTAL: %.2f€\n",
					calcularPrecio("preciosiniva"), calcularPrecio("iva"), calcularPrecio("precioconiva"));

			// Pedir TRAMITAR pedido o no
			teclado.nextLine();
			do {
				System.out.printf("\n¿Quieres TRAMITAR el PEDIDO? \nEscribe SI o NO\n>");
				opcion = teclado.nextLine();
				opcion = opcion.toUpperCase();
				switch (opcion) {
				case "SI":
					pagarPedido();
					break;
				case "NO":
					carrito = new String[100][5];
					System.out.printf("Saliendo del menú de compras. Tu carrito se ha vaciado.\n");
					break;
				}
			} while (opcion.equals("SI") == false && opcion.equals("NO") == false);
		}

	}

	/**
	 * Funcion para pagar el pedido y segun la cantidad de dinero que introduzca el
	 * usuario, le devuelve las vueltas, si es necesario. En caso de ser lo mismo el
	 * precio que el dinero intducido no se daran vueltas, y se completara el pago.
	 * En caso de que el dinero introducido sea menor al precio solicitado te vuelve
	 * a pedir que introduzcas el dinero. En caso de que el dinero introducido sea
	 * mayor al precio solicitado, calcula las vueltas que le tiene que dar nuestra
	 * maquina al cliente, utilizando en el mínimo de billetes/monedas posibles. Si
	 * todo es correcto espera 10 segundos y te devuelve a menuCliente().
	 */
	public static void pagarPedido() {
		if (productosEnCarrito(false) == 0) {
			System.out.printf("No hay NINGÚN producto AÑADIDO en el carrito.\n");
		} else {
			double precio = calcularPrecio("precioconiva");
			System.out.printf("\nPRECIO A PAGAR: %.2f€\n", precio);
			double dinero = 0;
			do {
				dinero = pedirDinero();
				if (dinero < precio) {
					System.out.printf("No has introducido la cantidad necesaria. Te faltan %.2f€\n", precio - dinero);
				} else if (dinero != precio) {
					double vueltas = redondearDosDecimales(dinero - precio);
					System.out.printf("TOTAL A DEVOLVER: %.2f€\n", vueltas);
					// CALCULAR NUMERO DE VUELTAS A DAR AL CLIENTE
					double[] monedas = { 200, 100, 50, 20, 10, 5, 2, 1, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01 };
					for (int i = 0; i < monedas.length; i++) {
						if (vueltas != 0) {
							// Calcula la cantidad de vueltas de cada moneda
							int cantidadMoneda = (int) (vueltas / monedas[i]);
							// Actualiza el valor de vueltas con el resto, redondeado a dos decimales
							vueltas = redondearDosDecimales(vueltas % monedas[i]);

							// Muestra la cantidad de monedas,si hay alguna que dar
							if (cantidadMoneda != 0) {
								String moneda = "céntimos";
								if (monedas[i] >= 1) {
									moneda = "euros";
								}
								System.out.printf("%s de %.2f %s \n", cantidadMoneda, monedas[i], moneda);
							}
						}
					}
					dinero = precio;

				}
			} while (dinero < precio || dinero != precio);

			System.out.println("Pago realizado con EXITO!");
			// Espera a terminar el pago 10 segundos
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			System.out.println("Volviendo al menú principal!");
			carrito = new String[100][5];

		}
	}

	/**
	 * Función para calcular cuantos productos en la matriz carrito estan rellenos
	 * (no null). Si el atributo cantidades es true, tambien se calcula cuanta
	 * cantidad hay de cada producto en la suma total
	 * 
	 * @param cantidades Si es true, en la suma se tienen en cuenta las cantidades
	 *                   de los productos. Si es false, no se tiene en cuenta si un
	 *                   producto tiene mas de una unidad en el carrito.
	 * @return Devuelve el numero de elementos que esta rellenos en la matriz
	 *         carrito.
	 */
	public static int productosEnCarrito(boolean cantidades) {
		int contadorProductos = 0;

		for (int i = 0; i < carrito.length; i++) {
			if (carrito[i][0] != null) {
				if (cantidades == false) {
					// Suma uno al contador
					contadorProductos++;
				} else {
					// Suma la cantidad de ese producto al contador
					contadorProductos = contadorProductos + Integer.parseInt(carrito[i][4]);

				}
			}
		}
		return contadorProductos;
	}

	/**
	 * Función para calcular los precios totales del carrito. Segun el parametro
	 * valorDevolver, devolvera el precio total sin IVA, el IVA o el precio total
	 * con IVA. Primero calcula el precio sin IVA de todos los productos en la
	 * matriz carrito. Despues, calcula el IVA 21% del precio total Termina, sumando
	 * el iva y el precio total.
	 * 
	 * @param valorDevolver Puede ser "iva","preciosiniva" o "preciosconiva"
	 * @return si el valorDevolver es "iva", devuelve el valor del iva. Si el
	 *         valorDevolver es "preciosiniva", devuelve el precio sin IVA. Si el
	 *         valorDevolver es "precioconiva", devuelve el precio con IVA
	 */
	public static double calcularPrecio(String valorDevolver) {
		double precioSinIva = 0;
		// Recorrer carrito
		for (int i = 0; i < productosEnCarrito(false); i++) {
			// Sumar a precioSinIva, el precio * la cantidad
			precioSinIva = precioSinIva + (Float.parseFloat(carrito[i][2]) * Integer.parseInt(carrito[i][4]));
			;
		}
		if (valorDevolver == "preciosiniva") {
			return precioSinIva;
		}
		double iva = (precioSinIva * 21) / 100;
		if (valorDevolver == "iva") {
			return iva;
		}
		double precioConIva = precioSinIva + iva;
		precioConIva = redondearDosDecimales(precioConIva);
		return precioConIva;

	}

	/**
	 * Función para redondear el precio del articulo a dos decimales.
	 * 
	 * @param num El numero a redondear
	 * @return Devuelve el numero redondeado
	 */

	public static double redondearDosDecimales(double num) {
		return Math.round(num * Math.pow(10, 2)) / Math.pow(10, 2);
	}

	/**
	 *
	 * Función que devuelve cual es la cantidad de unidades de un producto en la
	 * matriz carrito. En caso de no estar en el carrito,devuelve 0.
	 * 
	 * @param codigo El codigo a buscar en la matriz productos.
	 * @return Devuelve la cantidad de un producto en el carrito.
	 */
	public static int cantidadProductoEnCarritoPorCodigo(String codigo) {
		int cantidad = 0;
		int numerocarritos = productosEnCarrito(false);
		for (int i = 0; i < numerocarritos; i++) {
			if (carrito[i][0].equals(codigo)) {
				cantidad = Integer.parseInt(carrito[i][4]);
			}
		}
		return cantidad;
	}

	/**
	 *
	 * Función que identifica en que posicion de la matriz carrito esta el producto
	 * que coincide con el parametro codigo. En caso de no exisir, devuelve -1
	 * 
	 * @param codigo El codigo a buscar en la matriz productos.
	 * @return La posicion del producto en la matriz carrito. En caso de no exisir,
	 *         devuelve -1.
	 */
	public static int posicionProductoEnCarritoPorCodigo(String codigo) {
		int posicion = -1;
		int numerocarritos = productosEnCarrito(false);
		for (int i = 0; i < numerocarritos; i++) {
			if (carrito[i][0].equals(codigo)) {
				posicion = i;
			}
		}
		return posicion;
	}

	/**
	 * Función para limitar un numero float a 2 decimales y añadirle el simbolo del
	 * euro.
	 * 
	 * @param precio Valor del precio a cambiar
	 * @return Precio formateado con 2 decimales con euros.
	 */
	public static String formatearPrecio(float precio) {
		return String.format("%.2f", precio) + "€";
	}

	/**
	 * Función que sirve para pedir el dinero con el que quieres pagar. En caso de
	 * no escribir un numero con decimales, la función se repite.
	 * 
	 * @return Devuelve el dinero introducido.
	 */
	public static double pedirDinero() {
		double precio;
		System.out.printf("Introduce la CANTIDAD DE DINERO QUE VAS A INTRODUCIR: ");
		try {
			precio = teclado.nextDouble();
		} catch (InputMismatchException e) {
			teclado.nextLine();
			return pedirDinero();
		}
		precio = redondearDosDecimales(precio);
		return precio;
	}
}