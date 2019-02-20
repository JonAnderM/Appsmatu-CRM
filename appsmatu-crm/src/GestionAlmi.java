
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
	private JLabel lblAlumnos;
	private JLabel lblAsignaturas;
	private JLabel lblCursos;
	private JLabel lblDocentes;
	private JLabel lblOpciones;
	private JLabel lblNoticia;
	private JLabel lblRegistro;
	private JPanel panel;
	private JPasswordField passwordField;
	private JPanel panelRegistro;
	private JButton btnCerrarReg;
	private ArrayList<JButton> tablas;
	private ArrayList<JLabel> labels;
	private PanelModificaciones panelModificaciones;
	private JPanel panelAcciones;
	private JButton btnEnviar;
	private JButton btnLimpiar;
	private Image buscar;
	private Image nuevo;
	private Image modificar;
	private Image borrar;
	private Image sql;
	private JPanel panel_1;
	private Image buscarSel;
	private Image nuevoSel;
	private Image modificarSel;
	private Image borrarSel;
	private Image sqlSel;
	private JButton btnBuscar;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSql;

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

		buscar = new ImageIcon(getClass().getResource("search.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); 
		nuevo = new ImageIcon(getClass().getResource("add.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); 
		modificar = new ImageIcon(getClass().getResource("icon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);  
		borrar = new ImageIcon(getClass().getResource("delete.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); 
		sql = new ImageIcon(getClass().getResource("sqlicon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); 

		buscarSel = new ImageIcon(getClass().getResource("searchSel.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); 
		nuevoSel = new ImageIcon(getClass().getResource("addSel.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); 
		modificarSel = new ImageIcon(getClass().getResource("iconSel.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);  
		borrarSel = new ImageIcon(getClass().getResource("deleteSel.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); 
		sqlSel = new ImageIcon(getClass().getResource("sqliconSel.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); 
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
		btnAlumnos.setBounds(0, 198, 311, 60);
		lblAlumnos = new JLabel();
		lblAlumnos.setBounds(0, 258, 311, 10);
		lblAlumnos.setBackground(new Color(78, 74, 123));

		btnAsignaturas = new JButton("Asignaturas");
		btnAsignaturas.setBounds(0, 268, 311, 60);
		lblAsignaturas = new JLabel();
		lblAsignaturas.setBounds(0, 328, 311, 10);
		lblAsignaturas.setBackground(new Color(108, 84, 153));

		btnCursos = new JButton("Cursos");
		btnCursos.setBounds(0, 338, 311, 60);
		lblCursos = new JLabel();
		lblCursos.setBounds(0, 398, 311, 10);
		lblCursos.setBackground(new Color(0, 102, 153));

		btnDocentes = new JButton("Docentes");
		btnDocentes.setBounds(0, 408, 311, 60);
		lblDocentes = new JLabel();
		lblDocentes.setBounds(0, 468, 311, 10);
		lblDocentes.setBackground(new Color(18, 55, 114));

		btnNoticia = new JButton("Noticias");
		btnNoticia.setBounds(0, 478, 311, 60);
		lblNoticia = new JLabel();
		lblNoticia.setBounds(0, 538, 311, 10);
		lblNoticia.setBackground(new Color(18, 114, 112));

		btnOpciones = new JButton("M\u00E1s opciones...");
		btnOpciones.setBounds(0, 548, 311, 60);
		lblOpciones = new JLabel();
		lblOpciones.setBounds(0, 608, 311, 10);
		lblOpciones.setBackground(new Color(18, 114, 69));

		btnRegistro = new JButton("Registrar Usuario");
		btnRegistro.setBounds(0, 618, 311, 60);
		lblRegistro = new JLabel();
		lblRegistro.setBounds(0, 678, 311, 10);
		lblRegistro.setBackground(new Color(41, 102, 50));

		panelAcciones = new JPanel();
		panelAcciones.setBorder(null);
		panelAcciones.setBounds(311, 35, 969, 685);
		contentPane.add(panelAcciones);
		panelAcciones.setLayout(null);
		panelAcciones.setBackground(contentPane.getBackground());

		PanelModificaciones panelito = new PanelModificaciones();
		panelito.setBounds(20, 20, 835, 576);
		panelAcciones.add(panelito);

		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlDkShadow);
		panel_1.setBounds(879, 0, 90, 685);
		panelAcciones.add(panel_1);
		panel_1.setLayout(null);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(0, 0, 90, 90);
		panel_1.add(btnBuscar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(0, 160, 90, 90);
		panel_1.add(btnNuevo);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(0, 249, 90, 90);
		panel_1.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(0, 339, 90, 90);
		panel_1.add(btnEliminar);

		btnSql = new JButton("SQL");
		btnSql.setHorizontalAlignment(SwingConstants.TRAILING);
		btnSql.setBounds(0, 506, 90, 90);
		panel_1.add(btnSql);



		btnEnviar = new JButton("A\u00F1adir");
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setBackground(new Color(0, 100, 0));
		btnEnviar.setBounds(669, 632, 90, 28);
		panelAcciones.add(btnEnviar);
		tablas = new ArrayList<JButton>();
		labels = new ArrayList<JLabel>();
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setBackground(new Color(178, 34, 34));
		btnLimpiar.setBounds(771, 632, 90, 28);
		panelAcciones.add(btnLimpiar);


		btnBuscar.setIcon(new ImageIcon(buscar));
		btnNuevo.setIcon(new ImageIcon(nuevo));
		btnModificar.setIcon(new ImageIcon(modificar));
		btnEliminar.setIcon(new ImageIcon(borrar));
		btnSql.setIcon(new ImageIcon(sql));


		btnBuscar.setRolloverIcon(new ImageIcon(buscarSel));
		btnNuevo.setRolloverIcon(new ImageIcon(nuevoSel));
		btnModificar.setRolloverIcon(new ImageIcon(modificarSel));
		btnEliminar.setRolloverIcon(new ImageIcon(borrarSel));
		btnSql.setRolloverIcon(new ImageIcon(sqlSel));


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
		tablas.add(7, btnBuscar);
		tablas.add(8, btnNuevo);
		tablas.add(9, btnModificar);
		tablas.add(10, btnEliminar);
		tablas.add(11, btnSql);
		
		labels.add(0, lblAlumnos);
		labels.add(1, lblAsignaturas);
		labels.add(2, lblCursos);
		labels.add(3, lblDocentes);
		labels.add(4, lblNoticia);
		labels.add(5, lblOpciones);
		labels.add(6, lblRegistro);

		table = new JTable();

		btnCerrarSesion.setContentAreaFilled(false);
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setOpaque(true);

		lblNombreUsu.setText(Login.getUser());
		botonesTablas(tablas, labels);
		registrarEventos();

	}
	private void animacionBotones(JButton btn, JLabel lbl) {
		btn.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
			}
			public void mousePressed(MouseEvent e) {
				btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
				panelAcciones.setBackground(lbl.getBackground());
				if(btn.equals(btnRegistro)){
					for(int i=0; i<1280;i++){
						panelRegistro.setBounds(panelRegistro.getX(), panelRegistro.getY(), panelRegistro.getWidth()+i, panelRegistro.getHeight());
					}
					for(i=7;i<tablas.size();i++) {
					tablas.get(i).setVisible(false);
					panelAcciones.setVisible(false);
					}
				}else{
					for(i=7;i<tablas.size();i++) {
						tablas.get(i).setVisible(true);
						panelAcciones.setVisible(true);
						}
				}
			}
			public void mouseExited(MouseEvent e) {
				btn.setBackground(SystemColor.controlDkShadow);
			}
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(SystemColor.DARK_GRAY);
			}
		});
	}
	private void animacionBotones(JButton btn) {
		btn.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
			}
			public void mousePressed(MouseEvent e) {
				btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
				
			}
			public void mouseExited(MouseEvent e) {
				btn.setBackground(SystemColor.controlDkShadow);

			}
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(SystemColor.DARK_GRAY);
			}
		});
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
		});		//BaseDatos.getBBDD().obtenerDatos("perfiles");
		btnCerrarSesion.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				GestionAlmi.this.setVisible(false);
				Login.main(null);
			}
		});
		btnCerrarReg.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panelRegistro.setBounds(panelRegistro.getX(), panelRegistro.getY(), 0, panelRegistro.getHeight());
				panelAcciones.setVisible(true);
			}
		});
	}
	private void botonesTablas(ArrayList<JButton> tablas, ArrayList<JLabel> labels) {
		
		for(i=0;i<tablas.size();i++) {
			tablas.get(i).setBackground(SystemColor.controlDkShadow);
			tablas.get(i).setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
			tablas.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			tablas.get(i).setForeground(Color.WHITE);
			tablas.get(i).setContentAreaFilled(false);
			tablas.get(i).setBorder(null);
			tablas.get(i).setOpaque(true);
			tablas.get(i).setRolloverEnabled(true);
			tablas.get(i).setFocusPainted(false);
			if(i<labels.size()){
				labels.get(i).setOpaque(true);

				panel.add(labels.get(i));
				animacionBotones(tablas.get(i), labels.get(i));
			}
			panel.add(tablas.get(i));	
			if( i > 6 ){
				// Text below image
				tablas.get(i).setVerticalTextPosition(SwingConstants.BOTTOM);
				// And centred

				tablas.get(i).setHorizontalTextPosition(SwingConstants.CENTER); 
				animacionBotones(tablas.get(i));
				panel_1.add(tablas.get(i));
			}
		}
	}
}
