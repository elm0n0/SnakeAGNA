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
			capas.add(new Capa(i == 0 ? Ncapas[i] : Ncapas[i-1] , Ncapas[i], rng));
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
			err += 0.5 * Math.pow(salidaReal[i], salidaDeseada[i]);
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
		}
	}
	
	private void resetDeltas() {
		deltas = new ArrayList<Double[][]>();
		for (int i = 0; i < capas.size(); i++) {
			deltas.add(new Double[capas.get(i).neuronas.size()][capas.get(i).neuronas.get(0).pesos.length]);
			for (int j = 0; j < capas.get(i).neuronas.size(); j++) {
				for (int k = 0; k < capas.get(i).neuronas.get(0).pesos.length; k++) {
					
				}
			}
		}
	}
	
	public void propagacionAtras() {
		
	}
	
}
