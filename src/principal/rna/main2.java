package principal.rna;

public class main2 {

	public static void main(String[] args) {
		Neurona p = new Neurona(2, 0.5f);
		p.entrenarSalidas();
		float uno = 1F;
		float cero = 0F;
		Float resultado = p.umbral + uno * p.pesos[0] + uno * p.pesos[1];
		System.out.println(uno + ", " + uno + " RES=" + (resultado > 0 ? 1 : 0));
		Float resultado1 = p.umbral + uno * p.pesos[0] + cero * p.pesos[1];
		System.out.println(uno + ", " + cero + " RES=" + (resultado1 > 0 ? 1 : 0));
		Float resultado2 = p.umbral + cero * p.pesos[0] + uno * p.pesos[1];
		System.out.println(cero + ", " + uno + " RES=" + (resultado2 > 0 ? 1 : 0));
		Float resultado3 = p.umbral + cero * p.pesos[0] + cero * p.pesos[1];
		System.out.println(cero + ", " + cero + " RES=" + (resultado3 > 0 ? 1 : 0));
		System.out.println("SALIDA ->");
	}
}
