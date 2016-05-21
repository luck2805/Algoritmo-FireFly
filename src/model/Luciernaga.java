package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import interfaces.IComportamiento;

public class Luciernaga implements IComportamiento{

	public String id;
	public HashMap<Character, Integer> elementos;
	public Luciernaga(){}
	
	public Luciernaga(String unId, HashMap<Character, Integer> unElemento){
		this.id = unId;
		this.elementos = unElemento;
	}
	
	public void setId(String unId){
		this.id = unId;
	}
	
	public String getId(){
		return id;
	}

	public void setElementos(HashMap<Character, Integer> unElemento){
		this.elementos = unElemento;
	}
	
	public HashMap<Character, Integer> getElementos(){
		return elementos;
	}
	
	
	@Override
	public int intensidad(char[] operador1, char[] operador2, char[] resultado) {
		int intensidad = 0;
		int peso = 1;
		for (int i=0; i < operador1.length; i++){
			intensidad = intensidad + ((elementos.get(operador1[i]) + elementos.get(operador2[i])-elementos.get(resultado[i]))*peso);
			peso = peso*10;
		}
		if(operador1.length < resultado.length){
			intensidad = intensidad - (resultado[resultado.length-1]*peso);
		}
		return intensidad;
	}

	@Override
	public boolean atractivo(Luciernaga unaLuciernaga, char[] operador1, char[] operador2, char[] resultado) {
		if (Math.abs(this.intensidad(operador1, operador2, resultado)) <= Math.abs(unaLuciernaga.intensidad(operador1, operador2, resultado))){
			return true; //movimiento aleatorio
		}else{
			return false;//movimiento hacia la luciernaga que comparo
		}
	}

	@Override
	public void desplazamiento(char[] unOperador) {
		for(char unChar:unOperador){
			elementos.remove(unChar);
		}
		Random unRandom = new Random();
		for(char unChar:unOperador){
			int aleatorio = unRandom.nextInt(10);
			while(elementos.containsValue(aleatorio)){
				aleatorio = unRandom.nextInt(10);
			}
			elementos.put(unChar,aleatorio);
		}
	}

	@Override
	public void desplazamiento(Luciernaga unaLuciernaga){
		// TODO Auto-generated method stub
	}
	
}
