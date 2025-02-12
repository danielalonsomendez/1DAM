package ejs_tema2_repeticiones;

import java.util.Scanner;

public class MEGABYTE {


	public static void main(String[] args) {
		int  bytes, kbytes, mbytes, resto_kbytes, resto_bytes;
		boolean primo = true;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO de BYTES: ");
		bytes = teclado.nextInt();
		mbytes = bytes / (1024*1024);
		resto_kbytes= bytes % (1024*1024);
		
		kbytes = resto_kbytes / 1024;
		resto_bytes = resto_kbytes % 1024;
		System.out.printf("Mbytes: %s \nKbytes: %s\nBytes: %s",mbytes,kbytes,bytes);

		teclado.close();

	}

}
