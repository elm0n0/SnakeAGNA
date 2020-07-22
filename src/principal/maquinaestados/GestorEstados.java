package principal.maquinaestados;

import java.awt.Graphics;

import principal.maquinaestados.estados.GestorJuego;

public class GestorEstados {

	private EstadoJuego[] estados;
	
	private EstadoJuego estadoActual;

	public GestorEstados() {
		super();
		iniciarEstados();
		iniciarEstadoActual();
	}

	private void iniciarEstados() {
		estados = new EstadoJuego[1];
		estados[0] = new GestorJuego();
		
	}

	private void iniciarEstadoActual() {
		estadoActual = estados[0];
		
	}
	
	public void actualizar() {
		estadoActual.actualizar();
	}
	
	public void dibujar(Graphics g) {
		estadoActual.dibujar(g);
	}
	
	public void cambiarEstadoActual(final int nuevoEstado) {
		estadoActual = estados[nuevoEstado];
	}
	
	public EstadoJuego obtenerEstadoActual() {
		return  this.estadoActual;
	}
	
}
