package userInterface;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import model.Luciernaga;

public class SolucionDato extends AbstractTableModel {

	private List<String> contenido;

	public SolucionDato(List<String> contenido){
		this.contenido = new ArrayList<>(contenido);
	}

	@Override
    public int getColumnCount() {
		return 1;
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
        		name = "Soluciones Distintas";
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
    	String unaSolucion = contenido.get(rowIndex);
    	Object value = null;
    	switch (columnIndex) {
    		case 0:
    			value = unaSolucion;
    			break;
    	}
    	return value;
    }
	
	
}