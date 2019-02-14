
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

		JMenu mnNewMenu_1 = new JMenu("Propiedades");
		mnNewMenu_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.setBounds(0, 0, 50, 50);

		JMenu mnNewMenu_2 = new JMenu("Ayuda");
		mnNewMenu_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_2);

		Component horizontalStrut = Box.createHorizontalStrut(872);
		menuBar.add(horizontalStrut);

		JLabel lblNewLabel = new JLabel("Sesi\u00F3n: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(lblNewLabel);

		JLabel lblNekane = new JLabel("Nekane");
		menuBar.add(lblNekane);

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
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
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

		JLabel lblPerfiles = new JLabel("Alumnos");
		lblPerfiles.setForeground(Color.WHITE);
		lblPerfiles.setOpaque(true);
		lblPerfiles.setBackground(Color.DARK_GRAY);
		lblPerfiles.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfiles.setBounds(0, 248, 311, 70);
		panel.add(lblPerfiles);

		JLabel lblAsignaturas = new JLabel("Asignaturas");
		lblAsignaturas.setForeground(Color.WHITE);
		lblAsignaturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsignaturas.setBounds(0, 317, 311, 70);
		lblAsignaturas.setOpaque(true);
		lblAsignaturas.setBackground(lblPerfiles.getBackground());
		panel.add(lblAsignaturas);

		JLabel lblNoticias = new JLabel("Cursos");
		lblNoticias.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoticias.setForeground(Color.WHITE);
		lblNoticias.setBounds(0, 387, 311, 70);
		lblNoticias.setOpaque(true);
		lblNoticias.setBackground(lblPerfiles.getBackground());
		panel.add(lblNoticias);

		JLabel lblDocentes = new JLabel("Docentes");
		lblDocentes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDocentes.setForeground(Color.WHITE);
		lblDocentes.setBounds(0, 457, 311, 70);
		lblDocentes.setOpaque(true);
		lblDocentes.setBackground(lblPerfiles.getBackground());
		panel.add(lblDocentes);

		JLabel lblNoticias_1 = new JLabel("Noticias");
		lblNoticias_1.setOpaque(true);
		lblNoticias_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoticias_1.setForeground(Color.WHITE);
		lblNoticias_1.setBackground(Color.DARK_GRAY);
		lblNoticias_1.setBounds(0, 527, 311, 70);
		panel.add(lblNoticias_1);

		JLabel lblOtrasTablas = new JLabel("Otras tablas...");
		lblOtrasTablas.setOpaque(true);
		lblOtrasTablas.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtrasTablas.setForeground(Color.WHITE);
		lblOtrasTablas.setBackground(Color.DARK_GRAY);
		lblOtrasTablas.setBounds(0, 597, 311, 70);
		panel.add(lblOtrasTablas);

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

		registrarEventos();
		//inicializar();
		//mostrarTabla();
	}

	private void registrarEventos() {
		btnSalir.addActionListener(new ActionListener() {

			@Override
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



			@Override
			public void mousePressed(MouseEvent arg0) {
				mx = arg0.getX();
				my = arg0.getY();

			}

		});
		menuBar.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {


			}

			@Override
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
		bd = new BaseDatos("sarabaras");
		bd.conectar();
		rs = bd.obtenerDatos();
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