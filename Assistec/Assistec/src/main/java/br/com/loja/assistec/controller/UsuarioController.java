package br.com.loja.assistec.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioDAO;

public class UsuarioController {
	public UsuarioController() {
		
	}
	public ArrayList<Usuario> listarUsuarios() throws SQLException{
		UsuarioDAO dao = new UsuarioDAO();
		return dao.selecionarUsuarios();
	}
	
	public void salvar(String nome,String fone,String login,String senha,String perfil) throws SQLException {
		Usuario user = new Usuario();
		user.setNome(nome);
		user.setFone(fone);
		user.setSenha(senha);
		user.setLogin(login);
		user.setPerfil(perfil);
		new UsuarioDAO().salvar(user);
	}
}
