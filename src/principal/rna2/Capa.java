package principal.rna2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Capa {

	List<Neurona> neuronas;
	
	Double[] salidas;
	
	public Capa(int Nentradas, int Nneuronas, Random rng) {
		neuronas = new ArrayList<>();
		for (int i = 0; i < Nneuronas; i++) {
			neuronas.add(new Neurona(Nentradas, rng));
		}
	}
	
	public Double[] activacion(Double[] entradas) {
		salidas = new Double[entradas.length];
		for (int i = 0; i < entradas.length; i++) {
			salidas[i] = neuronas.get(i).Activacion(entradas);
		}
		return salidas;
	}
	
}
