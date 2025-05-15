package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;

public class MainMenuFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelBotones;
	
	//Constantes
	private static final int ALTO = 500;
	private static final int ANCHO = 1000;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuFrame frame = new MainMenuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenuFrame() {
		//Pone el titulo
		setTitle("TestGen");
		//Pone la operacion por defecto al darle a la X -> salir del programa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Establece el ancho y el alto de la ventana
		setSize(ANCHO,ALTO);
		panelBotones = new JPanel();
		panelBotones.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelBotones);
		panelBotones.setLayout(new GridLayout(0, 4, 0, 0));
		
		//Etiqueta de texto
		JLabel lblNewLabel = new JLabel("Generador de Exámenes Tipo Test");
		panelBotones.add(lblNewLabel);
		
		//Boton Anhadir Pregunta
		JButton btnAnhadirPregunta = new JButton("Añadir Pregunta");
		panelBotones.add(btnAnhadirPregunta);
		
		//Boton Generar Examen
		JButton btnGenerarExamen = new JButton("Generar Examen");
		panelBotones.add(btnGenerarExamen);
		
		//Boton Salir
		JButton btnSalir = new JButton("Salir");
		panelBotones.add(btnSalir);
		//Evento de botonSalir: salir del programa
		btnSalir.addActionListener(e -> System.exit(NORMAL));
		
	}

}
