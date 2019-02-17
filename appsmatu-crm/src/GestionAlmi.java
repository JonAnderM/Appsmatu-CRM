
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;

import java.sql.ResultSet;
import java.sql.SQLException;

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



public class GestionAlmi extends JFrame {

	private JPanel contentPane;
	private Login login;
	private Image almi;
	private BaseDatos bd;
	private ResultSet rs;
	private JTable table;
	private Image circSalir;
	private Image circMinimizar;
	private Image clarSalir;
	private Image clarMinimizar;
	private JButton btnSalir;
	private JButton btnMinimizar;
	private JMenuBar menuBar;
	protected int my;
	protected int mx;
	private JButton btnAlumnos;
	private JButton btnAsignaturas;
	private JButton btnCursos;
	private JButton btnDocentes;
	private JButton btnNoticias;
	private JButton btnOpciones;
	private Image darkGray;
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
		darkGray = new ImageIcon(getClass().getResource("Dark-Grey.jpg")).getImage();
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
		
		JButton btnCerrarSesion = new JButton("Cerrar sesion");
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

		JLabel lblNombreUsu = new JLabel("Nekane");
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
		JPanel panelAcciones = new JPanel();
		panelAcciones.setBorder(null);
		panelAcciones.setBounds(0, 0, 1280, 720);
		contentPane.add(panelAcciones);
		panelAcciones.setLayout(null);

		JTabbedPane panelGrafico = new JTabbedPane(JTabbedPane.LEFT);
		panelGrafico.setBounds(323, 46, 939, 583);
		panelAcciones.add(panelGrafico);
		panelAcciones.setBackground(contentPane.getBackground());
		panelGrafico.setBackground(contentPane.getBackground());
		panelGrafico.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		JPanel panelCrear = new JPanel();
		panelCrear.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelGrafico.addTab("", new ImageIcon(getClass().getResource("add.png")), panelCrear, "");
		panelGrafico.setEnabledAt(0, true);
		panelCrear.setLayout(new BoxLayout(panelCrear, BoxLayout.PAGE_AXIS));

		JPanel panelModificar = new JPanel();
		panelModificar.setBorder(null);
		panelGrafico.addTab("", new ImageIcon(getClass().getResource("icon.png")), panelModificar, "");
		panelModificar.setLayout(null);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar.setBounds(0, 449, 912, 15);
		panelModificar.add(scrollBar);

		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(894, 0, 18, 448);
		panelModificar.add(scrollBar_1);

