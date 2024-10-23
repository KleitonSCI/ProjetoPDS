package br.com.loja.assistec.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;

import br.com.loja.assistec.controller.UsuarioController;
import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioTableModel;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ListarUsuariosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtLocalizar;
	private JTable tabela;
	private ArrayList<Usuario> usuariosList;
	private ListarUsuariosView listarUsuariosView;
	private UsuarioTableModel usuarioTableModel;
	private TableRowSorter <UsuarioTableModel> rowSorter;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarUsuariosView frame = new ListarUsuariosView();
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
	public ListarUsuariosView() throws SQLException {
		this.listarUsuariosView = this;
		usuariosList = new ArrayList<>();
		UsuarioController uc = new UsuarioController();
		usuariosList = uc.listarUsuarios();
		setTitle("Listagem de usuários");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarUsuariosView cadUser = 
						new CadastrarUsuariosView();
				cadUser.setLocationRelativeTo(cadUser);
				cadUser.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				cadUser.setVisible(true);
			}
		});
		btnCadastrar.setBounds(10, 38, 117, 23);
		getContentPane().add(btnCadastrar);
		
		txtLocalizar = new JTextField();
		txtLocalizar.setBounds(139, 39, 252, 20);
		getContentPane().add(txtLocalizar);
		txtLocalizar.setColumns(10);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(189, 216, 89, 23);
		getContentPane().add(btnFechar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 70, 356, 139);
		getContentPane().add(scrollPane);
		
		usuarioTableModel = new UsuarioTableModel(usuariosList);
		
		tabela = new JTable();
		tabela.setModel(usuarioTableModel);
		scrollPane.setViewportView(tabela);

	}
}
