package principal;

import principal.juego.serpiente.Cuadrado;

public class Herramientas {

	public static boolean comprobarColision(Cuadrado a, Cuadrado b) {
		int x1 = a.getP().x;
		int y1 = a.getP().y;
		int w1 = a.getAnchura()-1;
		int h1 = a.getAltura()-1;

		int x2 = b.getP().x;
		int y2 = b.getP().y;
		int w2 = b.getAnchura()-1;
		int h2 = b.getAnchura()-1;
		if (x1 > x2 + w2) {
			return false;
		} else if (x1 + w1 < x2) {
			return false;
		} else if (y1 > y2 + h2) {
			return false;
		} else if (y1 + h1 < y2) {
			return false;
		}
		return true;
	}
}
