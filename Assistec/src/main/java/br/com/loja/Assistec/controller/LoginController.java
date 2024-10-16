package br.com.loja.assistec.controller;

import br.com.loja.assistec.model.LoginDAO;

public class LoginController {

	public LoginController() {

	}

	// Método para verificar se o banco está online
	public Boolean verificarBancoOnline() {
		LoginDAO dao = new LoginDAO();
		return dao.bancoOnline();

	}

}
