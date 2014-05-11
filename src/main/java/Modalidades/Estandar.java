package Modalidades;

import com.grupo10.Partido;

public class Estandar implements Modalidad {
	@Override
	public Integer getPrioridad() {
		return Prioridad.ESTANDAR.ordinal();
	}

	@Override
	public boolean isPuedeJugar(Partido partido) {
		return true;
	}

}
