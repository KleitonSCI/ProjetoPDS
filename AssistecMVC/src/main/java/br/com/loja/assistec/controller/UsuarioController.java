package br.com.loja.assistec.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioDAO;

public class UsuarioController {


public ArrayList<Usuario> listarUsuarios() throws SQLException{
	ArrayList<Usuario> lista = new ArrayList<>();
	UsuarioDAO dao = new UsuarioDAO();
	
	return dao.selecionarUsuarios();
}
public void salvar(Usuario user) {
	
}
}
