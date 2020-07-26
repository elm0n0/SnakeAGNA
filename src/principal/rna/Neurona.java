package principal.rna;

import java.util.Arrays;
import java.util.Random;

public class Neurona {

	float[] pesos;
	float umbral;
	float[] pesosA;
	float umbralA;
	float[] entrada;
	float tasaDeAprendizaje;
	float salida;
	Random rng;
	
	public Neurona(int Nentradas, Random rng) {
		super();
		pesosA = new float[Nentradas];
		pesos = new float[Nentradas];
		tasaDeAprendizaje = 0.3F;
		this.rng = rng;
		aprender();
	}
	
	public Neurona(int Nentradas, Random rng, float ta) {
		super();
		pesosA = new float[Nentradas];
		pesos = new float[Nentradas];
		tasaDeAprendizaje = ta;
		this.rng = rng;
		aprender();
	}

	// ERROR = LO QUE NECESITAMOS - LO QUE TENEMOS

	// tasa de aprendizaje ? 0.3F

	// ajuste de error ->
	// peso = pesoanterior + tasa de aprendizaje * error * entrada;

	public float Salida(float[] entradas) {
		return sigmoid(sumaPonderada(entradas));
	}

	private float sumaPonderada(float[] entradas) {

		float sum = 0;

		for (int i = 0; i < entradas.length; i++) {
			sum += entradas[i] * pesos[i];
		}
		sum += umbral;
		return sum;
	}

	float sigmoid(float d) {
		return d > 0 ? 1 : 0;
	}
	
	public void aprender() {
		for (int i = 0; i < pesos.length; i++) {
			pesosA[i] = rng.nextFloat() - rng.nextFloat(); 
		}
		umbralA = rng.nextFloat() - rng.nextFloat();
		pesos = pesosA;
		umbral = umbralA;
	}
	
	public void aprender(float[] entradas, float salidaEsperada) {
		if (pesosA != null) {
			float error = salidaEsperada - salidas(entradas);
			for (int i = 0; i < pesos.length; i++) {
				pesos[i] = pesosA[i] + tasaDeAprendizaje * error * entradas[i];
			}
			umbral = umbralA + tasaDeAprendizaje * error;
			pesosA = pesos;
			umbralA = umbral;
		} else {
			Random rng = new Random();
			for (int i = 0; i < entradas.length; i++) {
				pesosA[i] = rng.nextFloat() - rng.nextFloat(); 
			}
			umbralA = rng.nextFloat() - rng.nextFloat();
			pesosA = pesos;
			umbralA = umbral;
		}
	}

	public void entrenarSalidas() {
		int contador = 0;
		boolean sw = false;
		while (!sw) {
			sw = true;
			contador++;
			// peso = pesoAnterior + tasa de aprendizaje * error * entrada;
			if (salidas(new float[] {1f,1f}) != 1) {
//				aprender(new float[] {1f,1f}, 1);
				aprender();
				sw = false;
			}
			if (salidas(new float[] {1f,0f}) != 0) {
//				aprender(new float[] {1f,0f}, 0);
				aprender();
				sw = false;
			}
			if (salidas(new float[] {0f,1f}) != 0) {
//				aprender(new float[] {0f,1f}, 0);
				aprender();
				sw = false;
			}
			if (salidas(new float[] {0f,0f}) != 0) {
//				aprender(new float[] {0f,0f}, 0);
				aprender();
				sw = false;
			}
			StringBuilder builder = new StringBuilder();
			builder.append("Neurona [pesos=");
			builder.append(Arrays.toString(pesos));
			builder.append(", umbral=");
			builder.append(umbral);
			builder.append(", entrada=");
			builder.append(Arrays.toString(entrada));
			builder.append(", salida=");
			builder.append(salida);
			builder.append("]");
			System.out.println(builder.toString());
		}
		System.out.println(contador);
	}

	private float salidas(float[] entradas) {
		return sigmoid(umbral + entradas[0] * pesos[0] + entradas[1] * pesos[1]);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Neurona [pesos=");
		builder.append(Arrays.toString(pesos));
		builder.append(", umbral=");
		builder.append(umbral);
		builder.append(", entrada=");
		builder.append(Arrays.toString(entrada));
		builder.append(", salida=");
		builder.append(salida);
		builder.append("]");
		return builder.toString();
	}

}
