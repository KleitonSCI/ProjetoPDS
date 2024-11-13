package br.com.loja.assistec.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class MensagemView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btOK;
	private int resposta;
	
	
	public MensagemView(String mensagem,int tipo) {
		setTitle("Mensagem:");
		setModal(true);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel);
		JLabel label = new JLabel(mensagem,SwingConstants.CENTER);
		panel.add(label,BorderLayout.CENTER);
		String iconPath;
		switch (tipo) {
		case 0: //erro
			iconPath="/br/com/loja/assistec/icones/erro.png";
			label.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
		case 1: //info
			iconPath="/br/com/loja/assistec/icones/info.png";
			label.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
		case 2://atencao
			iconPath="/br/com/loja/assistec/icones/alerta.png";
			label.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
		case 3://sucesso
			iconPath="/br/com/loja/assistec/icones/sucesso.png";
			label.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
		case 10:
			iconPath="/br/com/loja/assistec/icones/assistec.png";
			label.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
	}
		JPanel sul = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		sul.add(new JPanel());
		btOK = new JButton("OK");
		btOK.setPreferredSize(new Dimension(100,30));
		btOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		sul.add(btOK);
		sul.add(new JPanel());
		sul.setBorder(new EmptyBorder(10,10,10,10));
		panel.add(sul,BorderLayout.SOUTH);
		getRootPane().setDefaultButton(btOK);
		setSize(350,200);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
				
	}
	
	
	public MensagemView (String pergunta) {
		setTitle("Mensagem:");
		setModal(true);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel);
		JLabel lblPergunta = new JLabel (pergunta,SwingConstants.CENTER);
		String iconPath="/br/com/loja/assistec/icones/question.png";
		lblPergunta.setIcon(new ImageIcon(getClass().getResource(iconPath)));
		panel.add(lblPergunta,BorderLayout.CENTER);
		JPanel sul = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		JButton btSim= new JButton("Sim");
		JButton btNao = new JButton("Não");
		
		btSim.setPreferredSize(new Dimension(100,30));
		btSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resposta = 0;
				setVisible(false);
			}
		});
		btNao.setPreferredSize(new Dimension(100,30));
		btNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resposta = 1;
				setVisible(false);
			}
		});
		sul.add(btSim);
		sul.add(btNao);
		panel.add(sul,BorderLayout.SOUTH);
		setSize(350,200);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public int getResposta() {
		
		return resposta;
	}
}
