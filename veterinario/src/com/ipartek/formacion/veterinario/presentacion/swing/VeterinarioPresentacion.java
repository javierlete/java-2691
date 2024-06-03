package com.ipartek.formacion.veterinario.presentacion.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.ipartek.formacion.veterinario.accesodatos.DaoEmpleado;
import com.ipartek.formacion.veterinario.accesodatos.DaoEmpleadoSqlite;
import com.ipartek.formacion.veterinario.entidades.Empleado;

public class VeterinarioPresentacion {

	private Long id = null;

	private JFrame frame;
	private JTable tabla;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfNif;
	private JTextField tfTelefono;
	private JTextField tfSueldoMensual;
	private JTextField tfSeguridadSocial;
	private DefaultTableModel modelo;
	private final static DaoEmpleado dao = new DaoEmpleadoSqlite(); //Fichero();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VeterinarioPresentacion window = new VeterinarioPresentacion();
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
	public VeterinarioPresentacion() {

		modelo = new DefaultTableModel();

		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("NIF");
		modelo.addColumn("Teléfono");
		modelo.addColumn("Sueldo mensual");
		modelo.addColumn("NSS");

		cargarEmpleados();

		initialize();

		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tabla.rowAtPoint(e.getPoint());
				if (fila > -1) {
					id = (Long) modelo.getValueAt(fila, 0);

					Empleado empleado = dao.obtenerPorId(id);

					tfNombre.setText(empleado.getNombre());
					tfApellidos.setText(empleado.getApellidos());
					tfTelefono.setText(empleado.getTelefono());
					tfNif.setText(empleado.getNif());
					tfSueldoMensual.setText(empleado.getSueldoMensual().toString());
					tfSeguridadSocial.setText(empleado.getNss());
				}
			}
		});
	}

	private void cargarEmpleados() {
		modelo.setRowCount(0);

		for (var e : dao.obtenerTodos()) {
			empleadoAFila(e);
		}
	}

	private void empleadoAFila(Empleado e) {
		modelo.addRow(new Object[] { e.getId(), e.getNombre(), e.getApellidos(), e.getNif(), e.getTelefono(),
				e.getSueldoMensual(), e.getNss() });
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 478, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane);

		tabla = new JTable(modelo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tabla);

		splitPane.setLeftComponent(scrollPane);

		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 1;
		gbc_tfNombre.gridy = 0;
		panel.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		tfApellidos = new JTextField();
		GridBagConstraints gbc_tfApellidos = new GridBagConstraints();
		gbc_tfApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_tfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfApellidos.gridx = 1;
		gbc_tfApellidos.gridy = 1;
		panel.add(tfApellidos, gbc_tfApellidos);
		tfApellidos.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("NIF");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		tfNif = new JTextField();
		GridBagConstraints gbc_tfNif = new GridBagConstraints();
		gbc_tfNif.insets = new Insets(0, 0, 5, 0);
		gbc_tfNif.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNif.gridx = 1;
		gbc_tfNif.gridy = 2;
		panel.add(tfNif, gbc_tfNif);
		tfNif.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Teléfono");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		tfTelefono = new JTextField();
		GridBagConstraints gbc_tfTelefono = new GridBagConstraints();
		gbc_tfTelefono.insets = new Insets(0, 0, 5, 0);
		gbc_tfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTelefono.gridx = 1;
		gbc_tfTelefono.gridy = 3;
		panel.add(tfTelefono, gbc_tfTelefono);
		tfTelefono.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Sueldo Mensual");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		tfSueldoMensual = new JTextField();
		GridBagConstraints gbc_tfSueldoMensual = new GridBagConstraints();
		gbc_tfSueldoMensual.insets = new Insets(0, 0, 5, 0);
		gbc_tfSueldoMensual.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSueldoMensual.gridx = 1;
		gbc_tfSueldoMensual.gridy = 4;
		panel.add(tfSueldoMensual, gbc_tfSueldoMensual);
		tfSueldoMensual.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Seguridad Social");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		tfSeguridadSocial = new JTextField();
		GridBagConstraints gbc_tfSeguridadSocial = new GridBagConstraints();
		gbc_tfSeguridadSocial.insets = new Insets(0, 0, 5, 0);
		gbc_tfSeguridadSocial.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSeguridadSocial.gridx = 1;
		gbc_tfSeguridadSocial.gridy = 5;
		panel.add(tfSeguridadSocial, gbc_tfSeguridadSocial);
		tfSeguridadSocial.setColumns(10);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 6;
		panel.add(panel_1, gbc_panel_1);

		JButton btnGuardar = new JButton("Guardar");
		panel_1.add(btnGuardar);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(e -> {
			if (id != null) {
				dao.borrar(id);
				id = null;
				cargarEmpleados();
			}
		});

		btnBorrar.setBackground(Color.RED);
		btnBorrar.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(btnBorrar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var empleado = new Empleado(null, tfNombre.getText(), tfApellidos.getText(), tfNif.getText(),
						tfTelefono.getText(), tfSeguridadSocial.getText(), new BigDecimal(tfSueldoMensual.getText()));

				tfNombre.setText("");
				tfApellidos.setText("");
				tfTelefono.setText("");
				tfNif.setText("");
				tfSeguridadSocial.setText("");
				tfSueldoMensual.setText("");

				if (id != null) {
					empleado.setId(id);
					dao.modificar(empleado);

					id = null;
				} else {
					dao.insertar(empleado);
				}

				// empleadoAFila(empleado);
				cargarEmpleados();
			}
		});

	}

}
