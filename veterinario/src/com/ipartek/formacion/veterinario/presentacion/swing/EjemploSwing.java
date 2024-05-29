package com.ipartek.formacion.veterinario.presentacion.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EjemploSwing {

	private JFrame frame;
	private JTextField tfNombre;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploSwing window = new EjemploSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EjemploSwing() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(10, 11, 315, 20);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JButton btnSaludar = new JButton("Saludar");
		btnSaludar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResultado.setText("Hola " + tfNombre.getText());
			}
		});
		btnSaludar.setBounds(335, 10, 89, 23);
		frame.getContentPane().add(btnSaludar);
		
		lblResultado = new JLabel("Dime tu nombre para que te salude");
		lblResultado.setBounds(10, 42, 414, 14);
		frame.getContentPane().add(lblResultado);
	}
}
