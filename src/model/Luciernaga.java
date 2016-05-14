package model;

import java.util.ArrayList;
import java.util.HashMap;

import interfaces.IComportamiento;

public class Luciernaga implements IComportamiento{

	public String id;
	public ArrayList<Character> elementos;
	public Luciernaga(){}
	
	public Luciernaga(String unId, ArrayList<Character> unElemento){
		this.id = unId;
		this.elementos = unElemento;
	}
	
	public void setId(String unId){
		this.id = unId;
	}
	
	public String getId(){
		return id;
	}

	public void setElementos(ArrayList<Character> unElemento){
		this.elementos = unElemento;
	}
	
	public ArrayList<Character> getElementos(){
		return elementos;
	}
	
	
	@Override
	public int intensidad(char[] operador1, char[] operador2, char[] resultado) {
		int intensidad = 0;
		int peso = 1;
		for (int i=0; i < operador1.length; i++){
			intensidad = intensidad + ((elementos.indexOf(operador1[i]) + elementos.indexOf(operador2[i])-elementos.indexOf(resultado[i]))*peso);
			peso = peso*10;
		}
		if(operador1.length < resultado.length){
			intensidad = intensidad - (resultado[resultado.length-1]*peso);
		}
		return intensidad;
	}

	@Override
	public boolean atractivo(Luciernaga unaLuciernaga, char[] operador1, char[] operador2, char[] resultado) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void desplazamiento() {
		// TODO Auto-generated method stub
		
	}

}
