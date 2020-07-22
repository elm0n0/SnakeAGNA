package principal.graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import principal.controles.GestorControles;
import principal.maquinaestados.GestorEstados;

public class SuperficieDibujo extends Canvas {

	private static final long serialVersionUID = 1L;

	private int ancho;
	private int alto;
	public SuperficieDibujo(int ancho, int alto) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		
		setIgnoreRepaint(true);
		setPreferredSize(new Dimension(ancho,alto));
		addKeyListener(GestorControles.teclado);
		setFocusable(true);
		requestFocus();
	}
	
	public void dibujar(GestorEstados ge) {
		BufferStrategy buffer = getBufferStrategy();
		if (buffer == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = buffer.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, ancho, alto);
		ge.dibujar(g);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
		buffer.show();
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	
}
