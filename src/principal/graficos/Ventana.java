package principal.graficos;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Ventana extends JFrame{

	private static final long serialVersionUID = 1L;

	String titulo;

	public Ventana(final String titulo, final SuperficieDibujo sd) throws HeadlessException {
		super();
		this.titulo = titulo;
		configurarVentana(sd);
		
	}

	private void configurarVentana(final SuperficieDibujo sd) {
		setTitle(titulo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		//setIconImage(image);
		setLayout(new BorderLayout());
		add(sd, BorderLayout.CENTER);
		//setUndecorated(true);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
