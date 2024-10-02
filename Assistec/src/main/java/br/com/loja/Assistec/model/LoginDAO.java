package br.com.loja.assistec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.loja.assistec.dal.ConexaoBD;

public class LoginDAO extends GenericDAO{

	public Boolean bancoOnline() throws SQLException {
		return getConnection().isValid(0);
	}

	

	// Aqui vai o método autenticar
	public Usuario autenticar(String login, String senha) {
		String sql = "SELECT * FROM usuarios WHERE login=? AND senha=?";
		Usuario user = null;
		PreparedStatement pst = getConnection().prepareStatement(sql);
		pst.setString(1, login);
		pst.setString(2, senha);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			user = new Usuario();
			user.setIduser(rs.getInt("iduser"));
			user.setNome(rs.getString("nome"));
			user.setFone(rs.getString("fone"));
			user.setLogin(rs.getString("login"));
			user.setSenha(rs.getString("senha"));
			user.setPerfil(rs.getString("perfil"));
		}
		rs.close();
		pst.close();
		getConnection().close();
		return user;
		
	}

	
}
