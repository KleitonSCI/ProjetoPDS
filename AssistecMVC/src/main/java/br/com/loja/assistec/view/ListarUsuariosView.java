package br.com.loja.assistec.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;

import br.com.loja.assistec.controller.UsuarioController;
import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioTableModel;

public class ListarUsuariosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtLocalizar;
	private JButton btnCadastrar;
	private JButton btnFechar;
	
	private JTable tabela;
	private ArrayList<Usuario> usuariosList;
//	private ListarUsuariosView listarUsusariosView;
	private UsuarioTableModel usuarioTableModel;
	private TableRowSorter<UsuarioTableModel> rowSorter;
	private JScrollPane scrollPane;

	

	public ListarUsuariosView()  {
		
		inicializarComponentes();
		configurarJanela();
	}
	
	public void inicializarComponentes() {
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setActionCommand("BotaoCadastrarAction");
		btnCadastrar.setBounds(39, 34, 103, 133);
		txtLocalizar = new JTextField();
		txtLocalizar.setBounds(139, 12, 252, 20);
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setActionCommand("BotaoFecharAction");
		btnFechar.setBounds(99, 321, 416, 33);
		tabela = new JTable();
		scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(39,95,530,215);
		getContentPane().setLayout(null);
		getContentPane().add(btnCadastrar);
		getContentPane().add(btnFechar);
		getContentPane().add(txtLocalizar);
		getContentPane().add(scrollPane);
	}
	
	
	public void configurarJanela() {
		setTitle("Listagem de usuários");
		setBounds(100, 100, 650, 420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public void addListarUsuariosListener(ActionListener listener) {
		btnCadastrar.addActionListener(listener);
		btnFechar.addActionListener(listener);
	}
	
	

	}
