package Modalidades;

import com.grupo10.Partido;

public interface Modalidad {
	public abstract int getPrioridad();
	public abstract boolean isPuedeJugar(Partido partido); 
}
