package principal.rna2;

import java.util.Arrays;
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
		double activacion = umbral;
		for (int i = 0; i < pesos.length; i++) {
			activacion += pesos[i] * entradas[i];
		}
		ultimaActivacion = activacion;
		return Sigmoid(ultimaActivacion);
	}

	public static double Sigmoid(double entrada) {
		return 1 / (1 + Math.exp(-entrada));
	}

	public static double SigmoidDerivada(double entrada) {
		double y = Sigmoid(entrada);
		return y * (1 - y);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Neurona [pesos=");
		builder.append(Arrays.toString(pesos));
		builder.append(", umbral=");
		builder.append(umbral);
		builder.append(", ultimaActivacion=");
		builder.append(ultimaActivacion);
		builder.append("]");
		return builder.toString();
	}

}
