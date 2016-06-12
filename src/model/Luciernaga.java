package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Luciernaga{

    public String id;
    public HashMap<Character, Integer> elementos;
    public HashMap<Character, Integer> auxiliar;
    public int iteracion;
    public Luciernaga(){}

    public Luciernaga(String unId, HashMap<Character, Integer> unElemento){
        this.id = unId;
        this.elementos = unElemento;
        this.auxiliar = new HashMap<Character,Integer>();
        this.iteracion = 0;
	}
	
	public int getIteracion() {
		return iteracion;
	}

	public void setIteracion(int iteracion) {
		this.iteracion = iteracion;
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
	
    public int intensidad(int multiplicador, char[] operador1, char[] operador2, char[] resultado) {
    	int intensidad = 0;
    	int unOperador1 = obtenerOperando(operador1);
    	int unOperador2 = obtenerOperando(operador2);
    	int unOperador3 = obtenerOperando(resultado);

        intensidad = Math.abs((multiplicador*unOperador1) + unOperador2 - (multiplicador*unOperador3));

        return intensidad;
    }

    public int atractivo(int multiplicador, Luciernaga unaLuciernaga, char[] operador1, char[] operador2, char[] resultado) {
    	if (Math.abs(this.intensidad(multiplicador,operador1, operador2, resultado)) < Math.abs(unaLuciernaga.intensidad(multiplicador,operador1, operador2, resultado))){
            return 0; //I1>I2
    	}else 
    		if(Math.abs(this.intensidad(multiplicador,operador1, operador2, resultado)) == Math.abs(unaLuciernaga.intensidad(multiplicador,operador1, operador2, resultado))){
    			return 1;//I1=I2
    		}else{
    			return 2;    //I1<I2             
        }  
    }

    public void betaStep(Luciernaga unaLuciernaga) {
    	Random valor = new Random();
    	int unNumero = valor.nextInt(10);
    	while(!this.elementos.containsValue(unNumero)){
    		unNumero = valor.nextInt(10);
    	}
	
    	boolean bandera = true;
    	while (bandera){
            char caracter = obtenerCaracter(this.elementos, unNumero);
            if(caracter != '-'){
            	permutar(unaLuciernaga.elementos, caracter, unNumero);
            	unNumero = unaLuciernaga.elementos.get(caracter);
            }else{
                bandera = false;
            }
        }
		
    	if(!auxiliar.isEmpty()){
            Iterator it = auxiliar.entrySet().iterator();
            while(it.hasNext()){
            	Map.Entry e = (Map.Entry)it.next();
            	elementos.put((char)e.getKey(), (int)e.getValue());
            }
    	}

    	Iterator it2 = elementos.entrySet().iterator();
        	while(it2.hasNext()){
        		Map.Entry e1 = (Map.Entry)it2.next();
        		//System.out.println(e1.getKey() + " - " + e1.getValue());
        	}
    	}
	
    private char obtenerCaracter(HashMap<Character,Integer> unDiccionario, int unValor){
        Iterator it = unDiccionario.entrySet().iterator();
        char unaLetra = '-';
        while(it.hasNext()){
            Map.Entry e = (Map.Entry)it.next();
            if(unValor == (int)e.getValue()){
            	unaLetra =  (char)e.getKey();
            	break;
            }
        }
        return unaLetra;
    }
	
  //Alfa-Step
    public void alfaStep(int multiplicador,int iteracion,char[] operador1,char[] operador2,char[] operador3){
    	Random valor = new Random();
    	boolean bandera = true;
    	int unValor = 9999;
    	//Encontrar un numero aleatorio que exista
    	while(bandera){
            unValor = valor.nextInt(10);
            if(elementos.containsValue(unValor)){
            	bandera = false;
            }
    	}
    	//Encontrar la letra de ese numero aleatorio que existe
    	char unCar = obtenerCaracter(this.elementos, unValor);
    	boolean bandera2 = true;
    	//Encontrar un vlaor que no exista para la letra 
    	while (bandera2){
            unValor = valor.nextInt(10);
            if(!elementos.containsValue(unValor)){
            	bandera2 = false;
            }
    	}
    	this.elementos.put(unCar, unValor);
    	if(this.intensidad(multiplicador,operador1, operador2, operador3)==0){
            this.setIteracion(iteracion);
    	}
    }
    
	private void permutar(HashMap<Character,Integer> mejor, char unChar, int unInt){
		insertar(unChar, (int)mejor.get(unChar));
		eliminar(unChar, elementos.get(unChar));
	}
	
	private void eliminar(char unChar, int unInt){
		elementos.remove(unChar, unInt);
	}
	
	private void insertar(char unChar, int unInt){
		auxiliar.put(unChar, unInt);
	}
	
	public String toString(){
		String resultado = " ";
		Iterator it = elementos.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry e = (Map.Entry)it.next();
			resultado = resultado + e.getKey() + ":" + e.getValue() + " ";
		}
		return resultado;
	}
	
	public int obtenerOperando(char[] unOperador){
    	int peso1 = 1;
    	int operador= 0;
    	for(char unChar:unOperador){
    		operador = operador + (elementos.get(unChar) * peso1);
            peso1 = peso1*10;
    	}
    	return operador;
	}
}