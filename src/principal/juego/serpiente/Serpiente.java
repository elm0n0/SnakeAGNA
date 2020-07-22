package principal.juego.serpiente;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import principal.Constantes;
import principal.Herramientas;
import principal.controles.GestorControles;
import principal.maquinaestados.EstadoJuego;
import principal.maquinaestados.estados.GestorJuego;

public class Serpiente implements EstadoJuego {

	List<Cuadrado> serpiente;

	public Serpiente() {
		super();
		this.serpiente = new ArrayList<>();
		Cuadrado c = new Cuadrado(100, 100);
		this.serpiente.add(c);
	}

	@Override
	public void actualizar() {
		mover();
		comer();
		colisionSerpiente();
	}

	@Override
	public void dibujar(Graphics g) {
		for (Cuadrado c : serpiente) {
			c.dibujar(g);
		}
	}

	private void mover() {
		if (GestorControles.teclado.derecha.estaPulsada() 
				&& this.serpiente.get(0).x + Constantes.ANCHO < Constantes.LARGO_MAPA) {
			Cuadrado c = new Cuadrado(this.serpiente.get(0).x + Constantes.ANCHO, this.serpiente.get(0).y);
			this.serpiente.remove(this.serpiente.size() - 1);
			this.serpiente.add(0, c);
		}
		if (GestorControles.teclado.izquierda.estaPulsada()
				&& this.serpiente.get(0).x - Constantes.ANCHO >= 0) {
			Cuadrado c = new Cuadrado(this.serpiente.get(0).x - Constantes.ANCHO, this.serpiente.get(0).y);
			this.serpiente.remove(this.serpiente.size() - 1);
			this.serpiente.add(0, c);
		}
		if (GestorControles.teclado.arriba.estaPulsada() &&
				this.serpiente.get(0).getY() > 0) {
			Cuadrado c = new Cuadrado(this.serpiente.get(0).x, this.serpiente.get(0).y - Constantes.ALTO);
			this.serpiente.remove(this.serpiente.size() - 1);
			this.serpiente.add(0, c);
		}
		if (GestorControles.teclado.abajo.estaPulsada() &&
				this.serpiente.get(0).getY() + Constantes.ALTO < Constantes.ALTO_MAPA) {
			Cuadrado c = new Cuadrado(this.serpiente.get(0).x, this.serpiente.get(0).y + Constantes.ALTO);
			this.serpiente.remove(this.serpiente.size() - 1);
			this.serpiente.add(0, c);
		}
	}

	private void comer() {
		if (Herramientas.comprobarColision(GestorJuego.getS().serpiente.get(0), GestorJuego.getM().getManzana())) {
			this.serpiente.add(new Cuadrado(this.serpiente.get(0).x, this.serpiente.get(0).y));
		}
	}

	private void colisionSerpiente() {
		for (int i = 1; i < serpiente.size() - 1; i++) {
			if (Herramientas.comprobarColision(serpiente.get(0), serpiente.get(i))) {
			}
		}
	}

	public List<Cuadrado> getSerpiente() {
		return serpiente;
	}

	public void setSerpiente(List<Cuadrado> serpiente) {
		this.serpiente = serpiente;
	}

}
