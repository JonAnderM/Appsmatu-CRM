
import java.awt.EventQueue;
import java.awt.Image;

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
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionAlmi extends JFrame {

	private JPanel contentPane;
	private Login login;
	private Image almi;
	private JComboBox comboBox_tablas;
	private BaseDatos bd;
	private ResultSet rs;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionAlmi frame = new GestionAlmi();
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
	public GestionAlmi() {
		
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 70, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0, 102, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		almi = new ImageIcon(getClass().getResource("Almi logo.png")).getImage().getScaledInstance(301, 151, Image.SCALE_SMOOTH);
		
		/*
		JPanel authorization = new JPanel();
		authorization.add(new JLabel ("test"));
		options.addTab("test",authorization);
		*/
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1280, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo  ");
		mnNewMenu.setBounds(0, 0, 50, 50);
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Propiedades    ");
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.setBounds(0, 0, 50, 50);
		
		JMenu mnNewMenu_2 = new JMenu("Ayuda  ");
		menuBar.add(mnNewMenu_2);
		
		Component horizontalStrut = Box.createHorizontalStrut(872);
		menuBar.add(horizontalStrut);
		
		JLabel lblNewLabel = new JLabel("Sesi\u00F3n: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(lblNewLabel);
		
		JLabel lblNekane = new JLabel("Nekane");
		menuBar.add(lblNekane);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setBackground(new Color(178, 34, 34));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(getX(), getY(), 30, 30);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		JButton button = new JButton("_");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(255, 215, 0));
		menuBar.add(button);
		menuBar.add(btnNewButton);
		JPanel panelAcciones = new JPanel();
		panelAcciones.setBorder(null);
		panelAcciones.setBounds(0, 0, 1274, 720);
		contentPane.add(panelAcciones);
		panelAcciones.setLayout(null);
		
		JTabbedPane panelGrafico = new JTabbedPane(JTabbedPane.LEFT);
		panelGrafico.setBounds(368, 80, 870, 469);
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
		
		comboBox_tablas = new JComboBox();
		comboBox_tablas.setBounds(38, 206, 128, 20);
		panel.add(comboBox_tablas);
		
		JLabel lblTablaQueDesea = new JLabel("Tabla que desea editar:");
		lblTablaQueDesea.setBounds(39, 180, 186, 16);
		panel.add(lblTablaQueDesea);
		lblTablaQueDesea.setForeground(SystemColor.text);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 30, 301, 151);
		panel.add(label);
		label.setIcon(new ImageIcon(almi));
		
		JLabel lblPerfiles = new JLabel("Perfiles");
		lblPerfiles.setForeground(Color.WHITE);
		lblPerfiles.setOpaque(true);
		lblPerfiles.setBackground(Color.DARK_GRAY);
		lblPerfiles.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfiles.setBounds(0, 255, 311, 52);
		panel.add(lblPerfiles);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 307, 311, 52);
		label_1.setOpaque(true);
		label_1.setBackground(lblPerfiles.getBackground());
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(0, 358, 311, 52);
		label_2.setOpaque(true);
		label_2.setBackground(lblPerfiles.getBackground());
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(0, 410, 311, 52);
		label_3.setOpaque(true);
		label_3.setBackground(lblPerfiles.getBackground());
		panel.add(label_3);
		
		JButton btnEnviar = new JButton("A\u00F1adir");
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setBackground(new Color(0, 100, 0));
		btnEnviar.setBounds(1029, 618, 90, 28);
		panelAcciones.add(btnEnviar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setBackground(new Color(178, 34, 34));
		btnLimpiar.setBounds(1148, 618, 90, 28);
		panelAcciones.add(btnLimpiar);
		
		//inicializar();
		//mostrarTabla();
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
				comboBox_tablas.addItem(rs.getString("idPerfil"));
				mostrarTabla();
			}
			while(rs.next()){
				comboBox_tablas.addItem(rs.getString("idPerfil"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	}
}