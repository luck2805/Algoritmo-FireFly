package main;

import model.Luciernaga;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FireFly {

	public static void main(String[] args) {
		
		//Entrada del problema		
		String operador1 = getOperador();
		String operador2 = getOperador();
		String resultado = getOperador();
		
		//Cantidad de elementos distintos
		char[] todos = (operador1 + operador2 + resultado).toCharArray();
/*		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int i=0;
		for(char unChar:todos){
			map.put(( , i);
			i++;
		}
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
		  Integer key = it.next();
		  System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
		}
**/		
		
		//Falta Generar el valor de las luciernagas de forma aleatoria	
		Luciernaga[] swarm = new Luciernaga[50];
		for (int h =0; h < swarm.length; h++) {
			String nombre = "luciernaga" + h;
			Luciernaga unaLuciernaga = new Luciernaga(nombre);
			swarm[h] = unaLuciernaga;
		}
		
		//Comparar luciernagas
/*		for (int i=0; i < swarm.length; i++){
			for (int j=0; j < swarm.length; j++){
				
				if(swarm[i].atractivo(swarm[j])){
					System.out.println("La luciernaga:" + i + " es mejor que la ljuciernaga:" + j);
					//Mover Luciernagas
				}
				
			}
		}*/
		
	}

	public static String getOperador(){
		
        System.out.println("Introducir un Operador");
        Scanner entradaEscaner = new Scanner(System.in);
        String entradaTeclado = entradaEscaner.nextLine().toUpperCase();
        return entradaTeclado;
	
	}
	
}
