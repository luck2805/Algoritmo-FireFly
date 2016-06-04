package userInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener {
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JButton boton1;
	
	private String operador1;
	private String operador2;
	private String operador3;
	
	public Ventana(){
		setLayout(null);
		
		//labels
		label1 = new JLabel("Operador 1");
		label2 = new JLabel("Operador 2");
		label3 = new JLabel("Resultado");
		label1.setBounds(10, 15, 200, 20);
		label2.setBounds(10, 30, 200, 20);
		label3.setBounds(10, 45, 200, 20);
		add(label1);
		add(label2);
		add(label3);
		
		text1 = new JTextField();
		text2 = new JTextField();
		text3 = new JTextField();
		text1.setBounds(220, 15, 200, 15);
		text2.setBounds(220, 30, 200, 15);
		text3.setBounds(220, 45, 200, 15);
		add(text1);
		add(text2);
		add(text3);
		
		//button
		boton1 = new JButton("Finalizar");
		boton1.setBounds(300,250,100,30);
		boton1.addActionListener(this);
		add(boton1);
		
		}
	public void actionPerformed(ActionEvent e){
		setOperador1(text1.getText());
		setOperador2(text2.getText());
		setOperador3(text3.getText());
		//System.exit(0);
	}
	
	public void setOperador1(String unOperador){
		this.operador1 = unOperador;
	}

	public void setOperador2(String unOperador){
		this.operador2 = unOperador;
	}
	public void setOperador3(String unOperador){
		this.operador3 = unOperador;
	}

	public String getOperador(){
		return this.operador1;
	}

	public String getOperador2(){
		return this.operador2;
	}
	public String getOperador3(){
		return this.operador3;
	}
	
}
