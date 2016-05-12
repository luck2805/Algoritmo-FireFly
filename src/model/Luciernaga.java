package model;

import interfaces.IComportamiento;

public class Luciernaga implements IComportamiento{

	public String id;
	public char[] elementos;
	public Luciernaga(){}
	
	public Luciernaga(String unId, char[] unElemento){
		this.id = unId;
		this.elementos = unElemento;
	}
	
	public void setId(String unId){
		this.id = unId;
	}
	
	public String getId(){
		return id;
	}

	public void setElementos(char[] unElemento){
		this.elementos = unElemento;
	}
	
	public char[] getElementos(){
		return elementos;
	}
	
	
	@Override
	public int intensidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean atractivo(Luciernaga unaLuciernaga) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void desplazamiento() {
		// TODO Auto-generated method stub
		
	}

}