		table = new JTable();
		table.setBounds(0, 0, 899, 464);
		panelModificar.add(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				},
				new String[] {
						"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
				}
				));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		panelGrafico.setForegroundAt(1, Color.BLACK);

		JPanel panelEliminar = new JPanel();
		panelEliminar.setBorder(null);
		panelGrafico.addTab("", new ImageIcon(getClass().getResource("delete.png")), panelEliminar, "");
		panelEliminar.setLayout(null);


		JPanel panelBusquedas = new JPanel();
		panelBusquedas.setBorder(null);
		panelGrafico.addTab("", new ImageIcon(getClass().getResource("search.png")), panelBusquedas, "");
		panelBusquedas.setLayout(null);

		JPanel panelSQL = new JPanel();
		panelSQL.setBorder(null);
		panelGrafico.addTab("", new ImageIcon(getClass().getResource("sqlicon.png")), panelSQL, "");
		panelSQL.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlDkShadow);
		panel.setBounds(0, 0, 311, 755);
		panelAcciones.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(0, 30, 301, 151);
		panel.add(label);
		label.setIcon(new ImageIcon(almi));

		btnAlumnos = new JButton("Alumnos");
		btnAlumnos.setForeground(Color.WHITE);
		btnAlumnos.setOpaque(true);
		btnAlumnos.setContentAreaFilled(false);
		btnAlumnos.setBorder(null);
		btnAlumnos.setBackground(SystemColor.controlDkShadow);
		btnAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		btnAlumnos.setBounds(0, 248, 311, 70);
		panel.add(btnAlumnos);

		btnAsignaturas = new JButton("Asignaturas");
		btnAsignaturas.setForeground(Color.WHITE);
		btnAsignaturas.setHorizontalAlignment(SwingConstants.CENTER);
		btnAsignaturas.setBounds(0, 317, 311, 70);
		btnAsignaturas.setBackground(SystemColor.controlDkShadow);
		btnAsignaturas.setContentAreaFilled(false);
		btnAsignaturas.setBorder(null);
		btnAsignaturas.setOpaque(true);
		panel.add(btnAsignaturas);

		btnCursos = new JButton("Cursos");
		btnCursos.setHorizontalAlignment(SwingConstants.CENTER);
		btnCursos.setForeground(Color.WHITE);
		btnCursos.setBackground(SystemColor.controlDkShadow);
		btnCursos.setContentAreaFilled(false);
		btnCursos.setBorder(null);
		btnCursos.setBounds(0, 387, 311, 70);
		btnCursos.setOpaque(true);
		panel.add(btnCursos);

		btnDocentes = new JButton("Docentes");
		btnDocentes.setBackground(SystemColor.controlDkShadow);
		btnDocentes.setHorizontalAlignment(SwingConstants.CENTER);
		btnDocentes.setForeground(Color.WHITE);
		btnDocentes.setBounds(0, 457, 311, 70);
		btnDocentes.setContentAreaFilled(false);
		btnDocentes.setBorder(null);
		btnDocentes.setOpaque(true);
		panel.add(btnDocentes);

		btnNoticias = new JButton("Noticias");
		btnNoticias.setOpaque(true);
		btnNoticias.setContentAreaFilled(false);
		btnNoticias.setBorder(null);
		btnNoticias.setHorizontalAlignment(SwingConstants.CENTER);
		btnNoticias.setForeground(Color.WHITE);
		btnNoticias.setBackground(SystemColor.controlDkShadow);
		btnNoticias.setBounds(0, 527, 311, 70);
		panel.add(btnNoticias);

		btnOpciones = new JButton("M\u00E1s opciones...");
		btnOpciones.setOpaque(true);
		btnOpciones.setContentAreaFilled(false);
		btnOpciones.setBorder(null);
		btnOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		btnOpciones.setForeground(Color.WHITE);
		btnOpciones.setBackground(SystemColor.controlDkShadow);
		btnOpciones.setBounds(0, 597, 311, 70);
		panel.add(btnOpciones);

		JButton btnEnviar = new JButton("A\u00F1adir");
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setBackground(new Color(0, 100, 0));
		btnEnviar.setBounds(1053, 665, 90, 28);
		panelAcciones.add(btnEnviar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setBackground(new Color(178, 34, 34));
		btnLimpiar.setBounds(1172, 665, 90, 28);
		panelAcciones.add(btnLimpiar);

		JPanel shadowPane = new JPanel();
		shadowPane.setBackground(Color.DARK_GRAY);
		shadowPane.setBounds(0, 0, 1280, 720);
		contentPane.add(shadowPane);
		shadowPane.setLayout(null);
		
		btnAlumnos.setRolloverIcon(new ImageIcon(darkGray));
		btnAsignaturas.setRolloverIcon(new ImageIcon(darkGray));
		btnCursos.setRolloverIcon(new ImageIcon(darkGray));
		btnDocentes.setRolloverIcon(new ImageIcon(darkGray));
		btnNoticias.setRolloverIcon(new ImageIcon(darkGray));
		btnOpciones.setRolloverIcon(new ImageIcon(darkGray));
		registrarEventos();
		//inicializar();
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

	}

	private void mostrarTabla() {
		/*try {
			comboBox_tablas.addItem(rs.getString("Nombre"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	private void inicializar(){
		BaseDatos.getBBDD().conectar();
		rs = BaseDatos.getBBDD().obtenerDatos();
		try {
			if(rs.first()){
				//comboBox_tablas.addItem(rs.getString("idPerfil"));
				mostrarTabla();
			}
			while(rs.next()){
				//comboBox_tablas.addItem(rs.getString("idPerfil"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
}

