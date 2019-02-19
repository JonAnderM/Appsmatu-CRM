
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JLabel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JWindow;
import javax.swing.table.DefaultTableModel;

import com.mysql.fabric.xmlrpc.base.Array;

import javax.swing.JScrollBar;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;



public class GestionAlmi extends JFrame {

	private JPanel contentPane;
	private Login login;
	private Image almi;
	private BaseDatos bd;
	private ResultSet rs;
	private Image circSalir;
	private Image circMinimizar;
	private Image clarSalir;
	private JTable table;
	private Image clarMinimizar;
	private JButton btnSalir;
	private JButton btnMinimizar;
	private JMenuBar menuBar;
	protected int my;
	protected int mx;
	private int i=0;
	private JButton btnAlumnos;
	private JButton btnAsignaturas;
	private JButton btnCursos;
	private JButton btnDocentes;
	private JButton btnOpciones;
	private JButton btnNoticia;
	private JButton btnCerrarSesion;
	private JButton btnRegistro;
	private JPanel panel;
	private JPasswordField passwordField;
	private JPanel panelRegistro;
	private JButton btnCerrarReg;
	private ArrayList<JButton> tablas;
	private PanelModificaciones panelModificaciones;
	private JPanel panelAcciones;
	private JButton btnEnviar;
	private JButton btnLimpiar;
	private JPanel panelCrear;
	private JPanel panelEliminar;
	private JPanel panelBusquedas;
	private JPanel panelSQL;
	private JPanel panelModificar;
	private JTabbedPane panelGrafico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionAlmi frame = new GestionAlmi();
					frame.setVisible(true);
					//frame.setUndecorated(true);
					frame.setShape(new RoundRectangle2D.Double(0, 0, 1280, 720, 12, 12));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestionAlmi() {

		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 70, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0, 102, 153));
		setContentPane(contentPane);

		almi = new ImageIcon(getClass().getResource("Almi logo.png")).getImage().getScaledInstance(301, 151, Image.SCALE_SMOOTH);
		circSalir = new ImageIcon(getClass().getResource("salir.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		circMinimizar = new ImageIcon(getClass().getResource("minimizar.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		clarSalir = new ImageIcon(getClass().getResource("salirCla.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		clarMinimizar = new ImageIcon(getClass().getResource("minimizarCla.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);

		/*
		JPanel authorization = new JPanel();
		authorization.add(new JLabel ("test"));
		options.addTab("test",authorization);
		 */

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1280, 35);
		menuBar.setBorder(BorderFactory.createCompoundBorder(menuBar.getBorder(),BorderFactory.createEmptyBorder(2, 3, 0, 0)));
		contentPane.add(menuBar);

		Component horizontalStrut_3 = Box.createHorizontalStrut(14);
		menuBar.add(horizontalStrut_3);

		JMenu mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		mnNewMenu.setBounds(0, 0, 50, 50);
		menuBar.add(mnNewMenu);

		btnCerrarSesion = new JButton(" Cerrar sesion ");
		mnNewMenu.add(btnCerrarSesion);

		JMenu mnNewMenu_1 = new JMenu("Propiedades");
		mnNewMenu_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.setBounds(0, 0, 50, 50);

		JMenu mnNewMenu_2 = new JMenu("Ayuda");
		mnNewMenu_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_2);

		Component horizontalStrut = Box.createHorizontalStrut(872);
		menuBar.add(horizontalStrut);

		JLabel lblSesion = new JLabel("Sesi\u00F3n: ");
		lblSesion.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(lblSesion);

		JLabel lblNombreUsu = new JLabel("");
		menuBar.add(lblNombreUsu);

		btnSalir = new JButton("");
		btnSalir.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSalir.setOpaque(false);
		btnSalir.setForeground(Color.WHITE);

		btnSalir.setIcon(new ImageIcon(clarSalir));
		btnSalir.setRolloverIcon(new ImageIcon(circSalir));
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorder(null);



		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);

		btnMinimizar = new JButton("");
		btnMinimizar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnMinimizar.setForeground(Color.WHITE);
		btnMinimizar.setOpaque(false);
		btnMinimizar.setContentAreaFilled(false);
		btnMinimizar.setBorder(null);
		menuBar.add(btnMinimizar);
		btnMinimizar.setIcon(new ImageIcon(clarMinimizar));
		btnMinimizar.setRolloverIcon(new ImageIcon(circMinimizar));

		Component horizontalStrut_1 = Box.createHorizontalStrut(12);
		menuBar.add(horizontalStrut_1);
		menuBar.add(btnSalir);

		Component horizontalStrut_2 = Box.createHorizontalStrut(13);
		menuBar.add(horizontalStrut_2);

		panelRegistro = new JPanel();
		panelRegistro.setBackground(SystemColor.controlDkShadow);
		panelRegistro.setBounds(311, 35, 0, 685);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);

		JLabel lblNuevoUsuario = new JLabel("Nuevo Usuario");
		lblNuevoUsuario.setForeground(SystemColor.menu);
		lblNuevoUsuario.setBackground(SystemColor.menu);
		lblNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoUsuario.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 45));
		lblNuevoUsuario.setBounds(189, 50, 508, 76);
		panelRegistro.add(lblNuevoUsuario);
		
		JLabel lblPerfilUsu = new JLabel("Perfil");
		lblPerfilUsu.setForeground(SystemColor.menu);
		lblPerfilUsu.setBounds(150, 201, 82, 34);
		panelRegistro.add(lblPerfilUsu);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(150, 235, 236, 25);
		panelRegistro.add(comboBox);

		passwordField = new JPasswordField();
		passwordField.setBounds(364, 438, 236, 20);
		panelRegistro.add(passwordField);
		
		btnCerrarReg = new JButton("X");
		btnCerrarReg.setFont(new Font("Dialog", Font.BOLD, 24));
		btnCerrarReg.setForeground(Color.WHITE);
		btnCerrarReg.setBounds(900, 0, 55, 51);
		btnCerrarReg.setBackground(SystemColor.controlDkShadow);
		btnCerrarReg.setContentAreaFilled(false);
		btnCerrarReg.setBorder(null);
		btnCerrarReg.setOpaque(true);
		panelRegistro.add(btnCerrarReg);

		panel = new JPanel();
		panel.setBounds(0, 0, 311, 755);
		contentPane.add(panel);
		panel.setBackground(SystemColor.controlDkShadow);
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(0, 30, 301, 151);
		panel.add(label);
		label.setIcon(new ImageIcon(almi));

		btnAlumnos = new JButton("Alumnos");
		btnAlumnos.setBounds(0, 198, 311, 70);

		btnAsignaturas = new JButton("Asignaturas");
		btnAsignaturas.setBounds(0, 267, 311, 70);

		btnCursos = new JButton("Cursos");
		btnCursos.setBounds(0, 337, 311, 70);

		btnDocentes = new JButton("Docentes");
		btnDocentes.setBounds(0, 407, 311, 70);

		btnNoticia = new JButton("Noticias");
		btnNoticia.setBounds(0, 477, 311, 70);

		btnOpciones = new JButton("M\u00E1s opciones...");
		btnOpciones.setBounds(0, 547, 311, 70);

		btnRegistro = new JButton("Registrar Usuario");
		btnRegistro.setBounds(0, 629, 311, 70);

		PanelModificaciones panelito = new PanelModificaciones();
		
		panelAcciones = new JPanel();
		panelAcciones.setBorder(null);
		panelAcciones.setBounds(311, 35, 969, 685);
		contentPane.add(panelAcciones);
		panelAcciones.setLayout(null);

		panelGrafico = new JTabbedPane(JTabbedPane.LEFT);
		panelGrafico.setBounds(12, 12, 939, 583);
		panelAcciones.add(panelGrafico);
		panelAcciones.setBackground(contentPane.getBackground());
		panelGrafico.setBackground(panelAcciones.getBackground());
		panelGrafico.setBorder(new LineBorder(panelAcciones.getBackground(), 0));
		panelCrear = new JPanel();
		panelCrear.setBorder(new LineBorder(panelAcciones.getBackground(), 1, true));
		panelGrafico.addTab("", new ImageIcon(getClass().getResource("add.png")), panelCrear, "");
		panelGrafico.setEnabledAt(0, true);
		panelCrear.setLayout(new BoxLayout(panelCrear, BoxLayout.PAGE_AXIS));

		panelito.setBounds(0, 0, 855, 576);
		
		panelModificar = new JPanel();
		panelModificar.setBorder(null);
		panelGrafico.addTab("", new ImageIcon(getClass().getResource("icon.png")), panelModificar, "");
		panelModificar.setLayout(null);
		panelModificar.add(panelito);
		panelGrafico.setForegroundAt(1, Color.BLACK);

		panelEliminar = new JPanel();
		panelEliminar.setBorder(null);
		panelGrafico.addTab("", new ImageIcon(getClass().getResource("delete.png")), panelEliminar, "");
		panelEliminar.setLayout(null);



		panelBusquedas = new JPanel();
		panelBusquedas.setBorder(null);
		panelGrafico.addTab("", new ImageIcon(getClass().getResource("search.png")), panelBusquedas, "");
		panelBusquedas.setLayout(null);


		panelSQL = new JPanel();
		panelSQL.setBorder(null);
		panelGrafico.addTab("", new ImageIcon(getClass().getResource("sqlicon.png")), panelSQL, "");
		panelSQL.setLayout(null);
		
		

		btnEnviar = new JButton("A\u00F1adir");
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setBackground(new Color(0, 100, 0));
		btnEnviar.setBounds(759, 632, 90, 28);
		panelAcciones.add(btnEnviar);
		ArrayList<JButton> tablas = new ArrayList<JButton>();
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setBackground(new Color(178, 34, 34));
		btnLimpiar.setBounds(861, 632, 90, 28);
		panelAcciones.add(btnLimpiar);

		JPanel shadowPane = new JPanel();
		shadowPane.setBackground(Color.DARK_GRAY);
		shadowPane.setBounds(0, 0, 1280, 720);
		contentPane.add(shadowPane);
		shadowPane.setLayout(null);
		tablas.add(0, btnAlumnos);
		tablas.add(1, btnAsignaturas);
		tablas.add(2, btnCursos);
		tablas.add(3, btnDocentes);
		tablas.add(4, btnNoticia);
		tablas.add(5, btnOpciones);
		tablas.add(6, btnRegistro);
		
		table = new JTable();

		btnCerrarSesion.setContentAreaFilled(false);
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setOpaque(true);

		lblNombreUsu.setText(Login.getUser());
		botonesTablas(tablas);
		registrarEventos();
		
		//mostrarTabla();
	}

	private void registrarEventos() {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnMinimizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestionAlmi.this.setExtendedState(ICONIFIED);
			}
		});
		menuBar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				mx = arg0.getX();
				my = arg0.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				GestionAlmi.this.setLocation(e.getXOnScreen()-mx,e.getYOnScreen()-my);
			}
		});
		
		btnAlumnos.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				btnAlumnos.setFont(btnDocentes.getFont());
			}

			public void mousePressed(MouseEvent e) {
				btnAlumnos.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
				panelAcciones.setBackground(new Color(0, 114, 17));
				btnAlumnos.setBackground(panelAcciones.getBackground());
				panelGrafico.setBackground(panelAcciones.getBackground());

				BaseDatos.getBBDD().obtenerDatos("perfiles");
			}

			public void mouseExited(MouseEvent e) {
				if(btnAlumnos.getBackground() != panelAcciones.getBackground()){
				btnAlumnos.setBackground(SystemColor.controlDkShadow);
				}
			}

			public void mouseEntered(MouseEvent e) {
				if(btnAlumnos.getBackground() != panelAcciones.getBackground()){
					btnAlumnos.setBackground(SystemColor.DARK_GRAY);
					}
				
			}

		});
		btnAsignaturas.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				btnAsignaturas.setFont(btnDocentes.getFont());
				
			}

			public void mousePressed(MouseEvent e) {
				btnAsignaturas.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
				panelAcciones.setBackground(contentPane.getBackground());
				btnAsignaturas.setBackground(panelAcciones.getBackground());
				panelGrafico.setBackground(panelAcciones.getBackground());
				
			}

			public void mouseExited(MouseEvent e) {
				if(btnAsignaturas.getBackground() != panelAcciones.getBackground()){
				btnAsignaturas.setBackground(SystemColor.controlDkShadow);
				}
			}

			public void mouseEntered(MouseEvent e) {
				if(btnAsignaturas.getBackground() != panelAcciones.getBackground()){
					btnAsignaturas.setBackground(SystemColor.controlDkShadow);
					}
				
			}

		});
		btnCursos.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				btnCursos.setFont(btnDocentes.getFont());
			}

			public void mousePressed(MouseEvent e) {
				btnCursos.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
			}

			public void mouseExited(MouseEvent e) {
				btnCursos.setBackground(SystemColor.controlDkShadow);
			}

			public void mouseEntered(MouseEvent e) {
				btnCursos.setBackground(SystemColor.DARK_GRAY);
			}

		});
		btnDocentes.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				btnDocentes.setFont(btnAlumnos.getFont());
			}

			public void mousePressed(MouseEvent e) {
				btnDocentes.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
			}

			public void mouseExited(MouseEvent e) {
				btnDocentes.setBackground(SystemColor.controlDkShadow);
			}

			public void mouseEntered(MouseEvent e) {
				btnDocentes.setBackground(SystemColor.DARK_GRAY);
			}

		});
		btnNoticia.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				btnNoticia.setFont(btnAlumnos.getFont());
			}

			public void mousePressed(MouseEvent e) {
				btnNoticia.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
			}

			public void mouseExited(MouseEvent e) {
				btnNoticia.setBackground(SystemColor.controlDkShadow);
			}

			public void mouseEntered(MouseEvent e) {
				btnNoticia.setBackground(SystemColor.DARK_GRAY);
			}

		});
		btnOpciones.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				btnOpciones.setFont(btnAlumnos.getFont());
			}

			public void mousePressed(MouseEvent e) {
				btnOpciones.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
			}

			public void mouseExited(MouseEvent e) {
				btnOpciones.setBackground(SystemColor.controlDkShadow);
			}

			public void mouseEntered(MouseEvent e) {
				btnOpciones.setBackground(SystemColor.DARK_GRAY);
			}

		});
		btnRegistro.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				btnRegistro.setFont(btnAlumnos.getFont());
			}

			public void mousePressed(MouseEvent e) {
				btnRegistro.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
				
				for(int i=0; i<1280;i++){
					panelRegistro.setBounds(panelRegistro.getX(), panelRegistro.getY(), panelRegistro.getWidth()+i, panelRegistro.getHeight());
				}

			}

			public void mouseExited(MouseEvent e) {
				btnRegistro.setBackground(SystemColor.controlDkShadow);
			}

			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(SystemColor.DARK_GRAY);
			}

		});
		btnCerrarSesion.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				GestionAlmi.this.setVisible(false);
				Login.main(null);
			}
		});
		btnCerrarReg.addMouseListener(new MouseAdapter() {

			
			@Override
			public void mousePressed(MouseEvent e) {
				panelRegistro.setBounds(panelRegistro.getX(), panelRegistro.getY(), 0, panelRegistro.getHeight());
				
			}

		});
	}
	private void botonesTablas(ArrayList<JButton> tablas) {
		
		
		
		for(i=0;i<tablas.size();i++) {
	
			tablas.get(i).setBackground(SystemColor.controlDkShadow);
			tablas.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			tablas.get(i).setForeground(Color.WHITE);
			tablas.get(i).setContentAreaFilled(false);
			tablas.get(i).setBorder(null);
			tablas.get(i).setOpaque(true);
			panel.add(tablas.get(i));
			tablas.get(i).setRolloverEnabled(true);
			tablas.get(i).setFocusPainted(false);

		}
		
	}
}

