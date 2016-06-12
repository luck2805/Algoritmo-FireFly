package main;

import userInterface.Ventana;

public class FireFly {

	public static void main(String[] args) {

        Ventana formulario1=new Ventana();
        formulario1.setBounds(0,0,350,275);
        formulario1.setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
        formulario1.setResizable(false);
        formulario1.setVisible(true);

	}

}