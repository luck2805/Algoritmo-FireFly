package userInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener {
	
	private JLabel texto1;
	private JLabel texto2;
	private JButton boton1;
	
	public Ventana(){
		setLayout(null);
		
		//labels
		texto1 = new JLabel("Algoritmo de Luciernagas");
		texto2 = new JLabel("Acá va toda la Black Magic!!!");
		texto1.setBounds(100, 100, 200, 40);
		texto2.setBounds(70, 40, 200, 40);
		add(texto1);
		add(texto2);
		
		//button
		boton1 = new JButton("Finalizar");
		boton1.setBounds(300,250,100,30);
		boton1.addActionListener(this);
		add(boton1);
		
		}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==boton1){
			System.exit(0);
		}

}

}
