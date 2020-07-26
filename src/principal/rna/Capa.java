package principal.rna;

import java.util.Random;

public class Capa {
	Neurona[] capa;
	Random rng;
	float[] salida;
	public Capa(int entrada,int nNeuronas, Random rng) {
		this.rng = rng;
		this.capa = new Neurona[nNeuronas];
		for (int i = 0; i < nNeuronas; i++) {
			capa[i] =new Neurona(entrada, rng);
		}
	}
	
	public void Salidas (float[] entradas) {
		float[] f = new float[capa.length];
		for (int i = 0; i < capa.length; i++) {
			f[i] = capa[i].Salida(entradas);
		}
		salida = f;
	}
}
