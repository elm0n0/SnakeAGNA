package principal.rna;

import java.io.Console;
import java.util.Random;

public class main2 {

	public static void main(String[] args) {
		Perceptron p = new Perceptron(2, new int[] { 2, 1 });
		boolean sw = true;
		int contador = 0;
		while (sw) {
			contador++;
			sw = false;
			p.aprender();
			System.out.println("----------------------------------");
			System.out.println("1-1 ->" + p.salidas(new float[] { 1, 1 })[0]);
			System.out.println("1-0 ->" + p.salidas(new float[] { 1, 0 })[0]);
			System.out.println("0-1 ->" + p.salidas(new float[] { 0, 1 })[0]);
			System.out.println("0-0 ->" + p.salidas(new float[] { 0, 0 })[0]);

			if (p.salidas(new float[] { 1, 1 })[0] != 0) {

				sw = true;
			}
			if (p.salidas(new float[] { 1, 0 })[0] != 1) {

				sw = true;
			}
			if (p.salidas(new float[] { 0, 1 })[0] != 1) {

				sw = true;
			}
			if (p.salidas(new float[] { 0, 0 })[0] != 0) {

				sw = true;
			}
		}
		System.out.println(contador);
	}
}
