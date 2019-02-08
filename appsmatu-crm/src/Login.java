import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import com.mysql.fabric.xmlrpc.base.Array;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private Character passChar[];
	private ImageIcon fondoLogin;
	private Graphics g;
	private JLabel label;
	private JPasswordField txtpnPassword;
	private JTextField txtpnUser;
	private JButton btnNewButton;
	private String plainPassword;
	private JButton btnClose;
	private JButton btnLogin;


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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnLogin.setBounds(258, 207, 89, 23);
		panel.add(btnLogin);

		btnClose = new JButton("Close");
		btnClose.setBounds(370, 207, 89, 23);
		panel.add(btnClose);

		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 73, 195, 139);
		btnNewButton.setVisible(false);
		panel.add(btnNewButton);

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
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

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
	public static String sha256(String password) {
		try{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			String encoded = Base64.getEncoder().encodeToString(hash);

			return encoded;
		} catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
}
