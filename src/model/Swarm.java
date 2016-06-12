package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Swarm {

	private int iteraciones;
	private int poblacion;
	private String operador1;
	private String operador2;
	private String resultado;
	private ArrayList<String> solucion;
    private ArrayList<Luciernaga> solucion2;
    private Luciernaga[] swarm;
    private int multiplicador;
    
    public Swarm(){}
    
    public Swarm(int iteraciones, int poblacion, String operador1, String operador2, String resultado){
    	this.iteraciones = iteraciones;
    	this.poblacion = poblacion;
    	this.operador1 = operador1;
    	this.operador2 = operador2;
    	this.resultado = resultado;
    	this.solucion = new ArrayList<String>();
    	this.solucion2 = new ArrayList<Luciernaga>();
    	recorrer();
    }

    //Getters
	public int getIteraciones() {
		return iteraciones;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public String getOperador1() {
		return operador1;
	}

	public String getOperador2() {
		return operador2;
	}

	public String getResultado() {
		return resultado;
	}	
	
	public ArrayList<String> getSolucion() {
		return solucion;
	}
	
	public ArrayList<Luciernaga> getSolucion2() {
		return solucion2;
	}

	public int getMultiplicador() {
		return multiplicador;
	}	
	
	//Setters
	public void setIteraciones(int iteraciones) {
		this.iteraciones = iteraciones;
	}	
	
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public void setOperador1(String operador1) {
		this.operador1 = operador1;
	}

	public void setOperador2(String operador2) {
		this.operador2 = operador2;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public void setSolucion(ArrayList<String> solucion) {
		this.solucion = solucion;
	}

	public void setSolucion2(ArrayList<Luciernaga> solucion2) {
		this.solucion2 = solucion2;
	}

	public void setMultiplicador(int multiplicador) {
		this.multiplicador = multiplicador;
	}

	public void recorrer(){
		
	    HashMap<Character, Integer> letras = getLetras(operador1, operador2, resultado);

	    this.swarm = poblacion(poblacion,letras);

	    char[] sumando1 = operador1.toCharArray();
		char[] sumando2 = operador2.toCharArray();
		char[] total = resultado.toCharArray();

		sumando1 = reverso(sumando1);
		sumando2 = reverso(sumando2);
		total = reverso(total);

		int iteracion = 0;
		while(iteracion < iteraciones){
	            iteracion++;
	            for (int i=0; i < swarm.length; i++){
	            	for (int j=0; j < swarm.length; j++){

	                    if (i != j ){

	                    	if((swarm[i].intensidad(multiplicador,sumando1, sumando2, total) != 0) && (swarm[j].intensidad(multiplicador,sumando1, sumando2, total) != 0)){

	                            if (swarm[i].atractivo(multiplicador,swarm[j], sumando1, sumando2, total) == 0) {

	                            	swarm[j].betaStep(swarm[i]);
	                            	swarm[j].alfaStep(multiplicador,iteracion, sumando1, sumando2, total);

	                            } else if (swarm[i].atractivo(multiplicador,swarm[j], sumando1, sumando2, total) == 1) {

	                                swarm[i].alfaStep(multiplicador,iteracion, sumando1, sumando2, total);

	                            } else{

	                                swarm[i].betaStep(swarm[j]);
	                                swarm[i].alfaStep(multiplicador,iteracion, sumando1, sumando2, total);

	                            }

	                        } else if((swarm[i].intensidad(multiplicador,sumando1, sumando2, total) == 0) && (swarm[j].intensidad(multiplicador,sumando1, sumando2, total) != 0)){

	                            swarm[j].betaStep(swarm[i]);
	                            swarm[j].alfaStep(multiplicador,iteracion, sumando1, sumando2, total);

	                        } else if((swarm[i].intensidad(multiplicador,sumando1, sumando2, total) != 0) && (swarm[j].intensidad(multiplicador,sumando1, sumando2, total) == 0)){

	                            swarm[i].betaStep(swarm[j]);
	                            swarm[i].alfaStep(multiplicador,iteracion, sumando1, sumando2, total);

	                        }
	                    }
	                }
	            }
	        }

        resultados(multiplicador,swarm, sumando1, sumando2, total, solucion, solucion2);

	}
	
	
	//Generación de la Población de Luciernagas
    public Luciernaga[] poblacion(int habitantes, HashMap<Character, Integer> letras ){
    	Luciernaga[] enjambre = new Luciernaga[habitantes];
    	for (int h =0; h < enjambre.length; h++) {
            String nombre = "Luciernaga-" + h;
            Luciernaga unaLuciernaga = new Luciernaga(nombre, generador(letras));
            enjambre[h] = unaLuciernaga;
        }
    	return enjambre;
    }

	//Mapeador de Caracteres con Numeros ----> Para generar la aleatoriedad de las luciernagas
    public HashMap<Character,Integer> generador(HashMap<Character, Integer> letr){
    	HashMap<Character, Integer> mapeador = new HashMap<Character,Integer>();
    	Random valor = new Random();
        Iterator it = letr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            int valorcito = valor.nextInt(10);
            while(mapeador.containsValue(valorcito)){
            	valorcito = valor.nextInt(10);
            }
            mapeador.put((char)e.getKey(), valorcito);			
        }
        return mapeador; 
    }  

    public void resultados(int multiplicador, Luciernaga[] unEnjambre, char[] operador1, char[] operador2, char[] resultado, ArrayList<String> solucion, ArrayList<Luciernaga> solucion2){
		int cont = 0;
		for (Luciernaga unaLuciernaga:unEnjambre){
            if ((unaLuciernaga.intensidad(multiplicador,operador1, operador2, resultado) == 0)){
                if(!solucion.contains(unaLuciernaga.toString()))
                solucion.add(unaLuciernaga.toString());
                solucion2.add(unaLuciernaga);
                cont++;
                System.out.println(unaLuciernaga.toString() + " Iteracion: " + unaLuciernaga.getIteracion() + " " + unaLuciernaga.id);
                
            }
		}
		System.out.println("Luciernagas optimas: " + cont + "   " + solucion.size());
    }
    
	public HashMap<Character, Integer> getLetras(String op1, String op2, String op3){
	op1 = op1 + op2 + op3;
        HashMap<Character, Integer> caracteres = new HashMap<Character, Integer>();
        for ( int i = 0; i < op1.length(); ++i ){
            caracteres.put(op1.charAt(i), i);
        }
        return caracteres;
    }   

    public char[] reverso(char[] unOperador){
    	for (int i = 0; i < unOperador.length / 2; i++) { 
            char temp = unOperador[i];
            unOperador[i] = unOperador[unOperador.length - 1 - i]; 
            unOperador[unOperador.length - 1 - i] = temp; 
        }
    	return unOperador;
    }	
    
}
