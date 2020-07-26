package principal.rna;

import java.util.Random;

public class Perceptron {
	private Capa[] red;
	public Perceptron(int entradas, int [] neuronasPorCapa) {
		Random rng = new Random();
		red = new Capa[neuronasPorCapa.length];
		red[0] = new Capa(entradas,neuronasPorCapa.length, rng);
		for (int i = 1; i < neuronasPorCapa.length; i++) {
			red[i] =new Capa(neuronasPorCapa[i-1], neuronasPorCapa[i],rng);
		}
	}
	public float[] salidas(float[] entradas) {
		red[0].Salidas(entradas);
		for (int i = 1; i < red.length; i++) {
			red[i].Salidas(red[i-1].salida); 
		}
		return red[red.length-1].salida;
	}
	public void aprender() {
		for (int i = 0; i < red.length; i++) {
			for (int j = 0; j < red[i].capa.length; j++) {
				red[i].capa[j].aprender();
			}
		}
	}
}
