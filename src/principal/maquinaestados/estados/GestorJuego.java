package principal.maquinaestados.estados;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import principal.Constantes;
import principal.juego.Tablero;
import principal.maquinaestados.EstadoJuego;

public class GestorJuego implements EstadoJuego {
	private final static Tablero t = new Tablero(new Point(Constantes.MARGEN, Constantes.MARGEN),
			Constantes.LARGO_TABLERO - Constantes.MARGEN, Constantes.ALTO_TABLERO - Constantes.MARGEN);
	private final static Tablero t2 = new Tablero(
			new Point((Constantes.MARGEN * 2) +Constantes.LARGO_TABLERO, Constantes.MARGEN),
			Constantes.LARGO_TABLERO - Constantes.MARGEN, Constantes.ALTO_TABLERO - Constantes.MARGEN);
	List<Tablero> tList = new ArrayList<>(Arrays.asList(new Tablero[] { t, t2 }));

	@Override
	public void actualizar() {
		for (Tablero t : tList) {
			t.actualizar();
		}
	}

	@Override
	public void dibujar(Graphics g) {
		for (Tablero t : tList) {
			t.dibujar(g);
		}
	}

	public static Tablero getT() {
		return t;
	}

}
