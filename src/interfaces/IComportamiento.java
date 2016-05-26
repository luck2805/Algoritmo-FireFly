package interfaces;

import model.Luciernaga;

public interface IComportamiento {

	public int intensidad(char[] op1, char[] op2, char[] result);
	public boolean atractivo(Luciernaga unaLuciernaga, char[] op1, char[] op2, char[] result);
	public void desplazamiento(Luciernaga unaLuciernaga);
	
}
