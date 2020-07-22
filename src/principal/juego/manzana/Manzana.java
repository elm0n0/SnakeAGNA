package principal.juego.manzana;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import principal.Constantes;
import principal.Herramientas;
import principal.juego.serpiente.Cuadrado;
import principal.maquinaestados.EstadoJuego;
import principal.maquinaestados.estados.GestorJuego;

public class Manzana implements EstadoJuego {

	Cuadrado manzana;

	public Manzana() {
		super();
		crearManzana(true);
	}

	public void crearManzana(boolean isConstructor) {

		if (isConstructor || Herramientas.comprobarColision(GestorJuego.getS().getSerpiente().get(0), manzana)) {
			generarCuadradoAleatorio();
		}
	}
	
	private void generarCuadradoAleatorio() {
		Random rng = new Random();
		int x = rng.nextInt(Constantes.LARGO_MAPA);
		if (x % Constantes.ANCHO > 0) {
			x = x - x % Constantes.ANCHO;
		}
		int y = rng.nextInt(Constantes.ALTO_MAPA);
		if (y % Constantes.ALTO > 0) {
			y = y - y % Constantes.ALTO;
		}
		if (manzana == null) {
			manzana = new Cuadrado(x,y);
		}else {
			manzana.setX(x);
			manzana.setY(y);
		}
		for (Cuadrado s : GestorJuego.getS().getSerpiente()) {
			if(Herramientas.comprobarColision(s, manzana)) {
				generarCuadradoAleatorio();
			}
		}
	}

	@Override
	public void actualizar() {
		crearManzana(false);
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(manzana.getX(), manzana.getY(), manzana.getAnchura(), manzana.getAltura());
	}

	public Cuadrado getManzana() {
		return manzana;
	}

	public void setManzana(Cuadrado manzana) {
		this.manzana = manzana;
	}

}
