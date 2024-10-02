package br.com.loja.assistec.controller;

import br.com.loja.assistec.model.LoginDAO;

public class LoginController {
	
	public LoginController() {
		
		 		
	}
	
	public Boolean verificarBancoOnline() {
		 LoginDAO dao = new LoginDAO();
		 return dao.bancoOnline();
		
	}

	
	
}
