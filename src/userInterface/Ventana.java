package userInterface;

import javax.swing.*;

public class Ventana extends JFrame{
	
	private JLabel texto1;
	private JLabel texto2;
	
	public Ventana(){
		setLayout(null);
		texto1 = new JLabel("Algoritmo de Luciernagas");
		texto2 = new JLabel("Acá va toda la Black Magic!!!");
		texto1.setBounds(100, 100, 200, 40);
		texto2.setBounds(70, 40, 200, 40);
		add(texto1);
		add(texto2);
	}

}
