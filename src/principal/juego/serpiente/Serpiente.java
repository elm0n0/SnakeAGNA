package principal.juego.serpiente;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import principal.Constantes;
import principal.Herramientas;
import principal.controles.GestorControles;
import principal.maquinaestados.EstadoJuego;

public class Serpiente implements EstadoJuego {

	List<Cuadrado> serpiente;

	public Serpiente(Point p, int ancho, int alto) {
		super();
		this.serpiente = new ArrayList<>();
		Cuadrado c = crearCabezaSerpiente(p, ancho, alto);
		this.serpiente.add(c);
	}

	private Cuadrado crearCabezaSerpiente(Point p, int ancho, int alto) {
		int altura = (p.y + alto / 2) + (Constantes.MARGEN / 2);
		if (altura % Constantes.ALTO > 0) {
			altura = altura - altura % Constantes.ALTO;
		}
		int anchura = (p.x + ancho / 2) + (Constantes.MARGEN / 2);
		if (anchura % Constantes.LARGO > 0) {
			anchura = anchura - anchura % Constantes.LARGO;
		}
		return new Cuadrado(new Point(anchura, altura));
	}

	@Override
	public void actualizar() {
		colisionSerpiente();
	}

	@Override
	public void dibujar(Graphics g) {
		for (Cuadrado c : serpiente) {
			c.dibujar(g);
		}
	}

	public void mover(Point p) {
		Random rng = new Random();
		int mover = rng.nextInt(4);
		System.out.println(mover);
		switch (mover) {
		case 0:
			if (this.serpiente.get(0).getP().x + Constantes.LARGO < p.x + Constantes.LARGO_TABLERO) {
				Cuadrado c = new Cuadrado(
						new Point(this.serpiente.get(0).getP().x + Constantes.LARGO, this.serpiente.get(0).getP().y));
				this.serpiente.remove(this.serpiente.size() - 1);
				this.serpiente.add(0, c);
			}
			break;
		case 1:
			if (this.serpiente.get(0).getP().x >= p.x + Constantes.LARGO) {
				Cuadrado c = new Cuadrado(
						new Point(this.serpiente.get(0).getP().x - Constantes.LARGO, this.serpiente.get(0).getP().y));
				this.serpiente.remove(this.serpiente.size() - 1);
				this.serpiente.add(0, c);
			}
			break;
		case 2:
			if (this.serpiente.get(0).getP().y - Constantes.ALTO >= p.y) {
				Cuadrado c = new Cuadrado(
						new Point(this.serpiente.get(0).getP().x, this.serpiente.get(0).getP().y - Constantes.ALTO));
				this.serpiente.remove(this.serpiente.size() - 1);
				this.serpiente.add(0, c);
			}
			break;
		case 3:
			if (this.serpiente.get(0).getP().y + Constantes.ALTO < p.y + Constantes.ALTO_TABLERO) {
				Cuadrado c = new Cuadrado(
						new Point(this.serpiente.get(0).getP().x, this.serpiente.get(0).getP().y + Constantes.ALTO));
				this.serpiente.remove(this.serpiente.size() - 1);
				this.serpiente.add(0, c);
			}
			break;
		default:
			break;
		}
	}
	
	public void mover2(Point p) {
		if (GestorControles.teclado.derecha.estaPulsada()
				&& this.serpiente.get(0).getP().x + Constantes.LARGO < p.x + Constantes.LARGO_TABLERO) {
			Cuadrado c = new Cuadrado(
					new Point(this.serpiente.get(0).getP().x + Constantes.LARGO, this.serpiente.get(0).getP().y));
			this.serpiente.remove(this.serpiente.size() - 1);
			this.serpiente.add(0, c);
		}
		if (GestorControles.teclado.izquierda.estaPulsada()
				&& this.serpiente.get(0).getP().x >= p.x + Constantes.LARGO) {
			Cuadrado c = new Cuadrado(
					new Point(this.serpiente.get(0).getP().x - Constantes.LARGO, this.serpiente.get(0).getP().y));
			this.serpiente.remove(this.serpiente.size() - 1);
			this.serpiente.add(0, c);
		}
		if (GestorControles.teclado.arriba.estaPulsada() &&
				this.serpiente.get(0).getP().y - Constantes.ALTO >= p.y) {
			Cuadrado c = new Cuadrado(
					new Point(this.serpiente.get(0).getP().x, this.serpiente.get(0).getP().y - Constantes.ALTO));
			this.serpiente.remove(this.serpiente.size() - 1);
			this.serpiente.add(0, c);
		}
		if (GestorControles.teclado.abajo.estaPulsada()
				&& this.serpiente.get(0).getP().y + Constantes.ALTO < p.y + Constantes.ALTO_TABLERO) {
			Cuadrado c = new Cuadrado(
					new Point(this.serpiente.get(0).getP().x, this.serpiente.get(0).getP().y + Constantes.ALTO));
			this.serpiente.remove(this.serpiente.size() - 1);
			this.serpiente.add(0, c);
		}
	}

	public void comer() {
		for (int i = 0; i < 100; i++) {
			this.serpiente.add(new Cuadrado(this.serpiente.get(0).getP()));
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
