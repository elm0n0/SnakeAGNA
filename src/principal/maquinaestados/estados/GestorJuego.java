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
	private final static Tablero t = new Tablero(new Point(Constantes.MARGEN-1,Constantes.MARGEN-1), Constantes.LARGO_TABLERO+1, Constantes.ALTO_TABLERO+1);
	private final static Tablero t2 = new Tablero(new Point(Constantes.MARGEN-1 + Constantes.MARGEN + Constantes.LARGO_TABLERO , Constantes.MARGEN-1), Constantes.LARGO_TABLERO+1, Constantes.ALTO_TABLERO+1);
	List<Tablero> tList = new ArrayList<>(Arrays.asList(new Tablero[] {t,t2}));
	
	List<Tablero> tList2 = construirTableros(8);
	
	@Override
	public void actualizar() {
		for (Tablero t : tList) {
			t.actualizar();
		}
	}

	private List<Tablero> construirTableros(Integer nTableros) {
		// TODO Auto-generated method stub
		return null;
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
