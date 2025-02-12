package ejs_tema3;

public class NOTAS_1 {

	public static void main(String[] args) {
		int[] notas = { 7, 5, 8, 2, 8, 6, 5, 5, 1, 4, 6, 4 };
		int[] notas_aprobado =  new int[12];
		double media;
		double media_aprobado;
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] < 5) notas_aprobado[i] = 5;
			else  notas_aprobado[i] = notas[i];
		}
		System.out.printf("Las NOTAS de los alumnos son: ");
		ImprimirArrayint(notas);
		System.out.printf("\nLas NOTAS de los alumnos APROBANDO serian: ");
		ImprimirArrayint(notas_aprobado);
		media = CalcularMediaArray(notas);
		media_aprobado = CalcularMediaArray(notas_aprobado);
		System.out.printf("\nLa NOTA MEDIA es: %.5s \nLa NOTA MEDIA con todos los alumnos APROBADOS: %.5s", media,
				media_aprobado);

	}
	public static void ImprimirArrayint(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%s ", array[i]);
		}
	}
	public static double CalcularMediaArray(int[] array) {
		double suma = 0;
		for (int i = 0; i < array.length; i++) {
			suma = suma + array[i];
		}
		return suma / array.length;
	}

}
