package ejs_tema2_condicionales;

import java.util.Scanner;

public class TABNOTAS {

	public static void main(String[] args) {
		float numero;
		String nota = "NO VÁLIDO";
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la NOTA del ALUMNO: ");
		numero = teclado.nextFloat();
		teclado.close();
		if(numero >= 0 && numero <3) {		
			nota = "MD";	
		} 
		else if(numero >= 3 && numero <5) {	
			nota = "INSF";	
		}  
		else if(numero >= 5 && numero <6) {	
			nota = "SUF";	
			} 
		else if(numero >= 6 && numero <7) {	
			nota = "BIEN";	
			} 
		else if(numero >= 7 && numero <9) {	
			nota = "NOT";	
			} 
		else if(numero >= 9 && numero <=10) {	
			nota = "SOBRE";	
			} 
		System.out.printf("El ALUMNO tiene la siguiente nota: %s (%f).",nota,numero);

	}
}
