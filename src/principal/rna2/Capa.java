package principal.rna2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Capa {

	List<Neurona> neuronas;
	
	Double[] salida;
	
	public Capa(int Nneuronas, int Nentradas, Random rng) {
		neuronas = new ArrayList<>();
		for (int i = 0; i < Nneuronas; i++) {
			neuronas.add(new Neurona(Nentradas, rng));
		}
	}
	
	public Double[] activacion(Double[] entradas) {
		List<Double> salidas = new ArrayList<>();
		for (int i = 0; i < neuronas.size(); i++) {
			salidas.add(neuronas.get(i).Activacion(entradas));
		}
		Double[] salida = new Double[salidas.size()];
		this.salida = salidas.toArray(salida);
		return salida; 
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Capa [neuronas=");
		builder.append(neuronas);
		builder.append(", salida=");
		builder.append(Arrays.toString(salida));
		builder.append("]");
		return builder.toString();
	}
	
}
