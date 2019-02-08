import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JPasswordField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Diseño extends JFrame {

	private JPanel contentPane;
	private ImageIcon almi;
	private JComboBox comboBox_tablas;
	private BaseDatos bd;
	private ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diseño frame = new Diseño();
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
	public Diseño() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		JPanel authorization = new JPanel();
		authorization.add(new JLabel ("test"));
		options.addTab("test",authorization);
		*/
		JPanel panelAcciones = new JPanel();
		panelAcciones.setBorder(null);
		panelAcciones.setBounds(28, 23, 870, 530);
		contentPane.add(panelAcciones);
		panelAcciones.setLayout(null);
		
		JTabbedPane panelGrafico = new JTabbedPane(JTabbedPane.LEFT);
		panelGrafico.setBounds(243, 43, 601, 306);
		panelAcciones.add(panelGrafico);
		
		JPanel panelCrear = new JPanel();
		panelCrear.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGrafico.addTab("Crear", new ImageIcon("C:\\Users\\dam1-asier\\Downloads\\icon.png"), panelCrear, null);
		panelCrear.setLayout(null);
		
		JPanel panelModificar = new JPanel();
		panelModificar.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGrafico.addTab("Modificar", new ImageIcon("C:\\Users\\dam1-asier\\Downloads\\icon.png"), panelModificar, "");
		panelModificar.setLayout(null);
		panelGrafico.setForegroundAt(1, Color.BLACK);
		
		JPanel panelEliminar = new JPanel();
		panelGrafico.addTab("Eliminar", new ImageIcon("C:\\Users\\dam1-asier\\Downloads\\icon.png"), panelEliminar, null);
		panelEliminar.setLayout(null);
		
		JPanel panelBusquedas = new JPanel();
		panelGrafico.addTab("Busquedas", new ImageIcon("C:\\Users\\dam1-asier\\Downloads\\icon.png"), panelBusquedas, null);
		panelBusquedas.setLayout(null);
		
		JPanel panelSQL = new JPanel();
		panelGrafico.addTab("SQL", new ImageIcon("C:\\Users\\dam1-asier\\Downloads\\icon.png"), panelSQL, null);
		panelSQL.setLayout(null);
		
		comboBox_tablas = new JComboBox();
		comboBox_tablas.setBounds(16, 128, 186, 20);
		panelAcciones.add(comboBox_tablas);
		
		JButton btnEnviar = new JButton("A\u00F1adir");
		btnEnviar.setBounds(460, 409, 90, 28);
		panelAcciones.add(btnEnviar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(460, 449, 90, 28);
		panelAcciones.add(btnLimpiar);
		
		JLabel lblTablaQueDesea = new JLabel("Tabla que desea editar:");
		lblTablaQueDesea.setBounds(16, 100, 186, 16);
		panelAcciones.add(lblTablaQueDesea);
		
		inicializar();
		mostrarTabla();
	}
	
    private void mostrarTabla() {
		try {
			comboBox_tablas.addItem(rs.getString("Nombre"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void inicializar(){
		bd = new BaseDatos("perfiles");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
}

