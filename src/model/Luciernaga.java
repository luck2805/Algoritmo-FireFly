package model;

import interfaces.IComportamiento;

public class Luciernaga implements IComportamiento{

	public String id;
	
	public Luciernaga(){}
	
	public Luciernaga(String unId){
		this.id = unId;
	}
	
	public void setId(String unId){
		this.id = unId;
	}
	
	public String getId(String unId){
		return id;
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
