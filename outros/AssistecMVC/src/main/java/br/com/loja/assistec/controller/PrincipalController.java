package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Principal;

import br.com.loja.assistec.view.PrincipalView;

public class PrincipalController {
	private Principal dao;
	private PrincipalView view;
	public PrincipalController() {
		this.dao=dao;
		this.view=view;
		this.view.setLocationRelativeTo(null);
		this.view.setVisible(true);
	}
	
	private class PrincipalListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if("SairAction".equals(e.getActionCommand())) {
				
			}
		}
	}
	
	
}
