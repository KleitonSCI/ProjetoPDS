package br.com.loja.assistec.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.loja.assistec.controller.LoginController;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JButton btnLogin;
	private JLabel lblStatus;
	private JLabel lblLogin;
	private JLabel lblSenha;

	public LoginView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				LoginController lc = new LoginController();
				if (lc.verificarBancoOnline()) {
					lblStatus.setIcon(new javax.swing.ImageIcon(
							getClass().getResource("/br/com/loja/assistec/icones/dbok.png")));
				} else {
					lblStatus.setIcon(new javax.swing.ImageIcon(
							getClass().getResource("/br/com/loja/assistec/icones/dberror.png")));
				}
			}
		});
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ASSISTEC - LOGIN");

		// Inicializa todos elementos gráficos

		lblLogin = new JLabel();
		lblLogin.setBounds(102, 63, 53, 14);
		lblSenha = new JLabel();
		lblSenha.setBounds(102, 102, 64, 14);
		txtLogin = new JTextField();
		txtLogin.setBounds(176, 60, 127, 20);
		txtSenha = new JPasswordField();
		txtSenha.setBounds(176, 98, 128, 22);
		btnLogin = new JButton();

		btnLogin.setBounds(179, 155, 76, 23);

		lblStatus = new JLabel();
		lblStatus.setBounds(10, 213, 63, 37);

		lblLogin.setText("Login");
		lblSenha.setText("Senha");
		btnLogin.setText("Entrar");

		getRootPane().setDefaultButton(btnLogin);
		getContentPane().setLayout(null);
		getContentPane().add(lblStatus);
		getContentPane().add(btnLogin);
		getContentPane().add(lblSenha);
		getContentPane().add(lblLogin);
		getContentPane().add(txtSenha);
		getContentPane().add(txtLogin);

	}



}
