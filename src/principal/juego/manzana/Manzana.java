package principal.juego.manzana;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import principal.Constantes;
import principal.Herramientas;
import principal.juego.serpiente.Cuadrado;
import principal.juego.serpiente.Serpiente;
import principal.maquinaestados.EstadoJuego;

public class Manzana implements EstadoJuego {

	Cuadrado manzana;

	Serpiente s;

	Point p;

	public Manzana(Serpiente s, Point p) {
		super();
		this.s = s;
		this.p = p;
		crearManzana(true, s, p);
	}

	public void crearManzana(boolean isConstructor, Serpiente s, Point p) {

		if (isConstructor || Herramientas.comprobarColision(s.getSerpiente().get(0), manzana)) {
			generarCuadradoAleatorio(s, p);
			s.comer();
		}
	}

	private void generarCuadradoAleatorio(Serpiente s, Point p) {
		Random rng = new Random();
		int x = rng.nextInt(Constantes.LARGO_TABLERO) + p.x;
		if (x % Constantes.LARGO > 0) {
			x = x - x % Constantes.LARGO;
		}
		int y = rng.nextInt(Constantes.ALTO_TABLERO) + p.y;
		if (y % Constantes.ALTO > 0) {
			y = y - y % Constantes.ALTO;
		}
		if (manzana == null) {
			manzana = new Cuadrado(new Point(x, y));
		} else {
			manzana.setP(new Point(x, y));
		}
		for (Cuadrado act : s.getSerpiente()) {
			if (Herramientas.comprobarColision(act, manzana)) {
				generarCuadradoAleatorio(s, p);
			}
		}
	}

	@Override
	public void actualizar() {
		crearManzana(false, s, p);
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(manzana.getP().x, manzana.getP().y, manzana.getAnchura(), manzana.getAltura());
	}

	public Cuadrado getManzana() {
		return manzana;
	}

	public void setManzana(Cuadrado manzana) {
		this.manzana = manzana;
	}

}
