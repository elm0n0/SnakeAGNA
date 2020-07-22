package principal.juego.serpiente;

import java.awt.Color;
import java.awt.Graphics;

import principal.Constantes;
import principal.maquinaestados.EstadoJuego;

public class Cuadrado implements EstadoJuego{
	
	int x;
	int y;
	int altura;
	int anchura;
	public Cuadrado(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.altura = Constantes.ALTO;
		this.anchura = Constantes.ANCHO;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getAnchura() {
		return anchura;
	}
	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}
	@Override
	public void actualizar() {
		
	}
	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, anchura, altura);
		
	}
}
