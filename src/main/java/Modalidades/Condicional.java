package Modalidades;

import com.grupo10.Partido;

public class Condicional implements Modalidad {
	@Override
	public Integer getPrioridad() {
		return Prioridad.CONDICIONAL.ordinal();
	}
	
	@Override
	public boolean isPuedeJugar(Partido partido) {
		return false;
	}

}
