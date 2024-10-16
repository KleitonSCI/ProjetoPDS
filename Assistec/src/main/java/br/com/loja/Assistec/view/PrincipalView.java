package br.com.loja.assistec.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView frame = new PrincipalView(null,null);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalView(String user,String perfil) {
		
		
		
		
		setTitle("FÁBIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Sair");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sair = JOptionPane.showConfirmDialog(null,"Você realmente deseja sair?","Aviso",JOptionPane.YES_NO_OPTION);
				System.out.println(sair);
				if(sair==0) {
					System.exit(0);
				}
				
				
			}
		});
		mnArquivo.add(mntmNewMenuItem);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setEnabled(false);
		menuBar.add(mnCadastro);
		
		JMenuItem mniUsuarios = new JMenuItem("Usuários");
		mniUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuarioView tela = new ListarUsuarioView();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
			}
		});
		mnCadastro.add(mniUsuarios);
		
		JMenu mnRelatorio = new JMenu("Relatórios");
		mnRelatorio.setEnabled(false);
		menuBar.add(mnRelatorio);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnRelatorio.add(mntmNewMenuItem_1);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mniSobre = new JMenuItem("Sobre");
		mniSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Version: MilkCandy 1.0");
			}
		});
		mnAjuda.add(mniSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblUsuario = new JLabel(user + " - "+ perfil);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblUsuario)
					.addContainerGap(378, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(215, Short.MAX_VALUE)
					.addComponent(lblUsuario))
		);
		contentPane.setLayout(gl_contentPane);
		if("admin".equalsIgnoreCase(perfil)) {
			mnCadastro.setEnabled(true);
			mnRelatorio.setEnabled(true);
		}
	}
	
		
	
}
