package principal.controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener{
	
	public Tecla arriba = new Tecla();
	public Tecla abajo = new Tecla();
	public Tecla izquierda = new Tecla();
	public Tecla derecha = new Tecla();
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			if (!abajo.estaPulsada()) {
				arriba.teclaPulsada();
				abajo.teclaLiberada();
				derecha.teclaLiberada();
				izquierda.teclaLiberada();
			}
			break;
		case KeyEvent.VK_S:
			if (!arriba.estaPulsada()) {
				arriba.teclaLiberada();
				abajo.teclaPulsada();
				derecha.teclaLiberada();
				izquierda.teclaLiberada();
			}
			break;
		case KeyEvent.VK_A:
			if (!derecha.estaPulsada()) {
			arriba.teclaLiberada();
			abajo.teclaLiberada();
			derecha.teclaLiberada();
			izquierda.teclaPulsada();
			}
			break;
		case KeyEvent.VK_D:
			if (!izquierda.estaPulsada()) {
			arriba.teclaLiberada();
			abajo.teclaLiberada();
			derecha.teclaPulsada();
			izquierda.teclaLiberada();
			}
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
	}
	
}
