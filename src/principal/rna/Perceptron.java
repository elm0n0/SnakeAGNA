package principal.rna;

public class Perceptron {

	private Neurona neurona;

	public Perceptron(Neurona neurona) {
		super();
		this.neurona = neurona;
	}

	public Float neuronear(Float entrada1, Float entrada2, Float w1, Float w2, Float w3) {
		this.neurona.pesos[0] = w1;
		this.neurona.pesos[1] = w2;
		this.neurona.pesos[2] = w3;
		this.neurona.entrada[0] = entrada1;
		this.neurona.entrada[1] = entrada2;
		Float resultado = w3 + entrada1 * w1 + entrada2 * w2;
		this.neurona.salida = resultado > 0F ? 1F : 0F;
		return this.neurona.salida;
	}

}
