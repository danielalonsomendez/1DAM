package ejs_tema2_repeticiones;

import java.util.Scanner;

public class FIBONACI {
	
	public static void main(String[] args) {
		int n,f0 = 0,f1 = 1;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		n = teclado.nextInt();
		teclado.close();
        if (n == 1) {
            System.out.printf("%d ", f0);
        } 
        else if (n == 2) {
            System.out.printf("%d %d ", f0, f1);
        } 
        else {
            System.out.printf("%d %d ", f0, f1); 
            for (int i = 2; i < n; i++) {
                int fn = f0 + f1; 
                System.out.printf("%d ", fn); 
                f0 = f1;
                f1 = fn;             
                }
        }

	}

}
