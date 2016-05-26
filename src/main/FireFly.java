package main;

import model.Luciernaga;
import userInterface.Ventana;

import java.util.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class FireFly {

	public static void main(String[] args) {
		
//Entrada del problema		
		String operador1 = getOperador();
		String operador2 = getOperador();
		String resultado = getOperador();

		char[] sumando1 = operador1.toCharArray();
		char[] sumando2 = operador2.toCharArray();
		char[] total = resultado.toCharArray();
		
		sumando1 = reverso(sumando1);	//char[]
		sumando2 = reverso(sumando2);	//char[]
		total = reverso(total);			//char[]
				
//Cantidad de letras distintas que contiene el problema criptoaritmetico
		HashMap<Character, Integer> letras = getLetras(operador1, operador2, resultado);

//Muestra todos los caracteres distintos ingresados
	    //verLetras(letras);
		    		
//Creación de la poblacion de luciernagas		
		Luciernaga[] swarm = poblacion(50,letras);

		
//Comparar luciernagas teniendo en cuenta el brillo y el atractivo de cada una
		for (int i=0; i < swarm.length; i++){
			for (int j=0; j < swarm.length; j++){
				if ((i!=j)&&(swarm[i].intensidad(sumando1, sumando2, total)!=0)){
					if (swarm[i].atractivo(swarm[j], sumando1, sumando2, total)){
						//movimiento aleatorio
						swarm[i].alfaStep();
					}else{
						//acercar luciernaga i a j
						swarm[i].desplazamiento(swarm[j]);
						swarm[i].alfaStep();
					}
				}
			}
		}

//Mostrar el valor de todas las luciernagas al finalizar todo
		for(int z = 0 ; z < swarm.length ; z++){
			System.out.println(swarm[z].id);
			System.out.println(swarm[z].intensidad(sumando1, sumando2, total));
			verLetras(swarm[z].elementos);
		}
		
		Ventana ventana=new Ventana();
		ventana.setBounds(0,0,450,350);
		ventana.setVisible(true);
		ventana.setResizable(false);
		
	}

//Carga de Valores por Pantalla
	public static String getOperador(){	
        System.out.println("Introducir un Operador");
        Scanner entradaEscaner = new Scanner(System.in);
        String entradaTeclado = entradaEscaner.nextLine().toUpperCase();
        return entradaTeclado;
	}
	
//Determinacion del dominio del problema ----> Cantidad de letras distintas que posee el problema criptoaritmetico
	public static HashMap<Character, Integer> getLetras(String op1, String op2, String op3){
		op1 = op1 + op2 + op3;
	    HashMap<Character, Integer> caracteres = new HashMap<Character, Integer>();
	    for ( int i = 0; i < op1.length(); ++i ){
	        caracteres.put(op1.charAt(i), i);
	    }
	    return caracteres;
	}
	
//Mostrar las distintas letras que conforman el problema	
	public static void verLetras(HashMap<Character,Integer> caracteres){
	    Iterator it = caracteres.entrySet().iterator();
	    while (it.hasNext()) {
	    	Map.Entry e = (Map.Entry)it.next();
	    	System.out.println(e.getKey() + " " + e.getValue());
	    }    
	}
	
//Mapeador de Caracteres con Numeros ----> Para generar la aleatoriedad de las luciernagas
	public static HashMap<Character,Integer> generador(HashMap<Character, Integer> checkSum){
		HashMap<Character, Integer> mapeador = new HashMap<Character,Integer>();
		Random valor = new Random();
	    Iterator it = checkSum.entrySet().iterator();
	    System.out.println("Esta es una Luciernaga");
	    while (it.hasNext()) {
	    	Map.Entry e = (Map.Entry)it.next();
			int valorcito = valor.nextInt(10);
			while(mapeador.containsValue(valorcito)){
				valorcito = valor.nextInt(10);
			}
			mapeador.put((char)e.getKey(), valorcito);			
	    }
//Solo para ver como se fueron asignador las letras a las posiciones
	    verLetras(mapeador);		
		return mapeador; 
	}
	
//Generación de la Población de Luciernagas
	public static Luciernaga[] poblacion(int habitantes, HashMap<Character, Integer> letras ){
		Luciernaga[] enjambre = new Luciernaga[habitantes];
		for (int h =0; h < enjambre.length; h++) {
			String nombre = "Luciernaga-" + h;
			Luciernaga unaLuciernaga = new Luciernaga(nombre, generador(letras));
			enjambre[h] = unaLuciernaga;
		}
		return enjambre;
	}

	public static char[] reverso(char[] unOperador){
		for (int i = 0; i < unOperador.length / 2; i++) { 
			char temp = unOperador[i];
			unOperador[i] = unOperador[unOperador.length - 1 - i]; 
			unOperador[unOperador.length - 1 - i] = temp; 
		}

		return unOperador;
	}

	public static ArrayList<Character> convertidor(char[] unVector){
		ArrayList<Character> resultado = new ArrayList<Character>();
		for (char unChar:unVector){
			resultado.add(unChar);
		}
		return resultado;
	}

}