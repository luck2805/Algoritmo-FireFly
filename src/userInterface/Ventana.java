package userInterface;

import model.Swarm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ventana extends JFrame implements ActionListener{

	private JLabel label1, label2, label3, label4, label5;
	private JTextField text1, text2, text3, text4, text5;
	private JButton suma, resta;
	private JSpinner iteracion, poblacion;

	public Ventana(){
	super("Inteligencia Artificial - 2016");

		//labels
		label1 = new JLabel("Primer Operando",SwingConstants.CENTER);
		label2 = new JLabel("Segundo Operando",SwingConstants.CENTER);
		label3 = new JLabel("Resultado",SwingConstants.CENTER);	
		label4 = new JLabel("N° de Iteraciones",SwingConstants.CENTER);
		label5 = new JLabel("N° de Luciérnagas",SwingConstants.CENTER);

		//textFields
		text1 = new JTextField();
		text2 = new JTextField();
		text3 = new JTextField();
		text4 = new JTextField();
		text5 = new JTextField();

		//Spinner
		SpinnerModel modelIteraciones = new SpinnerNumberModel(10, 1, 1000, 1);
		SpinnerModel modelPoblacion = new SpinnerNumberModel(50, 1, 9999, 1);
		iteracion = new JSpinner(modelIteraciones);
		poblacion = new JSpinner(modelPoblacion);

		//buttons
		suma = new JButton("Sumar");
		suma.addActionListener(this);
		resta = new JButton("Restar");
		resta.addActionListener(this);

		//Panel de datos
		JPanel panelDatos = new JPanel();
	    	GridLayout gl = new GridLayout(5,2,0,4);
	    		panelDatos.setLayout(gl);
	    		panelDatos.add(label4);
	    		panelDatos.add(iteracion);
	    		panelDatos.add(label5);
	    		panelDatos.add(poblacion);
	    		panelDatos.add(label1);
	    		panelDatos.add(text1);
	    		panelDatos.add(label2);
	    		panelDatos.add(text2);
	    		panelDatos.add(label3);
	    		panelDatos.add(text3);
	    		//Panel de botones
	    JPanel panelBotones = new JPanel();
	    		panelBotones.setLayout(new FlowLayout());
	    		panelBotones.add(suma);
	    		panelBotones.add(resta);
	    Container cp = getContentPane();
	    	cp.add(panelDatos, BorderLayout.CENTER);
	    	cp.add(panelBotones, BorderLayout.SOUTH);	

	}

	public void actionPerformed(ActionEvent e) {
		
		if((!text1.getText().isEmpty())&&(!text2.getText().isEmpty())&&(!text3.getText().isEmpty())){
			if(((text1.getText().length()>=3)&&(text1.getText().length()<=5))&&((text2.getText().length()>=3)&&(text2.getText().length()<=5))&&((text3.getText().length()>=3)&&(text3.getText().length()<=5))){
				String operador1 = text1.getText().toUpperCase();
				String operador2 = text2.getText().toUpperCase();
				String resultado = text3.getText().toUpperCase();
				int iteraciones = (Integer)this.iteracion.getValue();
				int poblacion = (Integer)this.poblacion.getValue();
		
				Swarm enjambre = new Swarm(iteraciones, poblacion, operador1, operador2, resultado);
		
				if (e.getSource() == suma){
					//multiplica por +1
					enjambre.setMultiplicador(1);
				}
				if (e.getSource() == resta){
					//multiplica por -1
					enjambre.setMultiplicador(-1);
				}
				enjambre.recorrer();
				if(!enjambre.getSolucion().isEmpty()){
					Datos dato = new Datos(enjambre.getSolucion2());
					JTable table = new JTable(dato);
		
					SolucionDato sDato = new SolucionDato(enjambre.getSolucion());
					JTable table2 = new JTable(sDato);			
					
					JFrame frame = new JFrame("Soluciones Obtenidas");
			        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame.add(new JScrollPane(table),BorderLayout.CENTER);
			        frame.add(new JScrollPane(table2), BorderLayout.WEST);
			        frame.pack();
			        frame.setExtendedState(frame.MAXIMIZED_BOTH);
			        //frame.setBounds(0, 300, 800, 600);
			        frame.setLocationRelativeTo(null);
			        frame.setVisible(true);
				
				}else{
					JFrame frame = new JFrame("Sin solucion");
					JOptionPane.showMessageDialog(frame, "No se ha encontrado una solución");
				}
			}else{
				JFrame frame = new JFrame("Formatos no validos");
				JOptionPane.showMessageDialog(frame, "La longitud de los operadores debe ser de 3 a 5 caracteres");					
			}
		}else{
			JFrame frame = new JFrame("Campos Requeridos");
			JOptionPane.showMessageDialog(frame, "Faltan datos");	
		}

	}

	//Determinacion del dominio del problema ----> Cantidad de letras distintas que posee el problema criptoaritmetico
	public HashMap<Character, Integer> getLetras(String op1, String op2, String op3){
	op1 = op1 + op2 + op3;
        HashMap<Character, Integer> caracteres = new HashMap<Character, Integer>();
        for ( int i = 0; i < op1.length(); ++i ){
            caracteres.put(op1.charAt(i), i);
        }
        return caracteres;
    }

}