
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Rectangle;

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
import java.util.Vector;

import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JWindow;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.mysql.fabric.xmlrpc.base.Array;

import javax.swing.JScrollBar;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class GestionAlmi extends JFrame {

	private JPanel contentPane;
	private Image almi;
	private ResultSet rs;
	private Image circSalir;
	private Image circMinimizar;
	private Image clarSalir;
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
	private JTextField passwordField;
	private JPanel panelRegistro;
	private JButton btnCerrarReg;
	private ArrayList<JButton> tablas;
	private ArrayList<JLabel> labels;
	private PanelModificaciones panelModificaciones;
	private JPanel panelAcciones;
	private JButton btnEnviar;
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
	private JLabel lblFondoReg;
	private JButton btnSql;
	private Image fondoDegradado;
	private PanelModificaciones panelito;
	private JTextField txtBuscar;
	private JPanel panelBuscar;
	private JLabel lblUsu;
	private JPasswordField passwordField_1;
	private JLabel lblPassword;
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

		fondoDegradado = new ImageIcon(getClass().getResource("fondoReg.jpg")).getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		lblFondoReg = new JLabel();
		lblFondoReg.setIcon(new ImageIcon(fondoDegradado));
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
		lblPerfilUsu.setBounds(220, 210, 82, 34);
		panelRegistro.add(lblPerfilUsu);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(220, 240, 220, 25);
		panelRegistro.add(comboBox);

		lblUsu = new JLabel("Nickname");
		lblUsu.setForeground(SystemColor.menu);
		lblUsu.setBounds(220, 270, 220, 34);
		panelRegistro.add(lblUsu);

		passwordField = new JTextField();
		passwordField.setBounds(220, 300, 220, 20);
		panelRegistro.add(passwordField);

		lblPassword = new JLabel("Password");
		lblPassword.setForeground(SystemColor.menu);
		lblPassword.setBounds(220, 320, 220, 34);
		panelRegistro.add(lblPassword);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(220, 350, 220, 20);
		panelRegistro.add(passwordField_1);

		btnCerrarReg = new JButton("X");
		btnCerrarReg.setFont(new Font("Dialog", Font.BOLD, 24));
		btnCerrarReg.setForeground(Color.WHITE);
		btnCerrarReg.setBounds(900, 0, 55, 51);
		btnCerrarReg.setContentAreaFilled(false);
		btnCerrarReg.setBorder(null);
		btnCerrarReg.setOpaque(false);
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
		lblRegistro.setBackground(new Color(11, 32, 15));

		panelAcciones = new JPanel();
		panelAcciones.setBorder(null);
		panelAcciones.setBounds(311, 35, 969, 685);
		contentPane.add(panelAcciones);
		panelAcciones.setLayout(null);
		panelAcciones.setBackground(contentPane.getBackground());

		panelBuscar = new JPanel();
		panelBuscar.setBounds(635, 0, 245, 45);
		panelAcciones.add(panelBuscar);

		txtBuscar = new JTextField();
		panelBuscar.add(txtBuscar);
		txtBuscar.setColumns(10);

		panelito = new PanelModificaciones();
		panelito.getTable().setLocation(48, 11);
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
		btnEnviar.setForeground(Color.DARK_GRAY);
		btnEnviar.setBackground(Color.LIGHT_GRAY);
		btnEnviar.setBounds(765, 633, 90, 28);
		panelAcciones.add(btnEnviar);
		tablas = new ArrayList<JButton>();
		labels = new ArrayList<JLabel>();


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
		panelBuscar.setVisible(false);
		panelBuscar.setBackground(SystemColor.controlDkShadow);

		panelRegistro.add(lblFondoReg);
		btnCerrarSesion.setContentAreaFilled(false);
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setOpaque(true);

		lblNombreUsu.setText(Login.getUser());
		botonesTablas(tablas, labels);
		registrarEventos();
	}

	//ESTO ES PARA LOS BOTONES DEL PANEL IZQUIERDO
	private void animacionBotones(JButton btn, JLabel lbl) {
		btn.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
			}
			public void mousePressed(MouseEvent e) {
				if(btn.equals(btnRegistro)){
					panelRegistro.setVisible(true);
					lblFondoReg.setVisible(true);
					for(int i=0; i<1280;i++){
						panelRegistro.setBounds(panelRegistro.getX(), panelRegistro.getY(), panelRegistro.getWidth()+i, panelRegistro.getHeight());
						lblFondoReg.setBounds(0, 0, panelRegistro.getWidth()+i, panelRegistro.getHeight());
					}
					for(i=7;i<tablas.size();i++) {
						tablas.get(i).setVisible(false);
						panelAcciones.setVisible(false);
					}
				}else{
					for(i=0;i<tablas.size();i++) {
						tablas.get(i).setVisible(true);
						panelAcciones.setVisible(true);
					}
					panelRegistro.setVisible(false);
					lblFondoReg.setVisible(false);
					btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
					panelAcciones.setBackground(lbl.getBackground());
					mostrarDatos(btn.getText());
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
	//ESTO ES PARA LOS BOTONES DEL PANEL DERCHO
	private void animacionBotones(JButton btn) {
		btn.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
			}
			public void mousePressed(MouseEvent e) {
				btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
				if(btn.equals(btnNuevo)){
					System.out.println("plakaplaka");
					panelito.getTable().setCellSelectionEnabled(true);
					panelito.getTableModel().addRow(new Vector<>());
					panelito.getTable().editCellAt(panelito.getTableModel().getRowCount()-1,0);
					panelito.getTable().scrollRectToVisible(new Rectangle(panelito.getTable().getCellRect(panelito.getTableModel().getRowCount()-1,0, true)));
					panelito.getTable().requestFocus();
				}
				if(btn.equals(btnEliminar)){
					eliminarRegistro(btn);
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
	private void registrarEventos() {
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!panelBuscar.isVisible()) {
					panelBuscar.setVisible(true);
				}else {
					panelBuscar.setVisible(false);
				}
			}
		});
		txtBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable table = panelito.getTable();
				String value = txtBuscar.getText();
				for (int row = 0; row <= table.getRowCount() - 1; row++) {
					for (int col = 0; col <= table.getColumnCount() - 1; col++) {
						if (value.equals(table.getValueAt(row, col))) {
							table.scrollRectToVisible(table.getCellRect(row, 0, true));
							table.setRowSelectionInterval(row, row);
							for (int i = 0; i <= table.getColumnCount() - 1; i++) {
								table.getColumnModel().getColumn(i).setCellRenderer(new HighlightRenderer());
							}
						}
					}
				}
			}
		});
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
				for(i=0;i<tablas.size();i++) {
					tablas.get(i).setVisible(true);
					panelAcciones.setVisible(true);
				}
			}
		});
		//AQUI GENERAMOS EL UPDATE
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseDatos.getBBDD().conectar();


				int col[] = panelito.getTable().getSelectedColumns();
				int row[] = panelito.getTable().getSelectedRows();

				for(i=0;i<col.length;i++){
					String columna = panelito.getTable().getColumnName(col[i]);
					String valor = panelito.getTable().getValueAt(panelito.getTable().getSelectedRow(), col[i]).toString();
					String idTabla = panelito.getTable().getModel().getColumnName(0);
					String id = panelito.getTable().getModel().getValueAt(panelito.getTable().getSelectedRow(), 0).toString();

					System.out.println(idTabla+id);
					BaseDatos.getBBDD().modificarDatos(panelito.getTable(), columna, valor, idTabla, id);
				}

				BaseDatos.getBBDD().desconectar();
			}
		});
		//EJECUTAMOS INSERT INTO
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoRegistro(btnAlumnos);
			}
		});
	}
	//ELIMINA EL REGISTO DE LA CELDA SELECCIONADA
	protected void eliminarRegistro(JButton btn) {
		BaseDatos.getBBDD().conectar();
		if(panelito.getTable().getSelectedRows() != null){
			int answer = JOptionPane.showConfirmDialog(new JOptionPane(), "¿Está seguro que desea eliminar la fila completa?");
			if(answer==0){
				panelModificaciones = new PanelModificaciones();
				String tablaNom = new String();
				rs=BaseDatos.getBBDD().obtenerDatos(panelito.getTable());
				try {
					rs.first();
					tablaNom = rs.getMetaData().getTableName(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(tablaNom);
				String columna = panelito.getTable().getColumnName(panelito.getTable().getSelectedColumn());
				String valor = panelito.getTable().getValueAt(panelito.getTable().getSelectedRow(), panelito.getTable().getSelectedColumn()).toString();
				BaseDatos.getBBDD().borrarDatos(columna, valor, tablaNom);
				mostrarDatos(btn.getText());
				BaseDatos.getBBDD().desconectar();
			}
		}
	}
	//AÑADIR REGISTRO
	protected void nuevoRegistro(JButton btn) {
		int col[] = panelito.getTable().getSelectedColumns();
		BaseDatos.getBBDD().conectar();

		panelModificaciones = new PanelModificaciones();
		String tablaNom = new String();
		rs=BaseDatos.getBBDD().obtenerDatos(panelito.getTable());
		try {
			rs.first();
			tablaNom = rs.getMetaData().getTableName(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for(i=0;i<col.length;i++){
			String columna = panelito.getTable().getColumnName(col[i]);
			String valor = panelito.getTable().getValueAt(panelito.getTable().getSelectedRow(), col[i]).toString();
			BaseDatos.getBBDD().insertarDatos(columna, valor, tablaNom);	
		}
		mostrarDatos(btn.getText());
		BaseDatos.getBBDD().desconectar();
	}
	protected void mostrarDatos(String nombreTabla) {
		BaseDatos.getBBDD().conectar();

		switch (nombreTabla) {

		case "Alumnos": 
			try {
				panelito.llenarTabla(BaseDatos.getBBDD().getAlumnos(), panelito.getTable());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "Asignaturas": 
			try {
				panelito.llenarTabla(BaseDatos.getBBDD().getAsignaturas(), panelito.getTable());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "Cursos": 
			try {
				panelito.llenarTabla(BaseDatos.getBBDD().getCursos(), panelito.getTable());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			break;
		case "Docentes":
			try {
				panelito.llenarTabla(BaseDatos.getBBDD().getDocentes(), panelito.getTable());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "Noticias": 
			try {
				panelito.llenarTabla(BaseDatos.getBBDD().getNoticias(), panelito.getTable());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "Más opciones...":
			break;

		case "Registrar Usuario": 
			break;

		default:
			break;
		}
		BaseDatos.getBBDD().desconectar();

	}
	private void botonesTablas(ArrayList<JButton> tablas, ArrayList<JLabel> labels) {
		//PARA DAR ATRIBUTOS A LOS BOTONES DE FORMA GENERICA
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
				// PONER TEXTO DEBAJO DEL ICONO Y CENTRARLO
				tablas.get(i).setVerticalTextPosition(SwingConstants.BOTTOM);
				tablas.get(i).setHorizontalTextPosition(SwingConstants.CENTER); 
				animacionBotones(tablas.get(i));
				panel_1.add(tablas.get(i));
			}
		}
	}
	private class HighlightRenderer extends DefaultTableCellRenderer {

		//ESTA FUNCION COLOREA LA FILA QUE TIENE EL VALOR BUSCADO
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			if(row == table.getSelectedRow()) {
				setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
			}
			if(!isSelected){
				c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
			}
			return this;
		}
	}

}
