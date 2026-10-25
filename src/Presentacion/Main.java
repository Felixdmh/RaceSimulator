package Presentacion;

import java.awt.EventQueue;

import java.nio.file.Files;

import java.nio.file.StandardCopyOption;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import Modelo.Vehiculo;

import Negocio.GestorVehiculos;

import Negocio.ResultadoCarrera;

import Negocio.SimuladorCarrera;

import javax.swing.JLabel;

import java.awt.Font;

import java.awt.Image;

import javax.swing.DefaultListModel;

import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;

import java.io.File;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

import java.awt.event.ActionEvent;

import javax.swing.JSpinner;

import javax.swing.SpinnerNumberModel;

import javax.swing.JComboBox;

import javax.swing.JFileChooser;

import javax.swing.JProgressBar;

import javax.swing.JList;
import javax.swing.JScrollPane;

import javax.swing.JOptionPane;

import javax.swing.event.ListSelectionListener;

import javax.swing.event.ListSelectionEvent;

import javax.swing.JTextField;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JPanel PanelMenu, PanelCatalogo, PanelSimular;

	private JLabel lblNombre1, lblNombre2, lblImgIzq, lblImgDer, lblFondoCabecera, lblFondoMenu, lblFondoCabecera_1,
	lblFondoCatalogo, lblVistaCocheCatalogo, lblCatalogo;

	private JList listCatalogo;

	private List<Vehiculo> vehiculos;

	private JButton btnSalir, btnCatalogo, btnSimular, btnNewButton, btnIniciar, btnSalir2;

	private JLabel lblDistancia, lblKms, lblCoche1, lblCoche2, lblGanador1, lblGanador2, lblFondoCabecera2,
	lblFondoSimular;

	private JComboBox cbCoche1, cbCoche2;

	private JLabel lblNombreCarreraC2, lblNombreCarreraC1, lblMarca1, lblGeneracion1, lblPotencia1, lblParNm1,
	lblMarca2, lblGeneracion2, lblPotencia2, lblParNm2;

	private JProgressBar pbCoche1, pbCoche2;

	private JLabel lblImgIzq2;

	private JLabel lblImgDer2;

	private JLabel lblImgIzq3;

	private JLabel lblPotenciaCv, lblPotenciaTxt, lblGeneracion, lblGeneracionTxt, lblParMotor, lblParMotorTxt, lblPeso,
	lblPesoTxt, lblTraccion, lblTraccionTxt, lblAceleracion, lblAceleracionTxt, lblVelocidadMax,
	lblVelocidadMaxTxt, lblTransmision, lblTransmisionTxt, lblMarca, lblMarcaTxt, lblModelo, lblModeloTxt;

	private GestorVehiculos gestorVehiculos;

	private JButton distancia2;

	private JButton distancia3;

	private JButton btnAnadir;

	private File imagenSeleccionada;

	public static int distancia = 1; // Varible global para almacenar la distancia seleccionada por el usuario

	private JButton distancia5;

	private JPanel PanelAnadir;

	private JTextField textMarcaAn;

	private JTextField textParAn;

	private JTextField textModeloAn;

	private JTextField textGeneracionAn;

	private JTextField textPotenciaAn;

	private JTextField textPesoAn;

	private JTextField textAceleracionAn;

	private JTextField textVelMaxAn;

	private JTextField textCoeficienteAn;

	private JTextField textMarchasAn;

	private JLabel lblPesoAn_2, lblFondoCatalogo_1, lblImgIzq2_1, lblImgDer2_1, lblFondoCabecera_1_1, lblAnadir,
	lblMarcaAn, lblParAn, lblModelo_1, lblGeneracionAn, lblPotenciaAn, lblPesoAn, lblAceleracionAn,
	lblVelocidadMaximaAn, lblCoeficienteAerodinamicoAn, lblMarchasAn;

	private JLabel lblVistaCocheAn;

	private JButton btnAnadiRemplazar, btnConfirmaAnRe, btnSalirAnRe;

	private JComboBox comboBoxTraccion;

	private JComboBox comboBoxCambio;

	/**
	 * 
	 * Launch the application.
	 * 
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Main frame = new Main();

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

	/**
	 * 
	 * Create the frame.
	 * 
	 */

	public Main() {

		gestorVehiculos = new GestorVehiculos();

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1200, 700);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		PanelAnadir = new JPanel();

		PanelAnadir.setVisible(false);

		PanelCatalogo = new JPanel();

		PanelCatalogo.setVisible(false);

		PanelCatalogo.setBounds(0, 0, 1184, 661);

		contentPane.add(PanelCatalogo);

		PanelCatalogo.setLayout(null);

		btnAnadir = new JButton("AÑADIR");

		btnAnadir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				PanelCatalogo.setVisible(false);

				PanelAnadir.setVisible(true);

			}

		});

		lblVistaCocheCatalogo = new JLabel("");

		lblVistaCocheCatalogo.setBounds(452, 298, 315, 180);

		PanelCatalogo.add(lblVistaCocheCatalogo);

		lblCatalogo = new JLabel("CATÁLOGO");

		lblCatalogo.setForeground(new Color(255, 0, 0));

		lblCatalogo.setFont(new Font("Showcard Gothic", Font.PLAIN, 70));

		lblCatalogo.setBounds(419, 41, 363, 106);

		PanelCatalogo.add(lblCatalogo);

		btnAnadir.setBounds(562, 619, 89, 23);

		PanelCatalogo.add(btnAnadir);

		listCatalogo = new JList();

		listCatalogo.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {

					mostrarVehiculoSeleccionado();

				}

			}

		});

		JScrollPane scrollCatalogo = new JScrollPane(listCatalogo);
		scrollCatalogo.setBounds(25, 209, 384, 424);
		PanelCatalogo.add(scrollCatalogo);

		btnNewButton = new JButton("SALIR");

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				PanelCatalogo.setVisible(false);

				PanelMenu.setVisible(true);

			}

		});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));

		btnNewButton.setBounds(452, 560, 315, 48);

		PanelCatalogo.add(btnNewButton);

		lblPotenciaCv = new JLabel("POTENCIA CV:");

		lblPotenciaCv.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblPotenciaCv.setBounds(798, 267, 363, 19);

		PanelCatalogo.add(lblPotenciaCv);

		lblPotenciaTxt = new JLabel("");

		lblPotenciaTxt.setBounds(798, 292, 363, 19);

		PanelCatalogo.add(lblPotenciaTxt);

		lblGeneracion = new JLabel("GENERACIÓN:");

		lblGeneracion.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblGeneracion.setBounds(798, 212, 363, 19);

		PanelCatalogo.add(lblGeneracion);

		lblGeneracionTxt = new JLabel("");

		lblGeneracionTxt.setBounds(798, 237, 363, 19);

		PanelCatalogo.add(lblGeneracionTxt);

		lblParMotor = new JLabel("PAR MOTOR (NM):");

		lblParMotor.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblParMotor.setBounds(798, 322, 363, 19);

		PanelCatalogo.add(lblParMotor);

		lblParMotorTxt = new JLabel("");

		lblParMotorTxt.setBounds(798, 347, 363, 19);

		PanelCatalogo.add(lblParMotorTxt);

		lblPeso = new JLabel("PESO (KG):");

		lblPeso.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblPeso.setBounds(798, 377, 363, 19);

		PanelCatalogo.add(lblPeso);

		lblPesoTxt = new JLabel("");

		lblPesoTxt.setBounds(798, 402, 363, 19);

		PanelCatalogo.add(lblPesoTxt);

		lblTraccion = new JLabel("TRACCIÓN:");

		lblTraccion.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblTraccion.setBounds(798, 432, 363, 19);

		PanelCatalogo.add(lblTraccion);

		lblTraccionTxt = new JLabel("");

		lblTraccionTxt.setBounds(798, 457, 363, 19);

		PanelCatalogo.add(lblTraccionTxt);

		lblAceleracion = new JLabel("ACELERACION 0-100:");

		lblAceleracion.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblAceleracion.setBounds(798, 487, 363, 19);

		PanelCatalogo.add(lblAceleracion);

		lblAceleracionTxt = new JLabel("");

		lblAceleracionTxt.setBounds(798, 512, 363, 19);

		PanelCatalogo.add(lblAceleracionTxt);

		lblVelocidadMax = new JLabel("VELOCIDAD MAXIMA (KM/H):");

		lblVelocidadMax.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblVelocidadMax.setBounds(798, 542, 363, 19);

		PanelCatalogo.add(lblVelocidadMax);

		lblVelocidadMaxTxt = new JLabel("");

		lblVelocidadMaxTxt.setBounds(798, 567, 363, 19);

		PanelCatalogo.add(lblVelocidadMaxTxt);

		lblTransmision = new JLabel("TRANSMISIÓN:");

		lblTransmision.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblTransmision.setBounds(798, 597, 363, 19);

		PanelCatalogo.add(lblTransmision);

		lblTransmisionTxt = new JLabel("");

		lblTransmisionTxt.setBounds(798, 622, 363, 19);

		PanelCatalogo.add(lblTransmisionTxt);

		lblMarca = new JLabel("MARCA:");

		lblMarca.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblMarca.setBounds(425, 211, 62, 22);

		PanelCatalogo.add(lblMarca);

		lblMarcaTxt = new JLabel("");

		lblMarcaTxt.setBounds(497, 212, 291, 19);

		PanelCatalogo.add(lblMarcaTxt);

		lblModelo = new JLabel("MODELO:");

		lblModelo.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblModelo.setBounds(425, 242, 363, 19);

		PanelCatalogo.add(lblModelo);

		lblModeloTxt = new JLabel("");

		lblModeloTxt.setBounds(425, 267, 363, 19);

		PanelCatalogo.add(lblModeloTxt);

		lblImgIzq2 = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/LogoCatalogo2.png"));

		lblImgIzq2.setBounds(0, 0, 232, 176);

		PanelCatalogo.add(lblImgIzq2);

		lblImgDer2 = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/LogoCatalogo1.png"));

		lblImgDer2.setBounds(952, 0, 232, 176);

		PanelCatalogo.add(lblImgDer2);

		lblFondoCatalogo = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/FondoMenu.png"));

		lblFondoCatalogo.setBounds(0, 176, 1184, 485);

		PanelCatalogo.add(lblFondoCatalogo);

		lblFondoCabecera_1 = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/FondoCabecera.png"));

		lblFondoCabecera_1.setBounds(0, 0, 1184, 176);

		PanelCatalogo.add(lblFondoCabecera_1);

		PanelAnadir.setBounds(0, 0, 1184, 661);

		contentPane.add(PanelAnadir);

		PanelAnadir.setLayout(null);

		btnSalirAnRe = new JButton("SALIR");

		btnSalirAnRe.setBounds(774, 617, 315, 23);

		PanelAnadir.add(btnSalirAnRe);

		btnSalirAnRe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				PanelAnadir.setVisible(false);

				PanelCatalogo.setVisible(true);

			}

		});

		btnConfirmaAnRe = new JButton("CONFIRMAR");

		btnConfirmaAnRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (imagenSeleccionada == null) {
						JOptionPane.showMessageDialog(null, "Debes seleccionar una imagen.");
						return;
					}

					if (textMarcaAn.getText().trim().isEmpty() || textModeloAn.getText().trim().isEmpty()
							|| textGeneracionAn.getText().trim().isEmpty() || textPotenciaAn.getText().trim().isEmpty()
							|| textParAn.getText().trim().isEmpty() || textPesoAn.getText().trim().isEmpty()
							|| textAceleracionAn.getText().trim().isEmpty() || textVelMaxAn.getText().trim().isEmpty()
							|| textCoeficienteAn.getText().trim().isEmpty()
							|| textMarchasAn.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos.");
						return;
					}

					vehiculos = new ArrayList<>(gestorVehiculos.obtenerVehiculos());

					int nuevoId = 1;
					for (Vehiculo v : vehiculos) {
						if (v.getId() >= nuevoId) {
							nuevoId = v.getId() + 1;
						}
					}

					String nombreOriginal = imagenSeleccionada.getName();
					int punto = nombreOriginal.lastIndexOf('.');
					String extension = punto >= 0 ? nombreOriginal.substring(punto) : ".png";
					String nombreImagen = "Coche" + nuevoId + extension;

					// La carpeta coincide con la que consulta mostrarVehiculoSeleccionado().
					File carpetaImagenes = new File("src/Resource/ImagenesCoches");
					if (!carpetaImagenes.exists() && !carpetaImagenes.mkdirs()) {
						throw new IOException("No se pudo crear la carpeta de imágenes.");
					}

					File destino = new File(carpetaImagenes, nombreImagen);
					Files.copy(imagenSeleccionada.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

					Vehiculo nuevoVehiculo = new Vehiculo(nuevoId, textMarcaAn.getText().trim(),
							textModeloAn.getText().trim(), textGeneracionAn.getText().trim(),
							Integer.parseInt(textPotenciaAn.getText().trim()),
							Integer.parseInt(textParAn.getText().trim()), Integer.parseInt(textPesoAn.getText().trim()),
							comboBoxTraccion.getSelectedItem().toString(),
							Double.parseDouble(textAceleracionAn.getText().trim()),
							Integer.parseInt(textVelMaxAn.getText().trim()),
							Double.parseDouble(textCoeficienteAn.getText().trim()),
							comboBoxCambio.getSelectedItem().toString(),
							Integer.parseInt(textMarchasAn.getText().trim()), nombreImagen);

					vehiculos.add(nuevoVehiculo);
					gestorVehiculos.guardarVehiculos(vehiculos);
					cargarVehiculos();

					textMarcaAn.setText("");
					textModeloAn.setText("");
					textGeneracionAn.setText("");
					textPotenciaAn.setText("");
					textParAn.setText("");
					textPesoAn.setText("");
					textAceleracionAn.setText("");
					textVelMaxAn.setText("");
					textCoeficienteAn.setText("");
					textMarchasAn.setText("");
					comboBoxTraccion.setSelectedIndex(0);
					comboBoxCambio.setSelectedIndex(0);
					imagenSeleccionada = null;
					lblVistaCocheAn.setIcon(null);

					PanelAnadir.setVisible(false);
					PanelCatalogo.setVisible(true);

					JOptionPane.showMessageDialog(null, "Vehículo añadido correctamente.");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Los campos numéricos contienen valores incorrectos.");
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error al guardar el vehículo: " + ex.getMessage());
				}
			}
		});

		btnConfirmaAnRe.setBounds(774, 583, 315, 23);

		PanelAnadir.add(btnConfirmaAnRe);

		btnAnadiRemplazar = new JButton("AÑADIR / REEMPLAZAR IMAGEN");

		btnAnadiRemplazar.setBounds(774, 543, 315, 23);

		PanelAnadir.add(btnAnadiRemplazar);

		btnAnadiRemplazar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JFileChooser selector = new JFileChooser();

				int resultado = selector.showOpenDialog(null);

				if (resultado == JFileChooser.APPROVE_OPTION) {

					imagenSeleccionada = selector.getSelectedFile();

					ImageIcon imagen = new ImageIcon(

							imagenSeleccionada.getAbsolutePath()

							);

					Image imagenRedimensionada = imagen.getImage()

							.getScaledInstance(

									lblVistaCocheAn.getWidth(),

									lblVistaCocheAn.getHeight(),

									Image.SCALE_SMOOTH

									);

					lblVistaCocheAn.setIcon(

							new ImageIcon(imagenRedimensionada)

							);

				}

			}

		});

		lblVistaCocheAn = new JLabel("");

		lblVistaCocheAn.setBounds(774, 319, 315, 180);

		PanelAnadir.add(lblVistaCocheAn);

		lblPesoAn = new JLabel("tracción:");

		lblPesoAn.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblPesoAn.setBounds(692, 187, 232, 33);

		PanelAnadir.add(lblPesoAn);

		textMarcaAn = new JTextField();

		textMarcaAn.setBounds(20, 231, 326, 33);

		PanelAnadir.add(textMarcaAn);

		textMarcaAn.setColumns(10);

		lblMarcaAn = new JLabel("Marca:");

		lblMarcaAn.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblMarcaAn.setBounds(20, 187, 326, 33);

		PanelAnadir.add(lblMarcaAn);

		lblAnadir = new JLabel("CREAR VEHICULO");

		lblAnadir.setForeground(Color.RED);

		lblAnadir.setFont(new Font("Showcard Gothic", Font.PLAIN, 70));

		lblAnadir.setBounds(297, 45, 575, 106);

		PanelAnadir.add(lblAnadir);

		lblImgIzq2_1 = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/LogoCatalogo2.png"));

		lblImgIzq2_1.setBounds(0, 0, 232, 176);

		PanelAnadir.add(lblImgIzq2_1);

		lblImgDer2_1 = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/LogoCatalogo1.png"));

		lblImgDer2_1.setBounds(952, 0, 232, 176);

		PanelAnadir.add(lblImgDer2_1);

		lblFondoCabecera_1_1 = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/FondoCabecera.png"));

		lblFondoCabecera_1_1.setBounds(0, 0, 1184, 176);

		PanelAnadir.add(lblFondoCabecera_1_1);

		lblParAn = new JLabel("Par motor nm:");

		lblParAn.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblParAn.setBounds(20, 539, 326, 33);

		PanelAnadir.add(lblParAn);

		textParAn = new JTextField();

		textParAn.setColumns(10);

		textParAn.setBounds(20, 583, 326, 33);

		PanelAnadir.add(textParAn);

		lblModelo_1 = new JLabel("Modelo:");

		lblModelo_1.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblModelo_1.setBounds(20, 275, 326, 33);

		PanelAnadir.add(lblModelo_1);

		textModeloAn = new JTextField();

		textModeloAn.setColumns(10);

		textModeloAn.setBounds(20, 319, 326, 33);

		PanelAnadir.add(textModeloAn);

		lblGeneracionAn = new JLabel("Generación:");

		lblGeneracionAn.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblGeneracionAn.setBounds(20, 363, 326, 33);

		PanelAnadir.add(lblGeneracionAn);

		textGeneracionAn = new JTextField();

		textGeneracionAn.setColumns(10);

		textGeneracionAn.setBounds(20, 407, 326, 33);

		PanelAnadir.add(textGeneracionAn);

		lblPotenciaAn = new JLabel("Potencia CV:");

		lblPotenciaAn.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblPotenciaAn.setBounds(20, 451, 326, 33);

		PanelAnadir.add(lblPotenciaAn);

		textPotenciaAn = new JTextField();

		textPotenciaAn.setColumns(10);

		textPotenciaAn.setBounds(20, 495, 326, 33);

		PanelAnadir.add(textPotenciaAn);

		lblPesoAn = new JLabel("Peso kg:");

		lblPesoAn.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblPesoAn.setBounds(356, 187, 326, 33);

		PanelAnadir.add(lblPesoAn);

		textPesoAn = new JTextField();

		textPesoAn.setColumns(10);

		textPesoAn.setBounds(356, 231, 326, 33);

		PanelAnadir.add(textPesoAn);

		lblAceleracionAn = new JLabel("Aceleración:");

		lblAceleracionAn.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblAceleracionAn.setBounds(356, 275, 326, 33);

		PanelAnadir.add(lblAceleracionAn);

		textAceleracionAn = new JTextField();

		textAceleracionAn.setColumns(10);

		textAceleracionAn.setBounds(356, 319, 326, 33);

		PanelAnadir.add(textAceleracionAn);

		lblVelocidadMaximaAn = new JLabel("Velocidad maxima:");

		lblVelocidadMaximaAn.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblVelocidadMaximaAn.setBounds(356, 363, 326, 33);

		PanelAnadir.add(lblVelocidadMaximaAn);

		textVelMaxAn = new JTextField();

		textVelMaxAn.setColumns(10);

		textVelMaxAn.setBounds(356, 407, 326, 33);

		PanelAnadir.add(textVelMaxAn);

		lblCoeficienteAerodinamicoAn = new JLabel("Coeficiente Aerodinamico:");

		lblCoeficienteAerodinamicoAn.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblCoeficienteAerodinamicoAn.setBounds(356, 451, 326, 33);

		PanelAnadir.add(lblCoeficienteAerodinamicoAn);

		textCoeficienteAn = new JTextField();

		textCoeficienteAn.setColumns(10);

		textCoeficienteAn.setBounds(356, 495, 326, 33);

		PanelAnadir.add(textCoeficienteAn);

		lblMarchasAn = new JLabel("numero de marchas:");

		lblMarchasAn.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblMarchasAn.setBounds(356, 539, 326, 33);

		PanelAnadir.add(lblMarchasAn);

		textMarchasAn = new JTextField();

		textMarchasAn.setColumns(10);

		textMarchasAn.setBounds(356, 583, 326, 33);

		PanelAnadir.add(textMarchasAn);

		comboBoxTraccion = new JComboBox();

		comboBoxTraccion.setBounds(692, 231, 232, 33);

		PanelAnadir.add(comboBoxTraccion);

		comboBoxTraccion.addItem("Delantera");

		comboBoxTraccion.addItem("Trasera");

		comboBoxTraccion.addItem("Total");

		comboBoxCambio = new JComboBox();

		comboBoxCambio.setBounds(934, 231, 232, 33);

		PanelAnadir.add(comboBoxCambio);

		comboBoxCambio.addItem("Manual");

		comboBoxCambio.addItem("Automática");

		lblPesoAn_2 = new JLabel("cambio:");

		lblPesoAn_2.setFont(new Font("Showcard Gothic", Font.ITALIC, 15));

		lblPesoAn_2.setBounds(934, 187, 232, 33);

		PanelAnadir.add(lblPesoAn_2);

		lblFondoCatalogo_1 = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/FondoMenu.png"));

		lblFondoCatalogo_1.setBounds(0, 176, 1184, 485);

		PanelAnadir.add(lblFondoCatalogo_1);

		PanelMenu = new JPanel();

		PanelMenu.setBounds(0, 0, 1184, 661);

		contentPane.add(PanelMenu);

		PanelMenu.setLayout(null);

		btnSalir = new JButton("SALIR");

		btnSalir.setForeground(new Color(255, 255, 255));

		btnSalir.setBackground(new Color(0, 0, 0));

		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));

		btnSalir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}

		});

		btnSalir.setBounds(373, 498, 410, 91);

		PanelMenu.add(btnSalir);

		btnCatalogo = new JButton("CATÁLOGO");

		btnCatalogo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				PanelMenu.setVisible(false);

				PanelCatalogo.setVisible(true);

			}

		});

		btnCatalogo.setForeground(new Color(255, 255, 255));

		btnCatalogo.setBackground(new Color(0, 0, 0));

		btnCatalogo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));

		btnCatalogo.setBounds(373, 381, 410, 91);

		PanelMenu.add(btnCatalogo);

		btnSimular = new JButton("SIMULAR");

		btnSimular.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				PanelMenu.setVisible(false);

				PanelSimular.setVisible(true);

			}

		});

		btnSimular.setForeground(new Color(255, 255, 255));

		btnSimular.setBackground(new Color(0, 0, 0));

		btnSimular.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));

		btnSimular.setBounds(373, 264, 410, 91);

		PanelMenu.add(btnSimular);

		lblImgIzq = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/LogoRaceSimulator2.png"));

		lblImgIzq.setBounds(0, 0, 232, 176);

		PanelMenu.add(lblImgIzq);

		lblImgDer = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/LogoRaceSimulator.png"));

		lblImgDer.setBounds(952, 0, 232, 176);

		PanelMenu.add(lblImgDer);

		lblNombre1 = new JLabel("SIMULATOR");

		lblNombre1.setForeground(new Color(255, 255, 255));

		lblNombre1.setFont(new Font("Showcard Gothic", Font.ITALIC, 65));

		lblNombre1.setBounds(482, 97, 428, 91);

		PanelMenu.add(lblNombre1);

		lblNombre2 = new JLabel("RACE");

		lblNombre2.setForeground(new Color(255, 255, 255));

		lblNombre2.setFont(new Font("Showcard Gothic", Font.ITALIC, 80));

		lblNombre2.setBounds(334, 27, 327, 99);

		PanelMenu.add(lblNombre2);

		lblFondoCabecera = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/FondoCabecera.png"));

		lblFondoCabecera.setBounds(0, 0, 1184, 176);

		PanelMenu.add(lblFondoCabecera);

		lblFondoMenu = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/FondoMenu.png"));

		lblFondoMenu.setBounds(0, 176, 1184, 485);

		PanelMenu.add(lblFondoMenu);

		PanelSimular = new JPanel();

		PanelSimular.setVisible(false);

		PanelSimular.setBounds(0, 0, 1184, 661);

		contentPane.add(PanelSimular);

		PanelSimular.setLayout(null);

		lblGanador2 = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/trofeo.png"));

		lblGanador2.setVisible(false);

		distancia5 = new JButton(new ImageIcon("src/Resource/ImagenesLogos/letrero1km.png"));

		distancia5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				distancia = 1; // Actualiza la variable global con la distancia seleccionada

			}

		});

		distancia5.setBounds(644, 299, 39, 34);

		PanelSimular.add(distancia5);

		distancia3 = new JButton(new ImageIcon("src/Resource/ImagenesLogos/letrero20km.png"));

		distancia3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				distancia = 20; // Actualiza la variable global con la distancia seleccionada

			}

		});

		distancia3.setBounds(595, 299, 39, 34);

		PanelSimular.add(distancia3);

		distancia2 = new JButton(new ImageIcon("src/Resource/ImagenesLogos/letrero10km.png"));

		distancia2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				distancia = 10; // Actualiza la variable global con la distancia seleccionada

			}

		});

		distancia2.setBounds(546, 299, 39, 34);

		PanelSimular.add(distancia2);

		JButton distancia1 = new JButton(new ImageIcon("src/Resource/ImagenesLogos/letrero5km.png"));

		distancia1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				distancia = 5; // Actualiza la variable global con la distancia seleccionada

			}

		});

		distancia1.setBounds(497, 299, 39, 34);

		PanelSimular.add(distancia1);

		lblGanador2.setBounds(956, 88, 46, 53);

		PanelSimular.add(lblGanador2);

		lblGanador1 = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/trofeo.png"));

		lblGanador1.setVisible(false);

		lblGanador1.setBounds(956, 24, 46, 53);

		PanelSimular.add(lblGanador1);

		lblCoche1 = new JLabel("");

		lblCoche1.setBounds(40, 201, 315, 216);

		PanelSimular.add(lblCoche1);

		lblCoche2 = new JLabel("");

		lblCoche2.setBounds(816, 201, 315, 216);

		PanelSimular.add(lblCoche2);

		lblDistancia = new JLabel("DISTANCIA");

		lblDistancia.setForeground(new Color(0, 0, 0));

		lblDistancia.setFont(new Font("Showcard Gothic", Font.ITALIC, 40));

		lblDistancia.setBounds(458, 229, 245, 59);

		PanelSimular.add(lblDistancia);

		lblKms = new JLabel("KMS:");

		lblKms.setForeground(new Color(0, 0, 0));

		lblKms.setFont(new Font("Showcard Gothic", Font.ITALIC, 30));

		lblKms.setBounds(410, 299, 77, 41);

		PanelSimular.add(lblKms);

		btnIniciar = new JButton("INICIAR");

		btnIniciar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				lblGanador1.setVisible(false);

				lblGanador2.setVisible(false);

				int indiceCoche1 = cbCoche1.getSelectedIndex();

				int indiceCoche2 = cbCoche2.getSelectedIndex();

				if (indiceCoche1 < 0 || indiceCoche2 < 0) {

					JOptionPane.showMessageDialog(

							null,

							"Debes seleccionar los dos vehículos."

							);

					return;

				}

				if (indiceCoche1 == indiceCoche2) {

					JOptionPane.showMessageDialog(

							null,

							"Debes seleccionar dos vehículos diferentes."

							);

					return;

				}

				if (distancia <= 0) {

					JOptionPane.showMessageDialog(

							null,

							"La distancia debe ser mayor que 0 km."

							);

					return;

				}

				Vehiculo coche1 = vehiculos.get(indiceCoche1);

				Vehiculo coche2 = vehiculos.get(indiceCoche2);

				double distanciaMetros = distancia * 1000.0;

				SimuladorCarrera simulador = new SimuladorCarrera();

				ResultadoCarrera resultado = simulador.simular(

						coche1,

						coche2,

						distanciaMetros

						);

				if (resultado.getGanador() == coche1) {

					lblGanador1.setVisible(true);

				} else if (resultado.getGanador() == coche2) {

					lblGanador2.setVisible(true);

				}

				String mensaje;

				if (resultado.getGanador() != null) {

					mensaje = "Ganador: "

							+ resultado.getGanador().getMarca() + " "

							+ resultado.getGanador().getModelo()

							+ "\n\n"

							+ coche1.getMarca() + " " + coche1.getModelo()

							+ ": " + resultado.getTiempoVehiculo1() + " segundos"

							+ "\n"

							+ coche2.getMarca() + " " + coche2.getModelo()

							+ ": " + resultado.getTiempoVehiculo2() + " segundos";

				} else {

					mensaje = "La carrera ha terminado en empate.";

				}

				JOptionPane.showMessageDialog(

						null,

						mensaje,

						"Resultado de la carrera",

						JOptionPane.INFORMATION_MESSAGE

						);

			}

		});

		btnIniciar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));

		btnIniciar.setBounds(410, 376, 315, 64);

		PanelSimular.add(btnIniciar);

		btnSalir2 = new JButton("SALIR");

		btnSalir2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));

		btnSalir2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				PanelSimular.setVisible(false);

				PanelMenu.setVisible(true);

			}

		});

		btnSalir2.setBounds(467, 477, 202, 41);

		PanelSimular.add(btnSalir2);

		cbCoche1 = new JComboBox();

		cbCoche1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int indice = cbCoche1.getSelectedIndex();

				if (indice >= 0) {

					Vehiculo coche = vehiculos.get(indice);

					lblNombreCarreraC1.setText(coche.getMarca() + " " + coche.getModelo());

				}

			}

		});

		cbCoche1.setBounds(61, 428, 272, 22);

		PanelSimular.add(cbCoche1);

		cbCoche2 = new JComboBox();

		cbCoche2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int indice = cbCoche2.getSelectedIndex();

				if (indice >= 0) {

					Vehiculo coche = vehiculos.get(indice);

					lblNombreCarreraC2.setText(coche.getMarca() + " " + coche.getModelo());

				}

			}

		});

		cbCoche2.setBounds(839, 428, 272, 22);

		PanelSimular.add(cbCoche2);

		pbCoche1 = new JProgressBar();

		pbCoche1.setBounds(209, 54, 734, 22);

		PanelSimular.add(pbCoche1);

		pbCoche2 = new JProgressBar();

		pbCoche2.setBounds(209, 119, 734, 22);

		PanelSimular.add(pbCoche2);

		lblNombreCarreraC2 = new JLabel("");

		lblNombreCarreraC2.setForeground(new Color(255, 255, 255));

		lblNombreCarreraC2.setBounds(209, 94, 734, 14);

		PanelSimular.add(lblNombreCarreraC2);

		lblNombreCarreraC1 = new JLabel("");

		lblNombreCarreraC1.setForeground(new Color(255, 255, 255));

		lblNombreCarreraC1.setBounds(209, 29, 734, 14);

		PanelSimular.add(lblNombreCarreraC1);

		lblMarca1 = new JLabel("");

		lblMarca1.setBounds(61, 477, 272, 22);

		PanelSimular.add(lblMarca1);

		lblGeneracion1 = new JLabel("");

		lblGeneracion1.setBounds(61, 517, 272, 22);

		PanelSimular.add(lblGeneracion1);

		lblPotencia1 = new JLabel("");

		lblPotencia1.setBounds(61, 557, 272, 22);

		PanelSimular.add(lblPotencia1);

		lblParNm1 = new JLabel("");

		lblParNm1.setBounds(61, 590, 272, 22);

		PanelSimular.add(lblParNm1);

		lblMarca2 = new JLabel("");

		lblMarca2.setBounds(786, 477, 272, 22);

		PanelSimular.add(lblMarca2);

		lblGeneracion2 = new JLabel("");

		lblGeneracion2.setBounds(786, 517, 272, 22);

		PanelSimular.add(lblGeneracion2);

		lblPotencia2 = new JLabel("");

		lblPotencia2.setBounds(786, 557, 272, 22);

		PanelSimular.add(lblPotencia2);

		lblParNm2 = new JLabel("");

		lblParNm2.setBounds(786, 590, 272, 22);

		PanelSimular.add(lblParNm2);

		lblImgIzq3 = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/LogoSimular.png"));

		lblImgIzq3.setBounds(23, 24, 159, 134);

		PanelSimular.add(lblImgIzq3);

		lblFondoSimular = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/FondoMenu.png"));

		lblFondoSimular.setBounds(0, 176, 1184, 485);

		PanelSimular.add(lblFondoSimular);

		lblFondoCabecera2 = new JLabel(new ImageIcon("src/Resource/ImagenesLogos/FondoCabecera.png"));

		lblFondoCabecera2.setBounds(0, 0, 1184, 176);

		PanelSimular.add(lblFondoCabecera2);

		cargarVehiculos();

	}

	public void cargarVehiculos() {

		try {

			vehiculos = gestorVehiculos.obtenerVehiculos();

			DefaultListModel<String> modeloLista = new DefaultListModel<>();

			for (Vehiculo vehiculo : vehiculos) {

				modeloLista.addElement(vehiculo.getMarca() + " " + vehiculo.getModelo());

			}

			cargarCombosCarrera();

			listCatalogo.setModel(modeloLista);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	private void cargarCombosCarrera() {

		cbCoche1.removeAllItems();

		cbCoche2.removeAllItems();

		for (Vehiculo vehiculo : vehiculos) {

			String nombre = vehiculo.getMarca() + " " + vehiculo.getModelo();

			cbCoche1.addItem(nombre);

			cbCoche2.addItem(nombre);

		}

	}

	public void mostrarVehiculoSeleccionado() {
		int indice = listCatalogo.getSelectedIndex();
		if (indice == -1) {
			return;
		}

		Vehiculo vehiculo = vehiculos.get(indice);

		lblMarcaTxt.setText(vehiculo.getMarca());
		lblModeloTxt.setText(vehiculo.getModelo());
		lblGeneracionTxt.setText(vehiculo.getGeneracion() != null ? vehiculo.getGeneracion() : "N/D");
		lblPotenciaTxt.setText(String.valueOf(vehiculo.getPotenciaCV()));
		lblParMotorTxt.setText(vehiculo.getParMotorNm() != null ? vehiculo.getParMotorNm().toString() : "N/D");
		lblPesoTxt.setText(vehiculo.getPeso() != null ? vehiculo.getPeso().toString() : "N/D");
		lblTraccionTxt.setText(vehiculo.getTraccion());
		lblAceleracionTxt.setText(vehiculo.getAceleracion() != null ? vehiculo.getAceleracion().toString() : "N/D");
		lblVelocidadMaxTxt.setText(String.valueOf(vehiculo.getVelocidadMaxima()));
		lblTransmisionTxt.setText(vehiculo.getCambio() != null ? vehiculo.getCambio() : "N/D");

		if (vehiculo.getImagen() != null && !vehiculo.getImagen().isEmpty()) {
			File archivoImagen = new File("src/Resource/ImagenesCoches", vehiculo.getImagen());
			if (archivoImagen.exists()) {
				ImageIcon icono = new ImageIcon(archivoImagen.getAbsolutePath());
				Image imagenRedimensionada = icono.getImage().getScaledInstance(lblVistaCocheCatalogo.getWidth(),
						lblVistaCocheCatalogo.getHeight(), Image.SCALE_SMOOTH);
				lblVistaCocheCatalogo.setIcon(new ImageIcon(imagenRedimensionada));
			} else {
				lblVistaCocheCatalogo.setIcon(null);
				System.out.println("No se encuentra la imagen: " + archivoImagen.getAbsolutePath());
			}
		} else {
			lblVistaCocheCatalogo.setIcon(null);
		}
	}

}
