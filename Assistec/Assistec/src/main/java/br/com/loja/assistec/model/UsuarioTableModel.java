package br.com.loja.assistec.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class UsuarioTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private static final String[] colunas = {"ID","Nome","Telefone","Login","Perfil"};
	private ArrayList<Usuario> usuariosList;
	public UsuarioTableModel(ArrayList<Usuario> usuarios) {
		this.usuariosList = usuarios;
	}
	@Override
	//Conta No de linhas
	public int getRowCount() {
		return usuariosList.size();
	}
	//conta No de colunas
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario usuario = usuariosList.get(rowIndex);
		if(columnIndex==0) {
			return usuario.getIduser();
		}
		else {
			if(columnIndex==1) {
				return usuario.getNome();
			}
			else {
				if(columnIndex==2) {
					return usuario.getFone();
				}
				else {
					if(columnIndex==3) {
						return usuario.getLogin();
					}
					else {
						if(columnIndex==4) {
							return usuario.getPerfil();
						}
						else {
							return null;
						}
					}
				}
			}
		}
	}
	//retorna nome da coluna e inserir no table
	public String getColumnName(int coluna) {
		return colunas[coluna];
	}
	
}
