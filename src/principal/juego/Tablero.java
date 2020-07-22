package principal.juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import principal.juego.manzana.Manzana;
import principal.juego.serpiente.Serpiente;
import principal.maquinaestados.EstadoJuego;

public class Tablero implements EstadoJuego {

	Point p;
	int ancho;
	int alto;
	Serpiente s;
	Manzana m;

	public Tablero(Point p, int ancho, int alto) {
		super();
		this.p = p;
		this.ancho = ancho;
		this.alto = alto;
		this.s = crearSerpiente(p,ancho,alto);
		this.m = crearManzana(s);
	}
	
	private Manzana crearManzana(Serpiente s2) {
		Manzana m = new Manzana(s2,p);
		return m;
	}

	private Serpiente crearSerpiente(Point p, int ancho, int alto) {
		return new Serpiente(p,ancho,alto);
	}

	@Override
	public void actualizar() {
		s.actualizar();
		s.mover(p);
		m.actualizar();
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawRect(p.x, p.y, ancho, alto);
		s.dibujar(g);
		m.dibujar(g);
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public Serpiente getS() {
		return s;
	}

	public void setS(Serpiente s) {
		this.s = s;
	}

	public Manzana getM() {
		return m;
	}

	public void setM(Manzana m) {
		this.m = m;
	}

}
