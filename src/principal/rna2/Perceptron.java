package principal.rna2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Perceptron {

	List<Capa> capas;
	List<Double[]> sigmas;
	List<Double[][]> deltas;
	public Perceptron(int [] Ncapas) {
		capas = new ArrayList<>();
		Random rng = new Random();
		for (int i = 0; i < Ncapas.length; i++) {
			capas.add(new Capa(Ncapas[i], i == 0 ? Ncapas[i] : Ncapas[i-1], rng));
		}
	}
	
	public Double[] activacion(Double[] entradas) {
		Double[] salidas = new Double[0];
		for (int i = 0; i < capas.size(); i++) {
			salidas = capas.get(i).activacion(entradas);
			entradas = salidas;
		}
		return salidas;
	}
	
	// ERROR ->
	public double errorIndividual(Double[] salidaReal, Double[] salidaDeseada) {
		double err = 0;
		for (int i = 0; i < salidaReal.length; i++) {
			err += 0.5 * Math.pow(salidaReal[i] - salidaDeseada[i], 2);
		}
		return err;
	}
	
	public double errorGeneral(List<Double[]> entradas, List<Double[]> salidasDeseadas) {
		double err = 0;
		for (int i = 0; i < entradas.size(); i++) {
			err += errorIndividual(activacion(entradas.get(i)), salidasDeseadas.get(i));
		}
		return err;
	}
	
	public void aprender(List<Double[]> ejemploEntrada, List<Double[]> ejemplSalida, double alpha, double maxError ) {
		double err = Double.MAX_VALUE;
		while(err > maxError) {
			// con esta mierda aprende
			err = errorGeneral(ejemploEntrada, ejemplSalida);
			System.out.println(err);
		}
	}
	
	private void resetDeltas() {
		deltas = new ArrayList<Double[][]>();
		for (int i = 0; i < capas.size(); i++) {
			deltas.add(new Double[capas.get(i).neuronas.size()][capas.get(i).neuronas.get(0).pesos.length]);
			for (int j = 0; j < capas.get(i).neuronas.size(); j++) {
				for (int k = 0; k < capas.get(i).neuronas.get(0).pesos.length; k++) {
					deltas.get(i)[j][k] = 0.0;
				}
			}
		}
	}
	
	public void setPesos(Double alpha) {
		for (int i = 0; i < capas.size(); i++) {
			for (int j = 0; j < capas.get(i).neuronas.size(); j++) {
				for (int k = 0; k < capas.get(i).neuronas.get(j).pesos.length; k++) {
					capas.get(i).neuronas.get(j).pesos[k] -= alpha * deltas.get(i)[j][k];
				}
			}
		}
	}
	
	public void setUmbrales(Double alpha) {
		for (int i = 0; i < capas.size(); i++) {
			for (int j = 0; j < capas.get(i).neuronas.size(); j++) {
					capas.get(i).neuronas.get(j).umbral -= alpha * sigmas.get(i)[j];
			}
		}
	}
	
	public void setSigmas(Double[] salidaDeseada) {
		sigmas = new ArrayList<Double[]>();
		for (int i = 0; i < salidaDeseada.length; i++) {
			sigmas.add(new Double[capas.get(i).neuronas.size()]);
		}
		for (int i = capas.size() -1; i >= 0; i--) {
			for (int j = 0; j < capas.get(i).neuronas.size(); j++) {
				if (i == capas.size() -1) {
					double y = capas.get(i).salida[j];
					sigmas.get(i)[j] = (y - salidaDeseada[j]) * Neurona.SigmoidDerivada(y);
				}else {
					double sum = 0;
					for (int k = 0; k < capas.get(i+1).neuronas.size(); k++) {
						sum += capas.get(i+1).neuronas.get(k).pesos[j] + sigmas.get(i+1)[k];
					}
					sigmas.get(i)[j] = Neurona.SigmoidDerivada(capas.get(i).neuronas.get(j).ultimaActivacion) * sum;
				}
			}
		}
	}
	
	public void setDeltas() {
		for (int i = 1; i < capas.size(); i++) {
			for (int j = 0; j < capas.get(i).neuronas.size(); j++) {
				for (int k = 0; k < capas.get(i).neuronas.get(j).pesos.length; k++) {
					deltas.get(i)[j][k] += sigmas.get(i)[j] * capas.get(i-1).salida[k];
				}
			}
		}
	}
	
	public void propagacionAtras(List<Double[]> inputs, List<Double[]> salidaEsperada, Double alpha ) {
		resetDeltas();
		for (int i = 0; i < inputs.size(); i++) {
			activacion(inputs.get(i));
			setSigmas(salidaEsperada.get(i));
			setDeltas();
			// los umbrales son modificados en cada comprobación
			setUmbrales(alpha);
		}
		// los pesos son modificados por cada vez que aprenda
		setPesos(alpha);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Perceptron [capas=");
		builder.append(capas);
		builder.append(", sigmas=");
		builder.append(sigmas);
		builder.append(", deltas=");
		builder.append(deltas);
		builder.append("]");
		return builder.toString();
	}
	
}
