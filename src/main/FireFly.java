package main;

import model.Luciernaga;

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
		
//Cantidad de letras distintas que contiene el problema criptoaritmetico
		HashMap<Character, Integer> letras = getLetras(operador1, operador2, resultado);

//Muestra todos los caracteres distintos ingresados
	    //verLetras(letras);
		    		
//Creación de la poblacion de luciernagas		
		Luciernaga[] swarm = poblacion(3,letras);

		
//Comparar luciernagas teniendo en cuenta el brillo y el atractivo de cada una
		for (int i=0; i < swarm.length; i++){
			for (int j=0; j < swarm.length; j++){
				if(swarm[i].atractivo(swarm[j])){
					System.out.println("La luciernaga:" + i + " es mas brillante que la luciernaga:" + j);
					System.out.println("La luciernaga:" + i + " se movio con respecto a la luciernaga:" + j);
				}
			}
		}
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
	public static char[] generador(HashMap<Character, Integer> checkSum){
		HashMap<Integer, Character> mapeador = new HashMap<Integer,Character>();
		char[] letras = new char[10];
		Random valor = new Random();
	    Iterator it = checkSum.entrySet().iterator();
	    System.out.println("Esta es una Luciernaga");
	    while (it.hasNext()) {
	    	Map.Entry e = (Map.Entry)it.next();
			int valorcito = valor.nextInt(10);
			while(mapeador.containsKey(valorcito)){
				valorcito = valor.nextInt(10);
			}
			mapeador.put(valorcito, (char)e.getKey());			
	    }
	    
	    Iterator it2 = mapeador.entrySet().iterator();
	    while (it2.hasNext()){
	    	Map.Entry e2 = (Map.Entry)it2.next();
	    	letras[(int)e2.getKey()] = (char)e2.getValue(); 
	    }
//Solo para ver como se fueron asignador las letras a las posiciones
	    int i = 0;
		for(char unChar:letras){
			System.out.println(unChar + " " + i );
			i = i + 1;
		}
		return letras; 
	}
	
//Generación de la Población de Luciernagas
	public static Luciernaga[] poblacion(int habitantes, HashMap<Character, Integer> letras ){
		Luciernaga[] enjambre = new Luciernaga[habitantes];
		for (int h =0; h < enjambre.length; h++) {
			String nombre = "luciernaga" + h;
			//Esto tiene que ir dentro de la generacion de la poblacion de luciernagas para poder inicializar a cada una
			char[] vector = generador(letras);
			Luciernaga unaLuciernaga = new Luciernaga(nombre,vector);
			enjambre[h] = unaLuciernaga;
		}
		return enjambre;
	}

}