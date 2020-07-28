package principal.rna;

import java.util.ArrayList;
import java.util.List;

import principal.rna2.Perceptron;

public class main2 {

	public static void main(String[] args) {
//		Perceptron p = new Perceptron(2, new int[] { 2, 1 });
//		boolean sw = true;
//		int contador = 0;
//		while (sw) {
//			contador++;
//			sw = false;
//			p.aprender();
//			System.out.println("----------------------------------");
//			System.out.println("1-1 ->" + p.salidas(new float[] { 1, 1 })[0]);
//			System.out.println("1-0 ->" + p.salidas(new float[] { 1, 0 })[0]);
//			System.out.println("0-1 ->" + p.salidas(new float[] { 0, 1 })[0]);
//			System.out.println("0-0 ->" + p.salidas(new float[] { 0, 0 })[0]);
//
//			if (p.salidas(new float[] { 1, 1 })[0] != 0) {
//
//				sw = true;
//			}
//			if (p.salidas(new float[] { 1, 0 })[0] != 1) {
//
//				sw = true;
//			}
//			if (p.salidas(new float[] { 0, 1 })[0] != 1) {
//
//				sw = true;
//			}
//			if (p.salidas(new float[] { 0, 0 })[0] != 0) {
//
//				sw = true;
//			}
//		}
//		System.out.println(contador);
		
		// pruebas perceptron generico ->
		List<Double[]> entradas = new ArrayList<>();
		List<Double[]> salidas = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			entradas.add(new Double[] {0.0,0.0});
			salidas.add(new Double[] {0.0});
		}
		
		entradas.get(0)[0] = 0.0; entradas.get(0)[1] = 0.0; salidas.get(0)[0] = 1.0;
		entradas.get(1)[0] = 0.0; entradas.get(1)[1] = 1.0; salidas.get(1)[0] = 0.0;
		entradas.get(2)[0] = 1.0; entradas.get(2)[1] = 0.0; salidas.get(2)[0] = 0.0;
		entradas.get(3)[0] = 1.0; entradas.get(3)[1] = 1.0; salidas.get(3)[0] = 1.0;
		
		
		Perceptron p = new Perceptron(new int[] {entradas.get(0).length, 3, salidas.get(0).length});
		
		System.out.println(p);
		
		
		
		p.aprender(entradas, salidas, 0.3, 0.01);
		
		System.out.println("TERMINÉ");
		
	}
}
