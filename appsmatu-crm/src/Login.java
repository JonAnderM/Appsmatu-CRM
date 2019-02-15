import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;



public class Login extends JFrame {

	private JPanel contentPane;
	private Character passChar[];
	private ImageIcon fondoLogin;
	private Graphics g;
	private JLabel label;
	private JPasswordField txtpnPassword;
	private JTextField txtpnUser;
	private String plainPassword;
	private JButton btnClose;
	private JButton btnLogin;
	private String user;
	private String password;
	private JLabel lblWeb;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					
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
	public Login() {

		fondoLogin = new ImageIcon(getClass().getResource("login.png"));
		setUndecorated(true);
		setBounds(450, 300, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		btnLogin = new JButton("Login");
		btnLogin.setForeground(SystemColor.menu);
		btnLogin.setBounds(258, 207, 89, 23);
		btnLogin.setBorder(null);
		btnLogin.setBackground(Color.DARK_GRAY);
		panel.add(btnLogin);

		btnClose = new JButton("Close");
		btnClose.setForeground(SystemColor.menu);
		btnClose.setBounds(370, 207, 89, 23);
		btnClose.setBorder(null);
		btnClose.setBackground(Color.DARK_GRAY);
		panel.add(btnClose);

		lblWeb = new JLabel();

		lblWeb.setBounds(10, 73, 195, 139);
		panel.add(lblWeb);

		txtpnUser = new JTextField();
		txtpnUser.setEditable(false);
		txtpnUser.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtpnUser.setText("User");
		txtpnUser.setBounds(258, 98, 201, 33);
		panel.add(txtpnUser);
		txtpnUser.setForeground(Color.GRAY);

		txtpnPassword = new JPasswordField();
		txtpnPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtpnPassword.setText("Password");
		txtpnPassword.setBounds(258, 159, 201, 33);
		panel.add(txtpnPassword);
		txtpnPassword.setEditable(false);
		txtpnPassword.setForeground(Color.GRAY);
		plainPassword = new String();


		label = new JLabel("");
		label.setBounds(0, 0, 500, 300);
		panel.add(label);
		label.setIcon(new ImageIcon(getClass().getResource("login.png")));

		resgistrarEventos();
	}

	private void resgistrarEventos() {
		lblWeb.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				openWeb(arg0);
			}
		});
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				System.out.println(digest("SHA-256", "Almi123"));
				System.out.println(String.valueOf(txtpnPassword.getPassword()));
				System.out.println(digest("SHA-256", String.valueOf(txtpnPassword.getPassword())));
				 */
				if(login(txtpnUser.getText().toString(), digest("SHA-256", String.valueOf(txtpnPassword.getPassword())))){
					Login.this.setVisible(false);
					GestionAlmi.main(null);
				}
			}
		});
		txtpnUser.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if(!txtpnUser.isEditable()){
					txtpnUser.setEditable(true);
					txtpnUser.setText("");
					txtpnUser.setForeground(Color.BLACK);
					txtpnPassword.setEditable(true);
					txtpnPassword.setText("");
					txtpnPassword.setForeground(Color.BLACK);
				}
			}
		});


		txtpnPassword.addMouseListener(new MouseAdapter() {


			@Override
			public void mousePressed(MouseEvent e) {
				if(!txtpnPassword.isEditable()){
					txtpnUser.setEditable(true);
					txtpnUser.setText("");
					txtpnUser.setForeground(Color.BLACK);
					txtpnPassword.setEditable(true);
					txtpnPassword.setText("");
					txtpnPassword.setForeground(Color.BLACK);
				}
			}
		});
		txtpnUser.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_TAB){
					txtpnPassword.grabFocus();
				}
				txtpnUser.grabFocus();
				if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE && !txtpnUser.getText().isEmpty()){
					txtpnUser.setText(txtpnUser.getText().substring(0, txtpnUser.getText ().length() - 1));
				}
				e.consume();
			}
		});
		txtpnPassword.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_TAB){
					txtpnUser.grabFocus();
				}
				txtpnPassword.grabFocus();
			}
		});
	}


	public boolean login(String user, String passwd) {
		BaseDatos.getBBDD().conectar();

		if(BaseDatos.getBBDD().loginUser(user, passwd)){
			BaseDatos.getBBDD().desconectar();
			return true;
		}else{
			BaseDatos.getBBDD().desconectar();
			JOptionPane.showMessageDialog(this, "Usuario o contraseña no válidos");
			txtpnUser.setText("");
			txtpnPassword.setText("");
			return false;
		}
	}


	private void openWeb(MouseEvent arg0) {                                         
		try { 
			String url = "https://www.almi.eus";
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		}
		catch (java.io.IOException e) {
			System.out.println(e.getMessage());
		}
	}    
	
	//CON ESTO CODIFICAMOS LA CONTRASEÑA EN SHA-256 PARA COMPARARLA CON LA ALMACENADA EN LA BBDD
	private static String encodeHex(byte[] digest) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < digest.length; i++) {
	        sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
	    }
	    return sb.toString();
	}
	
	public static String digest(String alg, String input) {
	    try {
	        MessageDigest md = MessageDigest.getInstance(alg);
	        byte[] buffer = input.getBytes("UTF-8");
	        md.update(buffer);
	        byte[] digest = md.digest();
	        return encodeHex(digest);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return e.getMessage();
	    }
	}


}
