package br.com.loja.assistec.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.loja.assistec.controller.UsuarioController;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;

public class CadastrarUsuariosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JComboBox cbxPerfil;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarUsuariosView frame = new CadastrarUsuariosView();
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
	public CadastrarUsuariosView() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		getContentPane().add(header, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Usuários");
		header.add(lblNewLabel);
		
		JPanel footer = new JPanel();
		getContentPane().add(footer, BorderLayout.SOUTH);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!"".equalsIgnoreCase(txtLogin.getText())&&(!"".equalsIgnoreCase(String.valueOf(txtSenha.getPassword()))))) {
					UsuarioController uc = new UsuarioController();
					String perfil = (String) cbxPerfil.getSelectedItem();
					try {
						uc.salvar(txtNome.getText(), txtFone.getText(), txtLogin.getText(), String.valueOf(txtSenha.getPassword()), perfil);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		footer.add(btnIncluir);
		
		JButton btnExcluir = new JButton("Excluir");
		footer.add(btnExcluir);
		
		JButton btnFechar = new JButton("Fechar");
		footer.add(btnFechar);
		
		JPanel content = new JPanel();
		getContentPane().add(content, BorderLayout.CENTER);
		content.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		content.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		content.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fone");
		content.add(lblNewLabel_2);
		
		txtFone = new JTextField();
		content.add(txtFone);
		txtFone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Login");
		content.add(lblNewLabel_3);
		
		txtLogin = new JTextField();
		content.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Senha");
		content.add(lblNewLabel_4);
		
		txtSenha = new JPasswordField();
		content.add(txtSenha);
		
		JLabel lblNewLabel_5 = new JLabel("Perfil");
		content.add(lblNewLabel_5);
		
		cbxPerfil = new JComboBox();
		cbxPerfil.setModel(new DefaultComboBoxModel(new String[] {"User", "Admin"}));
		content.add(cbxPerfil);

	}

}
