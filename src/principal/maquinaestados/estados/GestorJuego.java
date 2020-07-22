package principal.maquinaestados.estados;

import java.awt.Graphics;

import principal.juego.manzana.Manzana;
import principal.juego.serpiente.Serpiente;
import principal.maquinaestados.EstadoJuego;

public class GestorJuego implements EstadoJuego {
	
	private final static Serpiente s = new Serpiente();
	private final static Manzana  m = new Manzana(); 
	@Override
	public void actualizar() {
		s.actualizar();
		m.actualizar();
	}

	@Override
	public void dibujar(Graphics g) {
		s.dibujar(g);
		m.dibujar(g);
	}

	public static Serpiente getS() {
		return s;
	}

	public static Manzana getM() {
		return m;
	}
	
	
	
}
