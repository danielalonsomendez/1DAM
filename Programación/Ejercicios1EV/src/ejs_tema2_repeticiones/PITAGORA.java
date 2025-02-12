package ejs_tema2_repeticiones;

import java.util.Scanner;

public class PITAGORA {
	public static void main(String[] args) {
for(int z = 1; z<=50;z++) {
	for(int x = 1; x<=z-1;x++) {
		for(int y = x+1; y<=z-1;y++) {  
			if (z * z == x * x + y * y) {
			System.out.printf("%s,%s,%s\n", x, y,z);

        }

		}
	}
}
	}
}
