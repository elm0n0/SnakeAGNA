package principal.juego.serpiente;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import principal.Constantes;
import principal.maquinaestados.EstadoJuego;

public class Cuadrado implements EstadoJuego{
	
	Point p;
	int altura;
	int anchura;
	public Cuadrado(Point p) {
		super();
		this.p = p;
		this.altura = Constantes.ALTO;
		this.anchura = Constantes.LARGO;
	}
	
	
	
	public Point getP() {
		return p;
	}



	public void setP(Point p) {
		this.p = p;
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
		g.fillRect(this.p.x, this.p.y, anchura, altura);
	}
}
