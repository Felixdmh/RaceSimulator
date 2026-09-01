package Presentacion;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Vehiculo;
import Negocio.GestorVehiculos;
import Negocio.ResultadoCarrera;
import Negocio.SimuladorCarrera;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel PanelMenu, PanelCatalogo, PanelSimular;
	private JLabel lblNombre1, lblNombre2, lblImgIzq, lblImgDer, lblFondoCabecera, lblFondoMenu, lblFondoCabecera_1, lblFondoCatalogo, lblVistaCocheCatalogo, lblCatalogo;
	private JList listCatalogo;
	private List<Vehiculo> vehiculos;
	private JButton btnSalir, btnCatalogo, btnSimular, btnNewButton, btnIniciar, btnSalir2;
	private JLabel lblDistancia, lblKms, lblCoche1, lblCoche2, lblGanador1, lblGanador2, lblFondoCabecera2, lblFondoSimular;
	private JComboBox cbCoche1, cbCoche2;
	private JLabel lblNombreCarreraC2, lblNombreCarreraC1, lblMarca1, lblGeneracion1, lblPotencia1, lblParNm1, lblMarca2, lblGeneracion2, lblPotencia2, lblParNm2;
	private JProgressBar pbCoche1, pbCoche2;
	private JLabel lblImgIzq2;
	private JLabel lblImgDer2;
	private JLabel lblImgIzq3;
	private JLabel lblPotenciaCv, lblPotenciaTxt, lblGeneracion, lblGeneracionTxt, lblParMotor, lblParMotorTxt, lblPeso, lblPesoTxt, lblTraccion, lblTraccionTxt, lblAceleracion, lblAceleracionTxt, lblVelocidadMax, lblVelocidadMaxTxt, lblTransmision, lblTransmisionTxt, lblMarca, lblMarcaTxt, lblModelo, lblModeloTxt;
	private GestorVehiculos gestorVehiculos;
	private JButton distancia2;
	private JButton distancia3;
	
	public static int distancia = 1; //Varible global para almacenar la distancia seleccionada por el usuario
	private JButton distancia5;

	/**
	 * Launch the application.
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
	 * Create the frame.
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
		
		PanelCatalogo = new JPanel();
		PanelCatalogo.setVisible(false);
		
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
		PanelCatalogo.setBounds(0, 0, 1184, 661);
		contentPane.add(PanelCatalogo);
		PanelCatalogo.setLayout(null);
		
		lblCatalogo = new JLabel("CATÁLOGO");
		lblCatalogo.setForeground(new Color(255, 0, 0));
		lblCatalogo.setFont(new Font("Showcard Gothic", Font.PLAIN, 70));
		lblCatalogo.setBounds(419, 41, 363, 106);
		PanelCatalogo.add(lblCatalogo);
		
		lblVistaCocheCatalogo = new JLabel("");
		lblVistaCocheCatalogo.setBounds(452, 298, 315, 216);
		PanelCatalogo.add(lblVistaCocheCatalogo);
		
		listCatalogo = new JList();
		listCatalogo.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
				    mostrarVehiculoSeleccionado();
				}
			}

		});
		listCatalogo.setBounds(25, 209, 384, 424);
		PanelCatalogo.add(listCatalogo);
		
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

	    System.out.println(vehiculo.getMarca());
	}
}
