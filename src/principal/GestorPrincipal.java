package principal;

import principal.graficos.SuperficieDibujo;
import principal.graficos.Ventana;
import principal.maquinaestados.GestorEstados;

public class GestorPrincipal {

	private boolean enFuncionamiento = false;
	
	private String titulo;
	
	private int ancho;
	
	private int alto;
	
	private SuperficieDibujo sd;
	
	private Ventana v;
	
	private GestorEstados ge;
	
	
	public GestorPrincipal(String titulo, int alto, int ancho) {
		super();
		this.titulo = titulo;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public static void main(String[] args) {
		GestorPrincipal gp = new GestorPrincipal(Constantes.TITULO, Constantes.ALTO_MAPA, Constantes.LARGO_MAPA);
		
		gp.iniciarJuego();
		gp.iniciarBuclePrincipal();
	}

	private void iniciarJuego() {
		this.enFuncionamiento = true;
		this.inicializar();
		
	}

	private void inicializar() {
		sd = new SuperficieDibujo(ancho,alto);
		v = new Ventana("HOLA", sd);
		ge = new GestorEstados();
		
	}

	private void iniciarBuclePrincipal() {
		int aps = 0;
		int fps = 0;
		final int NS_POR_SEGUNDO = 1000000000;
		final int APS_OBJETIVO = Constantes.VELOCIDAD;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();
		
		double tiempoTranscurrido;
		double delta = 0;
		
		while (enFuncionamiento) {
			final long inicioBucle = System.nanoTime();
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			
			referenciaActualizacion = inicioBucle;
			
			delta+= tiempoTranscurrido / NS_POR_ACTUALIZACION;
			
			while (delta >= 1) {
				Actualizar();
				aps++;
				delta--;
			}
			dibujar();
			fps++;
			
			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				//System.out.println("fps:"+ fps +" aps:"+ aps);
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
			
		}	
	}

	private void Actualizar() {
		ge.actualizar();
		
	}
	
	private void dibujar() {
		sd.dibujar(ge);
	}

}
