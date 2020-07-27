package principal.rna2;

import java.util.Random;

public class Neurona {

	double[] pesos;

	public double umbral;

	public double ultimaActivacion;
	
	public Neurona(int nEntradas, Random rng) {
		umbral = rng.nextDouble();
		pesos = new double[nEntradas];
		for (int i = 0; i < pesos.length; i++) {
			pesos[i] = rng.nextDouble();
		}
	}
	
	public double Activacion(Double[] entradas) {
		double ultimaActivacion = umbral;
		for (int i = 0; i < entradas.length; i++) {
			ultimaActivacion += entradas[i] * pesos[i];
		}
		return Sigmoid(ultimaActivacion);
	}

	public static double Sigmoid(double entrada) {
		return 1 / (1 + Math.exp(-entrada));
	}

	public static double SigmoidDerivada(double entrada) {
		double y = Sigmoid(entrada);
		return y * (1 - y);
	}

}
