package userInterface;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import model.Luciernaga;

public class Datos extends AbstractTableModel {

	private List<Luciernaga> contenido;

	public Datos(List<Luciernaga> contenido){
		this.contenido = new ArrayList<>(contenido);
	}

	@Override
    public int getColumnCount() {
		return 3;
    }

    @Override
    public int getRowCount() {
    	return contenido.size();
    }
        
    @Override
    public String getColumnName(int column) {
    	String name = "??";
        switch (column) {
        	case 0:
        		name = "Número de Luciernaga";
                break;
          	case 1:
                name = "Número de Iteración";
                break;
        	case 2:
        		name = "     Solución Encontrada     ";
        		break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
    	Class type = String.class;
        switch (columnIndex) {
        	case 0:
            case 1:
            	type = Integer.class;
            	break;
        }
        return type;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	Luciernaga unaLuciernaga = contenido.get(rowIndex);
    	Object value = null;
    	switch (columnIndex) {
    		case 0:
    			value = unaLuciernaga.getId();
    			break;
    		case 1:
    			value = unaLuciernaga.getIteracion();
    			break;
    		case 2:
    			value = unaLuciernaga.toString();
    			break;

    	}
    	return value;
    }

}

